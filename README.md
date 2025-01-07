# Selenium Test Case for OrangeHRM Web App

This repository contains a Selenium test case for the **OrangeHRM Web Application**. The test case is designed to:

- **Test login functionality** with default credentials.
- **Test logout functionality** after a successful login.

## Technologies Used:
- **Selenium**: Web automation tool to perform the tests on the OrangeHRM application.
- **TestNG**: Testing framework used to organize and run the test cases.
- **ExtentReports**: For generating detailed and interactive test reports.
- **ITestListener**: Used for custom listeners to track test execution and handle reporting.
- **Design Patterns**: Follows common design patterns such as Page Object Model (POM) for structuring the test code.

## Key Features:
- **Login Test**: Validates that the default credentials successfully log into the OrangeHRM application.
- **Logout Test**: Ensures that the user can successfully log out after login.
- **TestNG Integration**: The tests are organized using TestNG annotations.
- **Extent Reports**: Generates interactive HTML reports for test results.
- **Custom Test Listeners**: Monitors the test execution and customizes the report output.

## Mistake in Project Structure:
Since this is my first Selenium project, I made the mistake of placing the test packages in `src/main/java` instead of the proper `src/test/java` directory. I’ve learned the importance of organizing test code in the correct directory structure for better maintainability and standard practice.

## Setup Instructions:

1. Clone the repository:
   ```bash
   git clone <repository-url>
