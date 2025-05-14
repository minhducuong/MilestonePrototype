/**
 * Main Application Class
 * 
 * This class serves as the entry point for the Australian Gap Analysis application.
 * It initializes the Javalin server, configures Thymeleaf templates, and sets up all routes.
 * 
 * Responsibilities:
 * - Initialize and configure the Javalin server
 * - Set up Thymeleaf template engine
 * - Configure static resources
 * - Register all page controllers and their routes
 */
package app;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import app.config.ResourceConfig;
import io.javalin.Javalin;

public class App {
    private final Javalin app;
    private final TemplateEngine templateEngine;

    /**
     * Constructor for the main application
     * Initializes Javalin and configures Thymeleaf
     */
    public App() {
        // Initialize Javalin with default configuration
        this.app = Javalin.create(config -> {
            config.addStaticFiles("/static");
        });

        // Configure Thymeleaf template engine
        this.templateEngine = configureThymeleaf();

        // Configure routes
        configureRoutes();
    }

    /**
     * Configures the Thymeleaf template engine
     * @return Configured TemplateEngine instance
     */
    private TemplateEngine configureThymeleaf() {
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        
        // Configure template resolver
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false); // Disable cache for development
        
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * Configures all application routes
     * Registers handlers for each page
     */
    private void configureRoutes() {
        // Initialize page controllers
        PageIndex pageIndex = new PageIndex(templateEngine);
        PageST2A pageST2A = new PageST2A(templateEngine);
        PageST2B pageST2B = new PageST2B(templateEngine);
        PageST3A pageST3A = new PageST3A(templateEngine);
        PageST3B pageST3B = new PageST3B(templateEngine);
        PageVision pageVision = new PageVision(templateEngine);

        // Configure static resources
        ResourceConfig.configure(app);

        // Register routes
        app.get("/", pageIndex.handleIndex());
        app.get("/age-health", pageST2A.handleAgeHealth());
        app.get("/education", pageST2B.handleEducation());
        app.get("/gap-analysis", pageST3A.handleGapAnalysis());
        app.get("/similar-lgas", pageST3B.handleSimilarLGAs());
        app.get("/our-vision", pageVision.handleOurVision());
    }

    /**
     * Starts the application server
     * @param port   The port number to run the server on // 7000
     */
    public void start(int port) {
        app.start(port);
    }

    /**
     * Main method to run the application
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        App app = new App();
        app.start(7000); // Start server on port 7000
    }
} 