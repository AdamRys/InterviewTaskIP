# SwagLabs Automation Test Suite for InPost Interview

## Overview

This project contains automated UI tests for the **SwagLabs** sample mobile application.  
Tests are written in Java, using JUnit 5, Selenium, and Appium, targeting primarily the Android platform.

---

## Prerequisites

- Java 13 or higher
- Maven 3.6+
- Appium server installed and running ([Appium installation guide](https://appium.io/docs/en/about-appium/intro/))
- Android emulator or real device running and connected
- SwagLabs sample app installed on the emulator/device — you can download the app here:  
  [https://github.com/saucelabs/sample-app-mobile/releases/](https://github.com/saucelabs/sample-app-mobile/releases/)

> **Important:** Make sure the Appium server is started *before* running the tests and that the emulator or device is active and has the SwagLabs app installed.

---

## Project Structure

- **src/test/java** — test classes and test helpers
- **base** — base classes for driver setup and teardown
- **pages** — Page Object Model classes for UI abstraction
- **tests** — test cases organized by features
- **utils** — helper utilities (login, data preparation)
- **config** — configuration files for the project, such as environment settings and test parameters
- **data** — static test data like sample users, products, and form values
- **driver** — classes managing Appium/Selenium driver initialization and related resources

---

## Running Tests

### Running all tests

To run all tests at once, simply:

- In IntelliJ IDEA (or your IDE), right-click the `tests` package
- Select **Run 'Tests in tests'**

This will automatically run all test classes and methods within the package.

---

## Additional Information

### Platform focus

Tests are automated for **Android** only.  
The iOS configuration exists but UI elements were not localized for iOS, so tests will only reliably work on Android devices/emulators.

### Test framework and design

- Using JUnit 5 for test annotations and execution.
- Page Object Model (POM) pattern is used to encapsulate UI interactions.
- Test data is externalized to separate classes (`UserData`, `ProductData`) for maintainability.
- Driver initialization and teardown are handled centrally in `BaseTest`.

---

## How to add new tests?

1. Create a new test class inside the `tests` package.
2. Annotate methods with `@Test` (JUnit 5).
3. Use Page Object classes for UI interactions.
4. Run the entire `tests` package or individual test classes via IDE.

---

## Troubleshooting

- Ensure Appium server is running and connected to your emulator/device.
- Verify the SwagLabs app is installed and accessible.
- Confirm your device/emulator is visible via `adb devices`.

---

## Contact

For questions or clarifications, contact: [adam.d.lynx@gmail.com]