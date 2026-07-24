# Top Artist - Pure Domain Core

Top Artist is a platform that ranks artists based on fan engagement—specifically through ticket purchases for interactive experiences, as well as digital and physical music album sales. 

This repository contains the **Pure Domain Core**, completely isolated from any frameworks, databases, or external interfaces, following the principles of **Clean Architecture** and **Ports & Adapters (Hexagonal Architecture)**.

## Architecture & Design Principles
* **Pure Domain Core:** Written in 100% Pure Java, strictly decoupled from external frameworks, databases, or web drivers.
* **Constructor Injection:** Domain services depend exclusively on interface abstractions (`Ports`), which are injected strictly via constructors without framework magic.
* **Domain Exception Model:** Custom hierarchy of business exceptions (`BusinessException`) to encapsulate and control domain-specific error rules.
* **Ubiquitous Language:** Class names, methods, variables, and internal messages are completely structured in technical English.

## Testing & Quality Assurance
This project leverages **JUnit 5** and **Mockito** to ensure domain integrity and high code quality:
* **Rigorous AAA Pattern:** All unit tests strictly follow the **Arrange, Act, Assert** pattern, clearly separated using explicit code comments.
* **Custom Exception Handling:** Business rules and edge cases are validated using JUnit 5's `assertThrows`.
* **Mockito Isolation:** Complete isolation of external dependencies using `@Mock`, `@InjectMocks`, and `@ExtendWith(MockitoExtension.class)`.
* **100% Coverage Enforced:** Mathematical 100% Line and Branch coverage enforced by JaCoCo during the Maven build phase, ensuring zero untested logical paths.

## Execution & Coverage Commands

To run the automated test suite and enforce coverage verification:
```bash
mvn clean test
```
To generate the HTML coverage report with JaCoCo:

```bash
mvn jacoco:report
```

After running the command, you can view the coverage evidence by opening the generated HTML report:

`target/site/jacoco/index.html`
