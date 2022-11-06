# springboot-graphql-kotlin
> GraphQL API server with Spring Boot, Spring Data JPA, Gradle, Kotlin

## Tech specs 🔖

- Java `8`
- Gradle `7.0.2`
- Spring Boot `2.5.0`
- Spring Data JPA `1.5.10`
- Kotlin `1.5.10`
- PostgreSQL `42.5.0`


## Database creation

Create database in PostgreSQL:

```sql
CREATE DATABASE kotlin_demo;
```

Create schema in PostgreSQL:

```sql
CREATE SCHEMA IF NOT EXISTS kotlin_demo;
```

## Run

```sh
gradle build
```

```sh
gradle bootRun
```
