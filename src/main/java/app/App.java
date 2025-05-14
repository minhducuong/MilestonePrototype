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
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import app.config.ResourceConfig;
import app.dataLogic.JDBCmain;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class App {
    private final Javalin app;
    private final TemplateEngine templateEngine;
    private final JDBCmain dbConnection;

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

        // Initialize database connection
        this.dbConnection = new JDBCmain();

        // Configure routes and resources
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
        // Configure static resources
        ResourceConfig.configure(app);

        // Main page with data handling
        app.get("/", ctx -> {
            Context context = new Context();
            context.setVariable("title", "Closing the Gap");
            String html = templateEngine.process("agehealth", context);
            ctx.html(html);
        });

        // Page handlers
        Handler pageHandler = ctx -> {
            String path = ctx.path();
            String templateName = path.substring(1); // Remove leading slash
            if (templateName.isEmpty()) templateName = "agehealth";
            
            Context context = new Context();
            context.setVariable("title", "Closing the Gap");
            String html = templateEngine.process(templateName, context);
            ctx.html(html);
        };

        // Register routes for all pages
        app.get("/age-health", pageHandler);
        app.get("/education", pageHandler);
        app.get("/gap-analysis", pageHandler);
        app.get("/vision", pageHandler);
        app.get("/how2use", pageHandler);
        app.get("/contact", pageHandler);
        app.get("/persona", pageHandler);
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