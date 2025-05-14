/**
 * Education Analysis Page Controller
 * 
 * This class handles the Education analysis page of the Australian Gap Analysis application.
 * It provides insights into educational metrics and outcomes across different regions.
 * 
 * Responsibilities:
 * - Renders the education analysis page using Thymeleaf template
 * - Sets the page title for SEO and browser display
 * - Processes the education.html template with dynamic content
 */
package app;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.http.Handler;

public class Education {
    // Template engine instance for rendering Thymeleaf templates
    private final TemplateEngine templateEngine;

    /**
     * Constructor for PageST2B
     * @param templateEngine The Thymeleaf template engine instance
     */
    public Education(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Handler for the Education analysis page route
     * @return Handler that processes the education page request
     */
    public Handler handleEducation() {
        return ctx -> {
            // Create Thymeleaf context for template processing
            IContext thymeleafContext = new Context();
            // Set page title for the template
            ((Context) thymeleafContext).setVariable("title", "Education - Australian Gap Analysis");
            // Process the education template and render HTML
            String html = templateEngine.process("education", thymeleafContext);
            // Send the rendered HTML as response
            ctx.html(html);
        };
    }
} 