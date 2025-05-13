/**
 * Landing Page Controller
 * 
 * This class handles the main landing page of the Australian Gap Analysis application.
 * It serves as the entry point for users and provides an overview of the application.
 * 
 * Responsibilities:
 * - Renders the main landing page using Thymeleaf template
 * - Sets the page title for SEO and browser display
 * - Processes the index.html template with dynamic content
 */
package app;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.http.Handler;

public class PageIndex {
    // Template engine instance for rendering Thymeleaf templates
    private final TemplateEngine templateEngine;

    /**
     * Constructor for PageIndex
     * @param templateEngine The Thymeleaf template engine instance
     */
    public PageIndex(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Handler for the landing page route
     * @return Handler that processes the index page request
     */
    public Handler handleIndex() {
        return ctx -> {
            // Create Thymeleaf context for template processing
            IContext thymeleafContext = new Context();
            // Set page title for the template
            ((Context) thymeleafContext).setVariable("title", "Australian Gap Analysis");
            // Process the index template and render HTML
            String html = templateEngine.process("index", thymeleafContext);
            // Send the rendered HTML as response
            ctx.html(html);
        };
    }
} 