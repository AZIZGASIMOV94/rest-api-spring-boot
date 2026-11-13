# Employees REST API

![Java 17](https://img.shields.io/badge/Java-17-orange)
![Spring Boot 2.7](https://img.shields.io/badge/Spring%20Boot-2.7-brightgreen)

A read-only Spring Boot REST API over the MySQL [**employees** sample database](https://github.com/datacharmer/test_db): about 300,000 employees, their salaries, job titles and department history.

## Features

- **Correct mapping of the real schema**, including composite primary keys (`salaries`, `titles`, `dept_emp`, `dept_manager`)
- **Paging and sorting** on large tables (`?page=0&size=20&sort=hireDate,desc`), with a maximum page size of 100
- **Search** by first and/or last name (case-insensitive)
- **Consistent JSON errors**: `404` for unknown employees/departments, `400` for invalid ids
- **Safe by default**: Hibernate never modifies the sample database (`ddl-auto=none`)
- **Integration tests** run every endpoint against an in-memory H2 copy of the schema

## API

### Employees

| Method | Path | Description |
|---|---|---|
| `GET` | `/api/employees?firstName=&lastName=&page=&size=&sort=` | List or search employees (paged) |
| `GET` | `/api/employees/{empNo}` | One employee |
| `GET` | `/api/employees/{empNo}/salaries` | Salary history, oldest first |
| `GET` | `/api/employees/{empNo}/titles` | Job title history, oldest first |

### Departments

| Method | Path | Description |
|---|---|---|
| `GET` | `/api/departments` | All departments |
| `GET` | `/api/departments/{deptNo}` | One department, e.g. `d005` |
| `GET` | `/api/departments/{deptNo}/employees?page=&size=` | Employees assigned to the department (paged) |
| `GET` | `/api/departments/{deptNo}/managers` | Manager history, oldest first |

### Examples

```bash
curl "http://localhost:8080/api/employees?lastName=Facello&size=5"

curl http://localhost:8080/api/employees/10001
# {"empNo":10001,"birthDate":"1953-09-02","firstName":"Georgi","lastName":"Facello","gender":"M","hireDate":"1986-06-26"}

curl http://localhost:8080/api/employees/10001/salaries
# [{"empNo":10001,"amount":60117,"fromDate":"1986-06-26","toDate":"1987-06-26"}, ...]

curl http://localhost:8080/api/employees/99999
# {"timestamp":"...","status":404,"error":"Not Found","message":"Employee 99999 not found"}
```

A `toDate` of `9999-01-01` means "current" in the sample data.

## Running locally

**Requirements:** Java 17+, Maven, MySQL 8.

1. Load the sample database:
   ```bash
   git clone https://github.com/datacharmer/test_db.git
   cd test_db
   mysql -u root -p < employees.sql
   ```
2. Start the API:
   ```bash
   DB_USERNAME=root DB_PASSWORD=secret mvn spring-boot:run
   ```

| Variable | Default |
|---|---|
| `DB_URL` | `jdbc:mysql://localhost:3306/employees` |
| `DB_USERNAME` | `root` |
| `DB_PASSWORD` | _(empty)_ |

## Tests

```bash
mvn verify
```

13 integration tests start the full application with MockMvc against an H2 database that uses the same tables and keys as the MySQL schema, seeded with a few real rows ([`schema.sql`](src/test/resources/schema.sql), [`data.sql`](src/test/resources/data.sql)). No MySQL needed.

## Project structure

```
src/main/java/io/github/azizgasimov94/employees
├── controller/   # EmployeeController, DepartmentController
├── service/      # EmployeeService, DepartmentService (read-only transactions)
├── repository/   # Spring Data JPA repositories
├── model/        # JPA entities + composite key classes
└── exception/    # NotFoundException, GlobalExceptionHandler
```

## History

Started in 2020 as a university exam project. Rewritten in 2026:

- Fixed primary keys that made Hibernate merge rows: titles were keyed by title alone and salaries by start date alone, so different employees' records collapsed into one
- Fixed `dept_no` (a `CHAR(4)` code like `d005`, previously mapped as a number) and the `dept_emp` table name
- Removed bidirectional entity links that caused infinite JSON recursion
- Replaced unbounded "return all 300,000 rows" endpoints with paging
- Turned off `ddl-auto=update`, which could alter the sample database
- Upgraded Spring Boot 2.1 → 2.7 and Java 8 → 17; added tests and CI
