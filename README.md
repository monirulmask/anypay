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
gradle build -x test
```

```sh
gradle bootRun
```

Use the below query and mutations.

```
query {
  sales(startDateTime: "2022-09-01T02:00:00Z", endDateTime: "2022-09-08T09:58:00Z") {
    points
    datetime
    sales
  }
}

mutation {
  newSale(price: "1000.00", price_modifier: 0.98, payment_method: VISA, datetime: "2022-09-01T09:00:00Z") {
    final_price
    points
  }
}
```