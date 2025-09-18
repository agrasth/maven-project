package com.jfrog.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Main application class for JFrog CLI Maven test project.
 * This demonstrates a simple Java application with dependencies that can be used
 * to test Maven FlexPack integration and build info collection.
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private final ObjectMapper objectMapper;

    public App() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Main entry point for the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        logger.info("Starting JFrog CLI Maven Test Application");
        
        App app = new App();
        app.run();
        
        logger.info("Application completed successfully");
    }

    /**
     * Runs the main application logic.
     * Demonstrates usage of Jackson for JSON processing.
     */
    public void run() {
        try {
            // Create sample data
            Map<String, Object> data = new HashMap<>();
            data.put("project", "test-maven-project");
            data.put("version", "1.0.0");
            data.put("framework", "maven");
            data.put("dependencies", new String[]{"jackson-core", "jackson-databind", "slf4j-api"});

            // Convert to JSON
            String json = objectMapper.writeValueAsString(data);
            logger.info("Generated JSON: {}", json);

            // Parse back from JSON
            @SuppressWarnings("unchecked")
            Map<String, Object> parsed = objectMapper.readValue(json, Map.class);
            logger.info("Parsed project: {}", parsed.get("project"));
            
        } catch (Exception e) {
            logger.error("Error processing JSON", e);
            throw new RuntimeException("Application failed", e);
        }
    }

    /**
     * Gets the current application version.
     *
     * @return version string
     */
    public String getVersion() {
        return "1.0.0";
    }

    /**
     * Gets the project name.
     *
     * @return project name
     */
    public String getProjectName() {
        return "test-maven-project";
    }
}
