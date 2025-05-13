/**
 * Gap Analysis Page Controller
 * 
 * This class handles the Gap Analysis page of the Australian Gap Analysis application.
 * It provides detailed analysis of gaps in various metrics across different regions.
 * 
 * Responsibilities:
 * - Renders the gap analysis page using Thymeleaf template
 * - Sets the page title for SEO and browser display
 * - Processes the gap-analysis.html template with dynamic content
 */
package app;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.http.Handler;

public class PageST3A {
    // Template engine instance for rendering Thymeleaf templates
    private final TemplateEngine templateEngine;

    /**
     * Constructor for PageST3A
     * @param templateEngine The Thymeleaf template engine instance
     */
    public PageST3A(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Handler for the Gap Analysis page route
     * @return Handler that processes the gap-analysis page request
     */
    public Handler handleGapAnalysis() {
        return ctx -> {
            // Create Thymeleaf context for template processing
            IContext thymeleafContext = new Context();
            // Set page title for the template
            ((Context) thymeleafContext).setVariable("title", "Gap Analysis - Australian Gap Analysis");
            // Process the gap-analysis template and render HTML
            String html = templateEngine.process("gap-analysis", thymeleafContext);
            // Send the rendered HTML as response
            ctx.html(html);
        };
    }
} 