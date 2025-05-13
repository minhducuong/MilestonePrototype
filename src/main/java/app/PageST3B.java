/**
 * Similar LGAs Analysis Page Controller
 * 
 * This class handles the Similar LGAs (Local Government Areas) analysis page of the Australian Gap Analysis application.
 * It provides insights into comparable regions based on various metrics and characteristics.
 * 
 * Responsibilities:
 * - Renders the similar LGAs analysis page using Thymeleaf template
 * - Sets the page title for SEO and browser display
 * - Processes the similar-lgas.html template with dynamic content
 */
package app;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.http.Handler;

public class PageST3B {
    // Template engine instance for rendering Thymeleaf templates
    private final TemplateEngine templateEngine;

    /**
     * Constructor for PageST3B
     * @param templateEngine The Thymeleaf template engine instance
     */
    public PageST3B(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Handler for the Similar LGAs analysis page route
     * @return Handler that processes the similar-lgas page request
     */
    public Handler handleSimilarLGAs() {
        return ctx -> {
            // Create Thymeleaf context for template processing
            IContext thymeleafContext = new Context();
            // Set page title for the template
            ((Context) thymeleafContext).setVariable("title", "Similar LGAs - Australian Gap Analysis");
            // Process the similar-lgas template and render HTML
            String html = templateEngine.process("similar-lgas", thymeleafContext);
            // Send the rendered HTML as response
            ctx.html(html);
        };
    }
} 