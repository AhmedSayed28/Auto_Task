# Project README

## Overview

This project is an automated testing solution for a user registration form using Selenium WebDriver with Java. The goal is to validate the functionality of the registration process, ensuring that users can successfully submit the form and receive the appropriate success message.

## Project Structure

- **.idea**: Project-specific IDE configuration files.
- **Reports**: Contains test execution reports and screenshots.
  - `screenshots`: Directory for storing screenshots captured during testsss.
  - `spark`: Directory for Spark report outputs.
  - `extent-report.html`: HTML file containing detailed ExtentReports results.
  - `extent-reports-config.json`: Configuration file for ExtentReports.
- **Runner**: Test suite configuration.
  - `suit.xml`: XML file for defining test suites and execution.
- **src**: Source code directory.
  - **main/java/org.example/pages/RegisterFormPage**: Page Object Model (POM) class for interacting with the registration form.
  - **test/java/testsss**: Contains test classes and utility classes.
    - `HelperClass`: Utility methods and helpers for test cases.
    - `SignUpTest`: Test class for verifying user registration functionality.
    - `TestBase`: Base class providing setup and teardown methods for testsss.
- **target**: Compiled code and build artifacts.
- **.gitignore**: Specifies files and directories to be ignored by Git.
- **pom.xml**: Maven configuration file managing project dependencies and build settings.

## Features

- **Page Object Model (POM)**: Implements the Page Object Model design pattern for managing page elements and interactions. This promotes maintainability and scalability.
- **Data-Driven Testing**: Utilizes Faker library to generate dynamic test data, including names, emails, and phone numbers.
- **Automated Reporting**: Integration with ExtentReports and Spark for comprehensive reporting of test results.
- **Dynamic Data Management**: Reads static test data from an external JSON file, allowing easy updates without code changes.
- **Screenshot Capture**: Automatically captures screenshots of the browser during test execution for easier debugging of failed testsss.

## Limitations

- **Browser Compatibility**: The solution is tested primarily on specific browser versions. Additional configuration may be required to ensure compatibility with other browsers.

## How It Works

1. **Setup**: The `TestBase` class initializes WebDriver and configures reporting tools.
2. **Test Execution**: The `SignUpTest` class performs automated registration using dynamic data generated by the Faker library and data from an external JSON file.
3. **Data Handling**: The `RegisterFormPage` class handles interactions with the registration form using locators defined for each element.
4. **Reporting**: Test results, including screenshots and logs, are generated and saved in the `Reports` directory for analysis.

## Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/AhmedSayed28/Auto_Task.git
)
