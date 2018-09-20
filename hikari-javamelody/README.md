# Joker'18 Samples
## HikariCP+Javamelody Sample
### Описание

Этот пример демонстрирует падение приложения при старте в случае
использования в нем сочетания следующих библиотек:
- HikariCP (пул соединений с БД)
- Javamelody (встраиваемый мониторинг производительности)
- Spring Cloud Config+Netflix Eureka Client (поддержка cloud-native приложений)

### Воспроизведение
Запуск примера производится через класс `HikariJavamelodyDemoApplication`.

#### Ошибочное поведение
1. Выставить в `build.gradle` следующие версии фреймворков:
```groovy
springBootVersion = '2.0.4.RELEASE'
springCloudVersion = '2.0.1.RELEASE'
```
2. Удалить/закомментировать в `build.gradle` строку:
```groovy
// runtime group: 'org.apache.tomcat', name: 'tomcat-jdbc', version: '8.5.29'
```
3. Удалить/закомментировать в `application.properties` строку:
```properties
# spring.datasource.type=org.apache.tomcat.jdbc.pool.DataSource
```

4. Запустить приложение. Запуск должен оборваться ошибкой с причиной:
```text
Caused by: java.lang.ClassCastException: com.sun.proxy.$Proxy74 cannot be cast to com.zaxxer.hikari.HikariDataSource
```

#### Корректное поведение
##### Способ 1 _(через откат пула к Tomcat)_
1. Добавить/раскомментировать в `build.gradle` строку:
```groovy
runtime group: 'org.apache.tomcat', name: 'tomcat-jdbc', version: '8.5.29'
```
2. Добавить/раскомментировать в `application.properties` строку:
```properties
spring.datasource.type=org.apache.tomcat.jdbc.pool.DataSource
```
3. Запустить приложение. Приложение должно корректно стартовать;
    мониторинг Javamelody должен быть доступен по адресу
    http://localhost:8080/monitoring.

##### Способ 2 _(через понижение версий)_
1. Выставить в `build.gradle` следующие версии компонентов:
```groovy
springBootVersion = '1.5.14.RELEASE'
springCloudVersion = '1.4.5.RELEASE'
```
2. Удалить/закомментировать в `build.gradle` строку:
```groovy
// runtime group: 'org.apache.tomcat', name: 'tomcat-jdbc', version: '8.5.29'
```
3. Удалить/закомментировать в `application.properties` строку:
```properties
# spring.datasource.type=org.apache.tomcat.jdbc.pool.DataSource
```
4. Запустить приложение. Приложение должно корректно стартовать;
    мониторинг Javamelody должен быть доступен по адресу
    http://localhost:8080/monitoring.

##### Способ 3 _(через отключение JDBC мониторинга в Javamelody)_
1. Добавить/раскомментировать в `application.properties` строку:
```properties
javamelody.excluded-datasources=scopedTarget.dataSource
```
2. Запустить приложение. Приложение должно корректно стартовать;
 мониторинг Javamelody должен быть доступен по адресу
 http://localhost:8080/monitoring, однако не должен предоставлять данных
 о соединениях с БД и выполняемых SQL запросах.