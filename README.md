SwagLabs Automation Test Suite for InPost Interview
Overview
This project contains automated UI tests for the SwagLabs sample mobile application.
Tests are written in Java, using JUnit 5, Selenium, and Appium, targeting primarily the Android platform.

Prerequisites
Java 13 or higher

Maven 3.6+

Appium server installed and running (Appium installation guide)

Android emulator or real device running and connected

SwagLabs sample app installed on the emulator/device — you can download the app here:
https://github.com/saucelabs/sample-app-mobile/releases/

Important: Make sure the Appium server is started before running the tests and that the emulator or device is active and has the SwagLabs app installed.

Project Structure
src/test/java — test classes and test helpers

base — base classes for driver setup and teardown

pages — Page Object Model classes for UI abstraction

tests — test cases organized by features

utils — helper utilities (login, data preparation)

Running Tests
Running all tests
To run all tests at once, simply:

In IntelliJ IDEA (or your IDE), right-click the tests package

Select Run 'Tests in tests'

This will automatically run all test classes and methods within the package.

Important Notes and Coding Choices
Platform focus:
Tests are automated for Android only.
The iOS configuration exists but UI elements were not localized for iOS, so tests will only reliably work on Android devices/emulators.

JUnit 5:
Using modern JUnit 5 for clean annotations and better IDE integration.

Page Object Model (POM):
UI elements and actions are encapsulated in page classes to keep tests maintainable and readable.

Test data externalization:
Test data such as user credentials and product info are stored in separate classes (UserData, ProductData), to separate data from test logic.

Driver and environment setup:
All driver initialization and teardown are handled in a base test class (BaseTest) to avoid duplication.

How to add new tests?
Create a new test class inside the tests package

Annotate methods with @Test (JUnit 5)

Use Page Object classes for UI interactions

Run the entire tests package or individual test classes via IDE

Troubleshooting
Make sure the Appium server is running and connected to the active emulator/device.

Ensure the SwagLabs app is installed on the emulator or device.

Check emulator or real device connection and availability.

Contact
For questions or clarifications, contact: [adam.d.lynx@gmail.com]