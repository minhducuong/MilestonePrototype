/**
 * Vision Page Controller
 * 
 * This class handles the Vision page of the Australian Gap Analysis application.
 * It presents the project's vision, goals, and mission statement to users.
 * 
 * Responsibilities:
 * - Renders the vision page using Thymeleaf template
 * - Sets the page title for SEO and browser display
 * - Processes the our-vision.html template with dynamic content
 */
package app;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.http.Handler;

public class PageVision {
    // Template engine instance for rendering Thymeleaf templates
    private final TemplateEngine templateEngine;

    /**
     * Constructor for PageVision
     * @param templateEngine The Thymeleaf template engine instance
     */
    public PageVision(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Handler for the Vision page route
     * @return Handler that processes the our-vision page request
     */
    public Handler handleOurVision() {
        return ctx -> {
            // Create Thymeleaf context for template processing
            IContext thymeleafContext = new Context();
            // Set page title for the template
            ((Context) thymeleafContext).setVariable("title", "Our Vision - Australian Gap Analysis");
            // Process the our-vision template and render HTML
            String html = templateEngine.process("our-vision", thymeleafContext);
            // Send the rendered HTML as response
            ctx.html(html);
        };
    }
} 