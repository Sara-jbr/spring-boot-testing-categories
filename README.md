# Spring Boot Testing categories

### Prerequisites

- JDK 8+
- Maven or Gradle installed
- An IDE of your choice (Eclipse, IntelliJ IDEA, VS Code, etc.)


This repository demonstrates the various types of testing in Spring Boot: Unit Tests, Slice Tests, and Integration Tests. It explains how to write effective tests for different application layers, ensuring that individual components function correctly and the system works as expected when components interact.

### Testing categories Overview

In Spring Boot, testing is categorized into three main types:

    Unit Tests for Core Business Logic
    Slice Tests for Web Controllers and Repositories
    Integration Tests for End-to-End Functionality

# 1. Unit Tests for Core Business Logic
Purpose:

Unit tests verify the smallest parts of an application (e.g., methods or classes) in isolation. The focus is on testing the business logic without involving external systems like databases or the web layer.
Libraries Used:

    JUnit: For structuring and running tests.
    Mockito: For mocking dependencies, isolating the component under test.

# Mocking in Unit Tests:

In unit tests, dependencies such as a repository or service are mocked to isolate the logic being tested. For instance, if you are testing a UserService class, you mock its dependency on UserRepository to avoid interacting with the actual database during the test.

# 2. Slice Tests for Web Controllers and Repositories

"Slice testing" is a concept in Spring Boot that allows you to test only a specific layer (or "slice") of your application by configuring the application context to include just the relevant parts. This keeps tests focused, 
fast, and easy to manage.

### Web Controller Tests with @WebMvcTest

    Purpose: @WebMvcTest is used to test the web layer only. This type of test focuses on verifying the behavior of controllers without loading the entire Spring context. It ensures that the controller routes and request 
    handling logic work as expected.
    
    How It Works:
        @WebMvcTest configures Spring to load only the necessary components for the web layer (e.g., controllers, MockMvc for HTTP request simulation).
        Dependencies that controllers rely on, such as services, are typically mocked.
        
    Example: A test with @WebMvcTest might verify that an HTTP GET request to /users/1 returns the correct user data and HTTP status.

### Repository Tests with @DataJpaTest

    Purpose: @DataJpaTest is used to test the data access layer (repositories) only. This annotation configures an in-memory database (usually H2) for testing repository functionality without needing a full application context or 
    production database.
    
    How It Works:
        When using @DataJpaTest, Spring loads only JPA-related components, such as repositories and database configurations.
        @DataJpaTest is optimized for testing repository behavior in isolation and rolls back transactions after each test, keeping tests independent.
    Example: A @DataJpaTest might validate that a custom repository method correctly queries data by checking that the method retrieves the correct results based on certain criteria.

# 3. Integration Tests with @SpringBootTest

    Purpose: Integration tests check how multiple layers of the application work together in a more realistic environment by loading the full Spring context. This includes controllers, services, repositories, and other beans, simulating 
    the application’s behavior in a more end-to-end manner.
    
    How It Works:
        @SpringBootTest creates a complete Spring application context, allowing tests to interact with the system as a whole.
        Integration tests are usually slower than unit or slice tests because they involve initializing more components, and may interact with actual databases, servers, or other resources.
        
    Example: An integration test might start the application context, issue a request to the /users endpoint, process the request through the full stack (controller -> service -> repository), and verify that the response includes the expected data.

# Why Use These Different Testing Types?

Each testing type has unique strengths and is suited to verifying different aspects of the application:

    Unit Tests provide quick feedback and are very focused, making them ideal for testing business logic without external dependencies.
    Slice Tests allow testing specific layers (e.g., web layer or data layer) in isolation, ensuring that only the relevant components are loaded. This approach speeds up tests and keeps them focused on specific concerns.
    Integration Tests give confidence that all parts of the system work correctly when integrated, validating the overall functionality of the application in a near-production environment.	

# Getting Started

### Clone the repository:

git clone https://github.com/Sara-jbr/spring-boot-testing-categories.git
cd spring-boot-testing-categories

### Install dependencies:

mvn clean install

### Run tests:

To run unit tests:

    mvn test

To run slice tests:

    mvn test -Dtest=YourTestClass

To run integration tests:

   mvn verify




