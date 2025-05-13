package app.controller;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import io.javalin.Javalin;
import io.javalin.http.Handler;

/**
 * Main controller for handling all page routes
 * Maps to the pages defined in templates folder
 */
public class PageController {
    private final Javalin app;
    private final TemplateEngine templateEngine;

    public PageController(Javalin app, TemplateEngine templateEngine) {
        this.app = app;
        this.templateEngine = templateEngine;
        setupRoutes();
    }

    /**
     * Sets up all the routes for the application
     */
    private void setupRoutes() {
        // Main pages
        app.get("/", handleIndex());
        app.get("/age-health", handleAgeHealth());
        app.get("/education", handleEducation());
        app.get("/gap-analysis", handleGapAnalysis());
        app.get("/how-to-use", handleHowToUse());

        // About section pages
        app.get("/our-vision", handleOurVision());
        app.get("/contact", handleContact());
        app.get("/personas", handlePersonas());
    }

    /**
     * Handler for the index page
     */
    private Handler handleIndex() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "Australian Gap Analysis");
            String html = templateEngine.process("index", thymeleafContext);
            ctx.html(html);
        };
    }

    /**
     * Handler for the Age & Health page
     */
    private Handler handleAgeHealth() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "Age & Health - Australian Gap Analysis");
            String html = templateEngine.process("age-health", thymeleafContext);
            ctx.html(html);
        };
    }

    /**
     * Handler for the Education page
     */
    private Handler handleEducation() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "Education - Australian Gap Analysis");
            String html = templateEngine.process("education", thymeleafContext);
            ctx.html(html);
        };
    }

    /**
     * Handler for the Gap Analysis page
     */
    private Handler handleGapAnalysis() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "Gap Analysis - Australian Gap Analysis");
            String html = templateEngine.process("gap-analysis", thymeleafContext);
            ctx.html(html);
        };
    }

    /**
     * Handler for the How to Use page
     */
    private Handler handleHowToUse() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "How to Use - Australian Gap Analysis");
            String html = templateEngine.process("how-to-use", thymeleafContext);
            ctx.html(html);
        };
    }

    /**
     * Handler for the Our Vision page
     */
    private Handler handleOurVision() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "Our Vision - Australian Gap Analysis");
            String html = templateEngine.process("our-vision", thymeleafContext);
            ctx.html(html);
        };
    }

    /**
     * Handler for the Contact page
     */
    private Handler handleContact() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "Contact Us - Australian Gap Analysis");
            String html = templateEngine.process("contact", thymeleafContext);
            ctx.html(html);
        };
    }

    /**
     * Handler for the Personas page
     */
    private Handler handlePersonas() {
        return ctx -> {
            IContext thymeleafContext = new Context();
            ((Context) thymeleafContext).setVariable("title", "Our Personas - Australian Gap Analysis");
            String html = templateEngine.process("personas", thymeleafContext);
            ctx.html(html);
        };
    }
} 