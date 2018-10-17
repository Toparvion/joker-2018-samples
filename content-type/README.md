# Joker'18 Samples
## Content-Type Sample
### Описание

Пример демонстрирует особенности определения ответного заголовка `Content-Type` в Spring Framework и Spring Boot. В 
частности, показывает, как различается умолчательное отношение к расширению запрашиваемого файла в Spring Framework 
4/5 и Spring Boot 2. 

### Воспроизведение
Запуск примера производится через класс `ContentTypeDemoApplication`.

#### Ошибочное поведение

1. Выставить версию Spring Boot `2.0.4.RELEASE` в файле `content-type/build.gradle`.
2. Запустить приложение.
3. Выполнить серию HTTP GET запросов к приложению:  
   1. `/download/document.html`   
   1. `/download/document.json`   
   1. `/download/document.txt`   
4. Во всех трёх случаях тело ответа должно соответсвовать запрошенному расширению, однако заголовок `Content-Type` 
должен быть одним и тем же: `text/html`.

#### Корректное поведение

1. На выбор: 
    * Выставить версию Spring Boot `1.5.14.RELEASE` в файле `content-type/build.gradle`.
    * Добавить/раскомментировать в файле `application.properties` строку  
    `spring.mvc.contentnegotiation.favor-path-extension=true`
2. Запустить приложение.
3. Выполнить серию HTTP GET запросов к приложению:  
   1. `/download/document.html`   
   1. `/download/document.json`   
   1. `/download/document.txt`   
4. Во всех трёх случаях тело ответа и заголовок `Content-Type` должны соответсвовать запрошенному расширению.
