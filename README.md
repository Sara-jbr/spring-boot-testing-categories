# Spring Boot Testing Categories

## Prerequisites

- [**JDK 8+**](https://adoptopenjdk.net/)  
- [**Maven**](https://maven.apache.org/) or [**Gradle**](https://gradle.org/) installed  
- An [**IDE**](https://www.eclipse.org/) of your choice (Eclipse, [IntelliJ IDEA](https://www.jetbrains.com/idea/), [VS Code](https://code.visualstudio.com/), etc.)

## Overview

This repository demonstrates the various types of testing in Spring Boot: **Unit Tests**, **Slice Tests**, and **Integration Tests**. It explains how to write effective tests for different application layers, ensuring that individual components function correctly and that the system works as expected when components interact.

## Testing Categories Overview

In Spring Boot, testing is categorized into three main types:

- **Unit Tests** for Core Business Logic
- **Slice Tests** for Web Controllers and Repositories
- **Integration Tests** for End-to-End Functionality

---

### 1. Unit Tests for Core Business Logic

**Purpose:**  
Unit tests verify the smallest parts of an application (e.g., methods or classes) in isolation. The focus is on testing business logic without involving external systems like databases or the web layer.

**Libraries Used:**
- **JUnit:** For structuring and running tests
- **Mockito:** For mocking dependencies and isolating the component under test

**Mocking in Unit Tests:**  
In unit tests, dependencies such as a repository or service are mocked to isolate the logic being tested. For example, when testing a `UserService` class, the `UserRepository` dependency is mocked to avoid interacting with the actual database during the test.

---

### 2. Slice Tests for Web Controllers and Repositories

**Purpose:**  
Slice tests allow you to test specific layers (or "slices") of your application, such as web controllers or repositories, without loading the entire Spring context. This keeps tests focused, fast, and easy to manage.

#### Web Controller Tests with `@WebMvcTest`

**Purpose:**  
`@WebMvcTest` is used to test the web layer only, focusing on verifying the behavior of controllers without loading the entire Spring context. It ensures that the controller routes and request-handling logic work as expected.

**How It Works:**
- Loads only the necessary components for the web layer (e.g., controllers, `MockMvc` for HTTP request simulation)
- Dependencies that controllers rely on, such as services, are typically mocked

**Example:**  
A test might verify that an HTTP GET request to `/users/1` returns the correct user data and HTTP status.

#### Repository Tests with `@DataJpaTest`

**Purpose:**  
`@DataJpaTest` is used to test the data access layer (repositories) only. It configures an in-memory database (usually H2) for testing repository functionality without needing a full application context or production database.

**How It Works:**
- Loads only JPA-related components such as repositories and database configurations
- Rolls back transactions after each test to keep them independent

**Example:**  
A `@DataJpaTest` might validate that a custom repository method correctly queries data, verifying that it retrieves the correct results based on certain criteria.

---

### 3. Integration Tests with `@SpringBootTest`

**Purpose:**  
Integration tests verify how multiple layers of the application work together in a more realistic environment by loading the full Spring context. This includes controllers, services, repositories, and other beans, simulating the application’s behavior in a more end-to-end manner.

**How It Works:**
- Loads the entire Spring application context, allowing tests to interact with the system as a whole
- Integration tests tend to be slower because they initialize more components and may interact with actual databases or servers

**Example:**  
An integration test might start the application context, issue a request to the `/users` endpoint, process the request through the full stack (controller → service → repository), and verify that the response includes the expected data.

---

## Why Use These Different Testing Types?

Each testing type has unique strengths suited to verifying different aspects of the application:

- **Unit Tests:** Provide quick feedback and focus on business logic without external dependencies.
- **Slice Tests:** Test specific layers (e.g., web layer or data layer) in isolation, making them fast and focused.
- **Integration Tests:** Ensure that all parts of the system work together correctly, validating the overall functionality of the application in a near-production environment.

---

## Getting Started

## Clone the repository

```bash
git clone https://github.com/Sara-jbr/spring-boot-testing-categories.git
cd spring-boot-testing-categories
```
## Install dependencies

```bash
mvn clean install
```
## Run tests
### To run unit tests:

```bash
mvn test
```
### To run slice tests:

```bash
mvn test -Dtest=YourTestClass
```
### To run integration tests:

```bash
mvn verify
```
