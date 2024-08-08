# Rami Levy Website Automation Testing

This repository contains the automation infrastructure and test cases for the Rami Levy website. The tests are implemented using Selenium and Cucumber in Java, following the best practices of test automation.

## Description

Rami Levy's website is an online platform where users can order products, similar to a supermarket. This project aims to ensure the robustness and reliability of the website through comprehensive automated testing. The automation framework adheres to the Arrange, Act, Assert (AAA) structure and ensures test isolation, parallel execution, and consistent reporting.

Key features of this project include:

- **Complete E2E Test Plan**: Developed a comprehensive end-to-end test plan and sanity suite.
- **Test Isolation**: Each test is independent and does not affect or get affected by other tests.
- **Parallelism**: Tests can run in parallel to reduce execution time.
- **Assertions**: Uses accurate assertions to validate test outcomes.
- **Reporting**: Utilizes logging and reporting tools for detailed and interactive test reports.
- **Infrastructure**: Structured in layers (infra, logic, tests) for maintainability.
- **Page Object Model (POM)**: Ensures a clean separation between test code and page-specific code.
- **Git Practices**: Encourages the use of pull requests, code reviews, and informative commit messages to maintain code quality.
- **Stability**: Focuses on creating stable tests that pass consistently, except in the case of actual bugs in the system.

## Table of Contents

- [Project Structure](#project-structure)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Reporting](#reporting)

## Project Structure

The project is structured in layers to ensure clean code separation and maintainability:

- **infra**: Contains the infrastructure code such as configurations and setup.
- **logic**: Contains the business logic and page object models (POM).
- **test**: Contains the test definitions.

## Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/rami-levy-automation.git
    cd rami-levy-automation
    ```

2. **Install dependencies**:
    Make sure you have Java, Maven, and Selenium installed on your system.

3. **Configure the project**:
    Update the configuration files in the `infra` layer with the appropriate settings for your environment.

## Running Tests

To run the tests, use the following command:

```sh
mvn test
