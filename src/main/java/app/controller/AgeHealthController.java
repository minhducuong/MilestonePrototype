package app.controller;

import org.thymeleaf.TemplateEngine;

import io.javalin.http.Handler;

/**
 * Controller for the Age & Health page
 */
public class AgeHealthController extends PageController {
    
    public AgeHealthController(TemplateEngine templateEngine) {
        super(templateEngine);
    }

    public Handler handleAgeHealth() {
        return renderTemplate("agehealth", "Age & Health - Australian Gap Analysis");
    }
} 