package app.controller;

import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.http.Handler;

/**
 * Unified controller for all pages
 * Provides template rendering and route handling
 */
public class PageController {
    protected final TemplateEngine templateEngine;
    private final Map<String, String> pageTitles;

    public PageController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        this.pageTitles = new HashMap<>();
        initializePageTitles();
    }

    private void initializePageTitles() {
        pageTitles.put("index", "Home - Australian Gap Analysis");
        pageTitles.put("agehealth", "Age & Health - Australian Gap Analysis");
        pageTitles.put("education", "Education - Australian Gap Analysis");
        pageTitles.put("gapanalyse", "Gap Analysis - Australian Gap Analysis");
        pageTitles.put("vision", "Our Vision - Australian Gap Analysis");
        pageTitles.put("how2use", "How to Use - Australian Gap Analysis");
        pageTitles.put("contact", "Contact Us - Australian Gap Analysis");
        pageTitles.put("persona", "Our Personas - Australian Gap Analysis");
    }

    /**
     * Renders a template with the given title
     * @param templateName Name of the template file (without .html)
     * @return Handler that renders the template
     */
    protected Handler renderPage(String templateName) {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", 
                pageTitles.getOrDefault(templateName, "Australian Gap Analysis"));
            String html = templateEngine.process(templateName, thymeleafContext);
            ctx.html(html);
        };
    }

    // Page handlers
    public Handler handleIndex() { return renderPage("index"); }
    public Handler handleAgeHealth() { return renderPage("agehealth"); }
    public Handler handleEducation() { return renderPage("education"); }
    public Handler handleGapAnalysis() { return renderPage("gapanalyse"); }
    public Handler handleVision() { return renderPage("vision"); }
    public Handler handleHow2Use() { return renderPage("how2use"); }
    public Handler handleContact() { return renderPage("contact"); }
    public Handler handlePersona() { return renderPage("persona"); }
} 