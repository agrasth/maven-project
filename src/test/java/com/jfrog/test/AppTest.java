package com.jfrog.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the App class.
 * These tests validate the basic functionality of the Maven test project.
 */
public class AppTest {
    
    private App app;
    
    @BeforeEach
    public void setUp() {
        app = new App();
    }
    
    @Test
    public void testGetVersion() {
        String version = app.getVersion();
        assertNotNull(version, "Version should not be null");
        assertEquals("1.0.0", version, "Version should match expected value");
    }
    
    @Test
    public void testGetProjectName() {
        String projectName = app.getProjectName();
        assertNotNull(projectName, "Project name should not be null");
        assertEquals("test-maven-project", projectName, "Project name should match expected value");
    }
    
    @Test
    public void testAppCreation() {
        assertNotNull(app, "App instance should be created successfully");
    }
    
    @Test
    public void testRunMethod() {
        // Test that run method executes without throwing exceptions
        assertDoesNotThrow(() -> {
            app.run();
        }, "App.run() should execute without throwing exceptions");
    }
    
    @Test
    public void testMainMethod() {
        // Test that main method executes without throwing exceptions
        assertDoesNotThrow(() -> {
            App.main(new String[]{});
        }, "App.main() should execute without throwing exceptions");
    }
}
