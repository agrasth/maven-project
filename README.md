# Sample Maven Project

A simple Java Maven project for testing and demonstration purposes.

## Project Structure

```
maven-project/
├── pom.xml                           # Maven project configuration
├── src/
│   ├── main/java/com/example/
│   │   └── App.java                  # Main application class
│   └── test/java/com/example/
│       └── AppTest.java              # Unit tests
├── settings.xml                      # Maven settings (template)
├── .gitignore                        # Git ignore patterns
└── README.md                         # This file
```

## Dependencies

This project includes common Java dependencies:

### Main Dependencies
- **Jackson Core & Databind** (2.15.2) - JSON processing
- **SLF4J API & Simple** (2.0.7) - Logging framework

### Test Dependencies  
- **JUnit Jupiter** (5.9.2) - Unit testing framework

## Prerequisites

1. **Maven 3.6+** - For building the project
2. **Java 11+** - Required Java version

## Building the Project

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package the application
mvn package

# Install to local repository
mvn install
```

## Running the Application

```bash
# Run the main application
java -jar target/maven-project-1.0.0.jar

# Or run directly with Maven
mvn exec:java -Dexec.mainClass="com.example.App"
```

## Configuration

The project includes a `settings.xml` template for Maven configuration. Update it with your repository settings as needed.

## License

This project is provided as-is for testing and demonstration purposes.