# Joker'18 Samples
## Relax Binding Sample
### Описание

Этот пример демонстрирует различия в поведении relax binding в различных 
версиях Spring Boot. В частности, показывает, что в версии 2.х первоисточником
для сопоставления стали `get`-теры.

### Воспроизведение
Запуск примера производится через класс `RelaxBindingDemoApplication`.
#### Ошибочное поведение

1. Выставить версию Spring Boot `2.0.2.RELEASE` в файле 
`relax-binding/gradle.properties`.
2. Запустить пример. Приложение не должно запуститься из-за ошибки вида
```text
Failed to bind properties under 'security' to tech.toparvion.sample.joker18.relax.SecurityProperties:

    Property: security.keystoretype
    Value: jks
    Origin: class path resource [application.properties]:2:23
    Reason: No setter found for property: key-store-type
```

#### Корректное поведение

1. На выбор:  
    a. Выставить версию Spring Boot `1.5.4.RELEASE` в файле 
       `relax-binding/gradle.properties`.  
_или_  
    b. Переименовать в классе `SecurityProperties` метод из 
    `getKeyStoreType` в `getKeystoreType`.
2. Запустить пример. Приложение должно запуститься и тут же корректно 
завершить свою работу, выведя в лог запись вида:
```text
INFO 119696 --- [main] t.t.s.j.r.RelaxBindingDemoApplication    : keystore type: jks
```
