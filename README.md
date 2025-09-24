# Bookstore Automation Testing Project

> ⚠️ **Note:** If you want to run this project on your local machine, you must provide your **valid email and password** in the `LoginPage.java` file for the Google login flow to work correctly.

## Overview

This is a Selenium WebDriver automation framework built for end-to-end testing of a Bookstore(Rokomari) web application. The project uses the Page Object Model (POM) for better structure, reusability, and maintainability of test cases.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Allure Reporting
- Maven

## Features and Functionalities Covered

- Page Object Model (POM) Design Pattern
- Google Login Automation
- Dynamic Waits and Timeout Handling
- Element Scrolling and Hover Actions
- Window Handling (Switching between Tabs)
- Dropdown Selection by Visible Text
- Dropdown Selection by Value
- Handling SVG elements and hidden popups
- End-to-End Flow: Home → Login → Select Author → Select Product → Add to Cart → Checkout → Logout
- Allure Report Generation via `testng.xml`

## Project Structure

```
src/
├── main/
│   └── java/
│       ├── base/           # BasePage and DriverSetup classes
│       ├── pages/          # Page classes like HomePage, LoginPage, AuthorPage, CartPage
├── test/
│   └── java/
│       └── tests/          # Test classes like TestLoginPage, TestAuthorPage, TestCartPage etc.
testng.xml                  # Test suite file
```

## How to Run

1. Clone the repository
2. Add your valid credentials in `LoginPage.java`
3. Run tests using:
   ```bash
   mvn clean test
   ```

## Reporting

Allure reporting is integrated. To view the report:

```bash
allure open .\allure-report\
```

## Contributions

Feel free to fork and contribute.

## Author

Lubna
