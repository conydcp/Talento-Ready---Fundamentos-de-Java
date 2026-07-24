# Top Artist - Core Domain
Top Artist is a platform that ranks artists based on fan engagement—specifically through ticket purchases for interactive experiences, as well as digital and physical music album sales. This repository contains the Pure Domain Core, completely isolated from any frameworks, databases, or external interfaces, following the principles of Clean Architecture / Hexagonal Architecture.
## Architecture Highlights
- **Pure Java**: No Spring, JPA, or web annotations. The domain depends only on itself.
- **Dependency Inversion**: All external interactions are modeled as interfaces (`MessageNotifier`, `SmsNotifier`) and injected via the constructor.
- **English Nomenclature**: Clean, modular code entirely in English.

## Testing & Quality Assurance
This project uses **JUnit 5**, **Mockito**, and **AssertJ** to ensure the highest standards of quality.
- **Rigorous AAA Pattern**: All tests are strictly structured using Arrange, Act, and Assert phases.
- **Business Exceptions**: Custom exceptions are verified thoroughly using AssertJ's `assertThatThrownBy`.
- **Mockito Extension**: Clean injection of dependencies and mocks using `@ExtendWith(MockitoExtension.class)`.
- **Parameterized Tests**: Data-driven testing is utilized to reduce duplication (e.g., using `@NullAndEmptySource`).
- **100% Coverage Enforced**: The test suite guarantees and enforces 100% Line and Branch coverage during the build, ensuring no orphan logic exists.

## How to Verify
To run the automated tests and generate the JaCoCo coverage report, execute the following command in the root of the project:

```bash
mvn clean test jacoco:report
```

After running the command, you can view the coverage evidence by opening the generated HTML report:
`target/site/jacoco/index.html`
