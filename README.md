# 📝 Legacy Todo App – Spring Boot 2 + Hibernate + SQLite

This is a deliberately **outdated Todo application** built with legacy Java and Spring technologies. It serves as a sandbox for testing **automated code migration** and **refactoring using GenAI tools** (e.g., LLM-based assistants).

---

## ✅ Technologies Used

- Java 11
- Spring Boot `2.1.0.RELEASE`
- Spring Web MVC
- Spring Data JPA (`CrudRepository`)
- Hibernate ORM `5.3.7.Final`
- SQLite (JDBC `3.28.0`)
- JUnit 5, Spring Boot Test

---

### 1. Requirements

- Java 11 or newer
- Maven 3.6+

### 2. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

### 3. Available endpoints

| Method | Endpoint | Description            |
|--------|----------|------------------------|
| GET    | `/todos` | Fetch all todo items   |
| POST   | `/todos` | Create a new todo item |

#### Example for adding a todo

```json
{
  "title": "Migrate to Spring Boot 3",
  "completed": false
}
```

### 4. Project Structure
```text
src/
├── main/
│   ├── java/com/example/todo/
│   │   ├── controller/
│   │   │   └── HelloController.java         # basic ping endpoint
│   │   ├── entity/
│   │   │   └── TodoItem.java                # todo entity with ID, title, completed
│   │   ├── repository/
│   │   │   └── TodoRepository.java          # extends CrudRepository
│   │   └── service/
│   │       └── TodoService.java             # simple service class
│   └── resources/
│       └── application.properties           # DB config for SQLite
└── test/
    └── java/com/example/todo/
        └── TodoTests.java                   # integration test for repository

```
### 5. Known issues and migration challenges

This project includes deliberate technical debt and legacy practices, useful for training AI or developers to detect and modernize codebases:

- No use of DTOs (entity is exposed directly)
- Business logic partially in controller
- Field injection using @Autowired (discouraged)
- No @Valid or request validation
- No error handling (e.g. @ControllerAdvice)
- SQLite used as production-like database (rare and unsupported officially in Spring Boot)
- Hibernate uses a non-official dialect for SQLite compatibility
- Minimal use of interfaces or abstraction
- No pagination or filtering
- Single-layer repository design (CrudRepository only)
- These issues are great examples for:
- Migrating to Spring Boot 3.x + Jakarta
- Replacing Hibernate with Spring Data JPA improvements
- Introducing layered architecture
- Applying validation, exception handling, DTO mapping, logging, pagination, etc.

### 6. Tests

```bash
mvn test
```

### 7. Purpose of the project

This project is intentionally legacy and minimal. It is meant for:

- ✅ Testing automated migration tools (e.g., GenAI/LLM-based refactoring)
- 🔍 Practicing code smell detection and refactoring
- 🛠️ Demonstrating modernization pipelines
- 📚 Teaching how to go from legacy monolith to a clean, modular Spring Boot 3 app

You are encouraged to:

- Add validation
- Introduce DTOs and mapping
- Upgrade to Spring Boot 3 and Java 17+
- Replace deprecated APIs
- Add exception handling, OpenAPI docs, and more

