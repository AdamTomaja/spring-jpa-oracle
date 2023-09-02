# Spring JPA with Oracle Database Example

This project demonstrates how to use Spring JPA with Oracle Database to manage Employee records.

## Features

- Spring Boot Application
- Spring Data JPA for Database Operations
- Lombok for reducing boilerplate code
- Oracle Database integration

## Database Model

We have used multiple tables like `EMPLOYEES`, `DEPARTMENTS`, `JOBS`, `COUNTRIES`, `REGIONS`, and `JOB_HISTORY`.
Each table has its schema defined in the Oracle Database.

### Sample Entity: `Employee`

Here is a simplified example of the Employee entity.

```java
@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime hireDate;
    private Integer salary;
    private Float comissionPct;

    @OneToOne
    private Job job;

    @OneToOne
    private Employee manager;

    @OneToOne(fetch = FetchType.LAZY)
    private Department department;

    @ManyToMany
    private List<Job> jobHistory;
}
```

## Requirements

- Java 17
- Oracle Database
- Spring Boot 3.1.3

## Dependencies

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'com.oracle.database.jdbc:ojdbc8'
    compileOnly 'org.projectlombok:lombok:1.18.28'
    annotationProcessor 'org.projectlombok:lombok:1.18.28'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

## Setup

1. Clone the repository

   ```bash
   git clone https://github.com/your-username/your-repo.git
   ```

2. Navigate to the project directory

   ```bash
   cd your-repo
   ```

3. Run the application
   ```bash
   ./gradlew bootRun
   ```

## Oracle DB Setup

Please execute the SQL scripts to create the necessary tables and sequences in your Oracle Database.

## Contributing

Contributions are welcome. Please fork the repository and create a pull request for any bug fixes, features or additions.

## License

This project is open-source and available under the MIT License.

## Author

Adam Tomaja

---

Happy coding!

```

```
