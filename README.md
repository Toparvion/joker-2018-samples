# Joker'18 Samples
Здесь собраны несколько образцов, воспроизводящих различные особенности обновления фреймворка Spring Boot с
версии 1 на 2, а также [привносимых им библиотек](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-dependencies/pom.xml).
Образцы собираются для демонстрации на [одном из докладов](https://jokerconf.com/2018/talks/2ixtotkht6eksa6guii6yq/)
конференции [Joker](https://jokerconf.com/) в 2018 году в г. Санкт-Петербург.

## Состав репозитория
- [Relax Binding Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/relax-binding)  
Пример поломки при старте приложения из-за изменившихся правил привязки переменных окружения
- [Enable Scheduling Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/enable-scheduling)  
Пример отказа в работе заданий по расписанию из-за изменений в модуле Spring Boot Actuator
- [Autowire Proxy Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/autowire-proxy)  
Пример поломки на попытке внедрения проксированного бина из-за изменившегося способа проксирования
- [HikariCP JavaMelody SpringCloud Sample](https://github.com/Toparvion/joker-2018-samples/tree/master/hikari-javamelody)  
Пример сбоя на старте приложения из-за конфликта библиотек
- _(будут добавлены и другие)_
 
## Статус проекта
Проект еще находится в стадии наполнения. В любой из образцов еще могут быть внесены изменения.   
Если у вас есть предложения по дополнению проекта новыми полезными и интересными образцами, милости просим 
к нам в [заявки](https://github.com/Toparvion/joker-2018-samples/issues) или 
[pull request'ы](https://github.com/Toparvion/joker-2018-samples/pulls).