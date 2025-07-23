# MarketGlide UI Automation

This project contains automated UI tests for MarketGlide, an investors' platform where companies and investors can register and interact with each other. The automation framework is built using Java, Selenium WebDriver, and TestNG.

## About MarketGlide

MarketGlide is a comprehensive platform that connects companies seeking investment with potential investors. The platform provides:
- Company registration and profile management
- Investor registration and portfolio management  
- Secure authentication and password management
- Interactive features for companies and investors to connect

## Technology Stack

- **Java 17** - Programming language
- **Selenium WebDriver 4.31.0** - Browser automation
- **TestNG 7.11.0** - Test framework
- **Maven** - Build and dependency management
- **Allure 2.24.0** - Test reporting
- **WebDriverManager 6.0.1** - Automatic driver management
- **JavaFaker 1.0.2** - Test data generation
- **Lombok 1.18.30** - Code generation

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+** 
- **Git**
- **Web browsers**: Chrome, Firefox, Edge, or Safari (depending on your test configuration)

## Project Structure

```
src/
├── main/java/
│   ├── configs/           # Configuration management
│   ├── pages/            # Page Object Model classes
│   │   ├── company/      # Company-related pages
│   │   ├── investor/     # Investor-related pages
│   │   └── HomePage.java # Main homepage
│   ├── steps/            # Test step definitions
│   └── utils/            # Utility classes and helpers
├── main/resources/
│   └── configs/          # Environment configuration files
└── test/java/
    ├── listener/         # TestNG listeners and console utilities
    └── tests/            # Test classes
        ├── company/      # Company-related tests
        ├── investor/     # Investor-related tests
        ├── homePage/     # Homepage tests
        └── BaseTests.java # Base test configuration
```

## Setup and Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd marketglide-ui-automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Compile the project**
   ```bash
   mvn clean compile
   ```

## Configuration

The test configuration is managed through properties files located in `src/main/resources/configs/`:

### Environment Configuration
- **demo.properties** - Contains demo environment settings
  ```properties
  company.email=company@harakirimail.com
  investor.email=investor@harakirimail.com  
  password=Qwerty1!
  demo.url=https://stage.marketglide.io
  ```

### Browser Configuration
The framework supports multiple browsers:
- **Chrome** (default)
- **Firefox** 
- **Edge**
- **Safari**

Browser selection is handled automatically through WebDriverManager.

## Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Groups
The tests are organized into groups. You can run specific groups:

```bash
# Run homepage tests
mvn test -Dgroups="homepage"

# Run company sign in tests  
mvn test -Dgroups="company sign in"

# Run investor sign in tests
mvn test -Dgroups="investor sign in"

# Run company reset password tests
mvn test -Dgroups="company reset password"
```

### Run Tests with Different Browsers
```bash
# Run with Firefox
mvn test -Dbrowser=firefox

# Run with Edge  
mvn test -Dbrowser=edge
```

## Test Categories

### Company Tests
- **Company Registration** - Tests for company signup process
- **Company Sign In** - Tests for company authentication
- **Company Reset Password** - Tests for company password recovery

### Investor Tests  
- **Investor Registration** - Tests for investor signup process
- **Investor Sign In** - Tests for investor authentication
- **Investor Forgot Password** - Tests for investor password recovery

### Homepage Tests
- **Homepage Navigation** - Tests for main page functionality and navigation

## Test Reporting

The project uses Allure for comprehensive test reporting.

### Generate Allure Report
```bash
# Run tests and generate report
mvn clean test
mvn allure:report

# Serve the report locally
mvn allure:serve
```

Reports are generated in the `target/allure-results` directory.

## Key Features

### Page Object Model
The framework implements the Page Object Model (POM) design pattern for better maintainability:
- Page classes in `src/main/java/pages/`
- Separate page classes for company and investor workflows
- Centralized element locators using `@FindBy` annotations

### Base Test Configuration
- Automatic WebDriver setup and teardown
- Support for multiple browsers with WebDriverManager
- Configurable timeouts and window management
- Environment-specific URL handling

### Test Data Management
- JavaFaker integration for generating realistic test data
- Configuration-based test data through properties files
- Utility classes for common operations

### Robust Element Handling
- Implicit waits configured for reliable element interaction
- Utility methods for common Selenium operations
- Console color coding for better test output visibility

## Development Guidelines

### Adding New Tests
1. Create test classes in the appropriate package under `src/test/java/tests/`
2. Extend `BaseTests` for automatic setup/teardown
3. Use appropriate TestNG groups for test categorization
4. Follow the existing naming conventions

### Adding New Page Objects
1. Create page classes in `src/main/java/pages/`
2. Use `@FindBy` annotations for element locators
3. Implement PageFactory pattern in constructors
4. Keep page-specific logic within page classes

### Configuration Management
- Add new environment configurations in `src/main/resources/configs/`
- Use the `Configuration` class for accessing properties
- Follow the existing property naming conventions

## Contributing

1. Follow the existing code structure and naming conventions
2. Add appropriate TestNG annotations and groups
3. Ensure all new tests extend `BaseTests`
4. Add Allure annotations for better reporting
5. Update documentation for new features

## Support

For questions or issues related to the automation framework, please refer to the project documentation or contact the development team.

---

**Note**: This automation framework is designed specifically for testing the MarketGlide platform and follows best practices for Selenium-based UI automation testing.