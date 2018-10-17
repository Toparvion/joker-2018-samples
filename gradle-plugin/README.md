# Joker'18 Samples
## Spring Boot Gradle Plugin Sample
### Описание

Пример демонстрирует ошибки сборки и запуска приложений на основе Spring Boot Gradle Plugin 2.x. Конкретнее, 
показывается невозможность выполнения компиляции и некорректное формирование манифеста JAR-файла. 

### Воспроизведение
Все дальнейшие шаги выполняются над отдельным Gradle-проектом в директории `gradle-plugin`.   
Проект не имеет собственного
Gradle Wrapper'а, но при вызове его команд можно указать на локальную инсталляцию Gradle, полученную из основного 
проекта `joker-2018-samples` (по умолчанию она лежит в директории `~/.gradle/wrapper/dists/`). 

#### Ошибочное поведение

0 _Если сборка уже проходила успешно_, то предварительно выполнить команду `gradle clean`. 
1. Удалить/закомментировать в файле `build.gradle` строки 19-20:
```groovy
//}
//configure(subprojects.findAll { it.name != 'lib' }) {
```  
2. Удалить/закомментировать в файле `lib/build.gradle` всё содержимое.
3. Выполнить команду `gradle build`.  
Сборка должна провалиться с ошибками:
```text
> Task :app1:compileJava FAILED
joker-2018-samples\gradle-plugin\app1\src\main\java\tech\toparvion\sample\joker18\gradle\app1\GradlePluginDemoApplication.java:9: error: package tech.toparvion.sample.joker18.gradle.lib does not exist
import tech.toparvion.sample.joker18.gradle.lib.Util;
                                               ^
joker-2018-samples\gradle-plugin\app1\src\main\java\tech\toparvion\sample\joker18\gradle\app1\GradlePluginDemoApplication.java:21: error: cannot find symbol
    String appVersion = Util.getAppVersion(getClass());
                        ^
  symbol:   variable Util
  location: class GradlePluginDemoApplication
2 errors
```

#### Корректное поведение

##### Способ 1 _(через корневой скрипт сборки)_

1. Раскомментировать/добавить в файл `build.gradle` строки 19-20:
```groovy
}
configure(subprojects.findAll { it.name != 'lib' }) {
```
2. Выполнить команду `gradle build`. Сборка должна завершиться успешно. 

##### Способ 2 _(через скрипт сборки подпроекта `lib`)_

1. Раскомментировать/добавить в файл `lib/build.gradle` строки:
```groovy
jar {
    enabled = true
}
bootJar {
    enabled = false
}
```
2. Выполнить команду `gradle build`. Сборка должна завершиться успешно. 

##### Дополнение
Даже после успешной сборки приложение не сможет корректно определять свою версию путем обращения к методу 
`java.lang.Package.getImplementationVersion`, так как в сформированном JAR-файле отсутствует соответствующий атрибут.
Чтобы атрибут появился, необходимо в строке 22 файла `build.gradle` заменить объект `jar` на `bootJar`, т. е. код 
должны выглядеть так:
```groovy
    bootJar {
        archiveName = "${project.name}.jar"
        // прочие свойства формируемого JAR-файла
    }
``` 