# Joker'18 Samples
## `@EnableScheduling` Sample
### Описание

Этот пример демонстрирует поведение методов с аннотацией `@Scheduled` 
в разных версиях Spring Boot при наличии и отсутствии стартера для 
Spring Boot Actuator. Один из классов этого стартера в версиях 1.х содержал
на себе аннотацию `@EnableScheduling`, благодаря чему ее необязательно было 
указывать в прикладном  коде приложения, и методы `@Scheduled` работали. 
Однако в версиях 2.х, в связи с переходом на фреймворк 
[Micrometer](http://micrometer.io), эта аннотация была снята с библиотечного
класса, поэтому ее потребовалось добавлять вручную в прикладной код 
(как изначально и требовала документация).  

#### Сводка поведений в различных версиях 

|Spring Boot|Actuator|Нужен @EnableScheduling?
|---|---|---|
|1.x| нет | Да
|1.x| есть | Нет
|2.x| нет | Да
|2.x| есть | Да

**Вывод**: Аннотацию `@EnableScheduling` лучше добавить в прикладной код 
в любом случае, независимо от версии фреймворка и набора его подключенных
компонентов. Дублирование аннотации не приводит к ошибку.

### Воспроизведение
Запуск примера производится через класс `EnableSchedulingDemoApplication`.
#### Ошибочное поведение

1. Выставить версию Spring Boot `2.0.2.RELEASE` в файле 
   `enable-scheduling/gradle.properties`.
2. Запустить пример. Приложение должно корректно запуститься, но в 
логах не должно быть периодических записей вида
```text
INFO 108804 --- [pool-1-thread-1] .t.s.j.s.EnableSchedulingDemoApplication : Another 3000 milliseconds have passed...
```

#### Корректное поведение

1. На выбор:  
    a. Выставить версию Spring Boot `1.5.4.RELEASE` в файле 
          `enable-scheduling/gradle.properties`.  
_или_  
    b. Раскомментировать аннотацию `@EnableScheduling` на классе 
`EnableSchedulingDemoApplication`.
2. Запустить пример. В логах каждые три секунды должна появляться запись
```text
INFO 108804 --- [pool-1-thread-1] .t.s.j.s.EnableSchedulingDemoApplication : Another 3000 milliseconds have passed...
```
