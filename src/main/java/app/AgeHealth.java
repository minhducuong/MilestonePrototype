/**
 * Age & Health Analysis Page Controller
 * 
 * This class handles the Age & Health analysis page of the Australian Gap Analysis application.
 * It provides insights into demographic and health-related data across different regions.
 * 
 * Responsibilities:
 * - Renders the age and health analysis page using Thymeleaf template
 * - Sets the page title for SEO and browser display
 * - Processes the age-health.html template with dynamic content
 */
package app;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.http.Handler;

public class AgeHealth {
    // Template engine instance for rendering Thymeleaf templates
    private final TemplateEngine templateEngine;

    /**
     * Constructor for PageST2A
     * @param templateEngine The Thymeleaf template engine instance
     */
    public AgeHealth(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Handler for the Age & Health analysis page route
     * @return Handler that processes the age-health page request
     */
    public Handler handleAgeHealth() {
        return ctx -> {
            // Create Thymeleaf context for template processing
            IContext thymeleafContext = new Context();
            // Set page title for the template
            ((Context) thymeleafContext).setVariable("title", "Age & Health - Australian Gap Analysis");
            // Process the age-health template and render HTML
            String html = templateEngine.process("age-health", thymeleafContext);
            // Send the rendered HTML as response
            ctx.html(html);
        };
    }
} 