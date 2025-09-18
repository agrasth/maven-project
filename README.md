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

### 1. Update Project Configuration

Edit the following files and replace the placeholders:

**In `pom.xml` and `settings.xml`:**
- `YOUR_REPO_NAME` - Your repository name (e.g., `myproject`)
- `YOUR_ARTIFACTORY_URL` - Your Artifactory URL (e.g., `https://mycompany.jfrog.io/artifactory`)
- `YOUR_USERNAME` - Your Artifactory username
- `YOUR_PASSWORD` - Your Artifactory password

### 2. Required Artifactory Repositories

Create these repositories in your Artifactory instance:
- `YOUR_REPO_NAME-flex-local` - Local repository for releases
- `YOUR_REPO_NAME-flex-virtual` - Virtual repository (includes local + Maven Central)

### 3. Maven Settings

Copy the `settings.xml` to your Maven configuration:

```bash
# Option 1: Copy to global Maven settings
cp settings.xml ~/.m2/settings.xml

# Option 2: Use project-specific settings (recommended for testing)
mvn compile -s settings.xml
```

## License

This project is provided as-is for testing and demonstration purposes.