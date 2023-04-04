# muon-test
Тестовое задание для компании [Muon](https://muon.ru/)

## Требования
Чтобы собрать и запустить приложение необходимо:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)
- [Spring Boot 3.0.4](https://start.spring.io/) со следующими стартерами:
  - Liquibase
  - PostgreSQL
  - Spring Data JPA
  - Validation

## Запуск приложения локально
- Чере терминал `java -jar muon-test-0.0.1-SNAPSHOT.jar`
- Запустить в IDE `main` из класса `com.example.muontest.MuonTestApplication` 
- Используя [Spring Boot Maven plugin](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-maven-plugin) `mvn spring-boot:run`

## TODO's
- Unit Testing
- Использовать готовую библиотеку для маппинга (ModelMapper или MapStruct)
-----------------------------

# Описание задания

Технологии:
•	Java версии >= 8 
•	Spring Boot (standalone приложение)
•	СУБД PostgreSQL (версия не важна)
•	Liquibase для версионирования схемы БД
•	Сборка проекта через Maven
•	Конфигурация приложения через application.yml

Требования:
1.	Создать 2 таблицы в БД через Liquibase:
  - Car {id: Long PK,  driver_name: String,  brand: String,  garage_id: Long FK}
  - Garage: {id: Long PK, name: String}
2.	Создать следующие методы REST API:
  - GET /api/garage – возвращает массив всех записей из таблицы garage 
  - GET /api/garage/{id} – возвращает объект Garage в виде JSON с вложенным списком машин в нем
  - POST /api/garage – сохраняет новый объекта Garage, передача названия в теле запроса в виде JSON
  - GET /api/car – возвращает массив всех записей из таблицы car 
  - GET /api/car/{id} – возвращает объект Car в виде JSON 
  - POST /api/car – сохранение нового объекта Car, передача данных в теле запроса в виде JSON
3.	Валидировать входные данные полей driver_name и brand на наличие только букв, иначе возвращать 400 BAD REQUEST с указанием проблемного поля
4.	Валидировать id гаража перед сохранением, если такого в базе нет, возвращать 400
5.	Через конфигурационный параметр контролировать вместимость гаража, при попытке добавить новую машину в полный гараж возвращать 400 с описанием ошибки
