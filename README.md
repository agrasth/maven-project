# JFrog CLI Maven Test Project

This is a test Maven project designed to validate JFrog CLI Maven integration and FlexPack functionality. It serves as a reference implementation for testing Maven build info collection, dependency resolution, and artifact publishing.

## Project Structure

```
test-maven-project/
├── pom.xml                           # Maven project configuration
├── src/
│   ├── main/java/com/jfrog/test/
│   │   └── App.java                  # Main application class
│   └── test/java/com/jfrog/test/
│       └── AppTest.java              # Unit tests
├── validate_maven_integration.sh     # Integration validation script
├── .gitignore                        # Git ignore patterns
└── README.md                         # This file
```

## Dependencies

This project includes common Java dependencies to test Maven FlexPack dependency resolution:

### Main Dependencies
- **Jackson Core & Databind** (2.15.2) - JSON processing
- **SLF4J API & Simple** (2.0.7) - Logging framework

### Test Dependencies  
- **JUnit Jupiter** (5.9.2) - Unit testing framework

## Usage

### Prerequisites

1. **Maven 3.6+** - For building the project
2. **Java 11+** - Required Java version
3. **JFrog CLI** - For artifact publishing and build info collection

### Building the Project

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

### Running the Application

```bash
# Run the main application
java -jar target/test-maven-project-1.0.0.jar

# Or run directly with Maven
mvn exec:java -Dexec.mainClass="com.jfrog.test.App"
```

### Validation Script

Run the comprehensive integration validation:

```bash
./validate_maven_integration.sh
```

This script will:
- ✅ Validate Maven installation and project structure
- ✅ Build and test the project
- ✅ Generate dependency tree
- ✅ Create sample build info
- ✅ Prepare for JFrog CLI integration

## JFrog CLI Integration

### Current Status

This project is ready for Maven FlexPack integration. Once implemented, you'll be able to use:

```bash
# Maven build with build info collection
jf mvn install --build-name=myapp --build-number=1.0

# Maven deploy with build info
jf mvn deploy --build-name=myapp --build-number=1.0 --repository=maven-local

# View collected build info
jf build-info show myapp 1.0
```

### Expected FlexPack Features

When Maven FlexPack is implemented, it should provide:

1. **Dependency Resolution**: Complete dependency tree with transitive dependencies
2. **Checksum Calculation**: SHA1, SHA256, and MD5 checksums for all dependencies
3. **Scope Determination**: Compile, test, runtime, and provided scopes
4. **Build Info Generation**: Complete build info with dependencies and artifacts
5. **Artifact Collection**: JAR, sources, and javadoc artifacts
6. **Repository Integration**: Seamless upload to Artifactory Maven repositories

## Testing Scenarios

This project supports testing various Maven FlexPack scenarios:

### 1. Basic Dependency Resolution
- Main dependencies (Jackson, SLF4J)
- Test dependencies (JUnit)
- Transitive dependency handling

### 2. Multi-Artifact Generation
- Main JAR (`test-maven-project-1.0.0.jar`)
- Sources JAR (`test-maven-project-1.0.0-sources.jar`)  
- Javadoc JAR (`test-maven-project-1.0.0-javadoc.jar`)

### 3. Build Info Collection
- Module information with GAV coordinates
- Complete dependency list with checksums
- Artifact information with repository paths
- Build metadata (timestamps, agent info)

### 4. Repository Publishing
- Maven repository structure
- POM file generation and upload
- Metadata handling
- Snapshot vs release handling

## Architecture Integration

This test project follows the same patterns as the Poetry test project:

```
JFrog CLI Ecosystem Integration:
┌─────────────────────────────────────┐
│  jfrog-cli (Main CLI)               │
│  ├── Command Routing                │
│  └── Build Management               │
├─────────────────────────────────────┤
│  jfrog-cli-artifactory              │
│  ├── Maven Command Integration      │ ← To be implemented
│  └── Build Info Merging             │
├─────────────────────────────────────┤
│  build-info-go                      │
│  ├── Maven FlexPack Engine          │ ← To be implemented  
│  └── Dependency Resolution          │
└─────────────────────────────────────┘
```

## Development Roadmap

### Phase 1: FlexPack Implementation
- [ ] Implement Maven FlexPack in `build-info-go/flexpack/maven_flexpack.go`
- [ ] Add POM parsing and dependency resolution
- [ ] Implement checksum calculation for Maven artifacts
- [ ] Add Maven-specific scope determination

### Phase 2: CLI Integration
- [ ] Add Maven command handler in `jfrog-cli-artifactory`
- [ ] Implement build info collection and merging
- [ ] Add artifact upload integration
- [ ] Create integration tests

### Phase 3: Advanced Features
- [ ] Multi-module project support
- [ ] Maven profiles handling
- [ ] Plugin dependency resolution
- [ ] Advanced repository features

## Similar Projects

- **Poetry Test Project** (`../test-poetry-project/`) - Reference implementation for Poetry FlexPack
- **Cargo Sample Project** (`../sample-cargo-project/`) - Rust/Cargo integration example

## Contributing

This test project serves as a foundation for Maven FlexPack development. When implementing Maven support:

1. Use this project for testing and validation
2. Follow the same patterns established in Poetry FlexPack
3. Ensure all validation scenarios pass
4. Update this README with implementation details

## License

This test project is part of the JFrog CLI ecosystem and follows the same licensing terms.
