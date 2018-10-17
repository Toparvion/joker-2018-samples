# Joker'18 Samples
Здесь собраны несколько образцов, воспроизводящих различные особенности обновления фреймворка Spring Boot с
версии 1 на 2, а также [привносимых им библиотек](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-dependencies/pom.xml).
Образцы собираются для демонстрации на [одном из докладов](https://jokerconf.com/2018/talks/2ixtotkht6eksa6guii6yq/)
конференции [Joker](https://jokerconf.com/) в 2018 году в г. Санкт-Петербурге.

## Состав репозитория
- [Content-Type Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/content-type)  
Пример некорректного определения ответного заголовка `Content-Type`
- [Enable Scheduling Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/enable-scheduling)  
Пример отказа в работе заданий по расписанию из-за изменений в модуле Spring Boot Actuator
- [SpringCloud & Co. Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/hikari-javamelody)  
Пример сбоя на старте приложения из-за конфликта библиотек
- [JMX Resource Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/jmx-resource)  
Пример сбоя в выставлении бинов по JMX из-за некорректного обёртывания в прокси
- [Relax Binding Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/relax-binding)  
Пример поломки при старте приложения из-за изменившихся правил привязки переменных окружения
- [Mockito 2.x Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/mockito-2)  
Пример провала тестов из-за отличий в семантике различных версий Mockito  
- [Spring Boot Gradle Plugin Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/gradle-plugin)  
Пример провала сборки и некорректного формирования манифеста JAR-файла 
- _(можно добавлять новые)_
 

## Дополнения приветствуются
Если у вас есть пример другого неординарного кейса, связанного с версией Spring Boot 2.х, и вы хотите поделиться им с 
миром, смело оформляйте его в [pull request](https://github.com/Toparvion/joker-2018-samples/pulls)!  
Если же вы просто хотите уточнить или дополнить уже существующий пример, это можно сделать либо также через 
[pull request](https://github.com/Toparvion/joker-2018-samples/pulls), либо посредством 
[заявки](https://github.com/Toparvion/joker-2018-samples/issues).     