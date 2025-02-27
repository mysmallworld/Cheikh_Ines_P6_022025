# MDD Back-end !

This project was generated with [Spring Boot](https://spring.io/projects/spring-boot) version 3.4.2 and is managed with Maven.

## **Architecture**
This project follows the **MVC architecture**:

- **Configuration**: Contains authentication configuration with SpringSecurity.

- **Controller**: Handles incoming HTTP requests and maps them to the appropriate services or actions. It serves as the entry point for the API endpoints.

- **DTO** (Data Transfer Objects): Defines the objects used to transfer data between layers, ensuring that only necessary data is exposed and used.

- **Mapper**: Provides mapping logic to convert between DTOs and models, simplifying the interaction between the API and the database.

- **Model**: Represents the core entities in the application, typically mapping to database tables.

- **Repository**: Interfaces responsible for data access, performing CRUD operations on the database using Spring Data JPA.

- **Service**: Contains business logic and interacts with repositories to perform required operations for the controllers.

## **Prerequisites**
Before you begin, ensure you have the following installed:

- **Java**: Version 17 or later  
  [Download Java](https://www.oracle.com/java/technologies/javase-downloads.html).

- **MySQL**: Version 8.0.33 or later  
  [Download MySQL](https://www.jetbrains.com/idea/).

## **Installation**

Follow these steps to install the project:

1. **Clone the repository**
```bash
git clone https://github.com/mysmallworld/Cheikh_Ines_P6_022025.git
```

2. **Navigate to the project directory**
```bash
cd Cheikh_Ines_P6_022025/back
```

3. **Configure database**  
   Before starting the application, you must create the mdd database in MySQL.   
   You can do this with the following command in your MySQL terminal:

```bash
mysql -u root -p
```

Enter your password.

```bash
CREATE DATABASE mdd;
```
You need to add environement variables into back/src/main/resources/application.proporties :

**DBUrl**: url of your database.  
**DBUsername**: username of your database.  
**DBPassword**: password of your database.  
**MyJwtKey**: a jwt key who can be generate in a web site ([JWT.io](https://jwt.io/)).

4. **Build the project using Maven**
```bash
mvn clean install
```

5. **Run the application**
```bash
mvn spring-boot:run
```

## Development server
The development server runs at: `http://localhost:3001/`.  
Reload the application if you make any changes to the source files.