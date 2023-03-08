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
