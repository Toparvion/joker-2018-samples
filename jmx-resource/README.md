# Joker'18 Samples
## JMX Resource Sample
### Описание

Пример демонстрирует сбой в выставлении бинов по JMX при определенном сочетании проксирующих обёрток. Конкретнее, бин
 `myJmxResource` оказывается недоступен по JMX в результате совместных действий двух BeanPostProcessor'ов: 
 `AsyncAnnotationBeanPostProcessor` и `DefaultAdvisorAutoProxyCreator`.   
Пример написан таким образом, чтобы не зависеть от номера версии Spring Boot; вместо этого определяющим фактором 
является первая буква имени класса `[Poincut]AdvisorConfig`.

### Воспроизведение
Запуск примера производится через класс `JmxResourceDemoApplication`.

#### Ошибочное поведение

1. Убедиться, что единственный `@Configuration`-класс в проекте имеет имя `PointcutAdvisorConfig`.
2. Запустить приложение. Запуск должен быть успешным, никаких ошибок в логах быть не должно, однако и бин 
`myJmxResource` не должен быть доступен по JMX.  
Дополнительно можно раскомментировать строку `JmxResourceDemoApplication:10`. В этом случае запуск приложения должен 
завершиться ошибкой:
```text
org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'myJmxResource' is expected to be 
of type 'tech.toparvion.sample.joker18.jmx.MyJmxResource' but was actually of type 'com.sun.proxy.$Proxy57'
``` 
    
#### Корректное поведение

1. Переименовать единственный `@Configuration`-класс в проекте в `AdvisorConfig` (удалить префикс `Pointcut`).
2. Запустить приложение. Запуск должен быть успешным, никаких ошибок в логах быть не должно и бин 
`myJmxResource` должен быть доступен по JMX.
    