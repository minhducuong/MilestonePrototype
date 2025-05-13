package app.config;

import io.javalin.Javalin;

/**
 * Configuration class for handling static resources
 * Maps static file directories to their respective URLs
 */
public class ResourceConfig {
    
    /**
     * Configure static resources for the application
     * @param app Javalin application instance
     */
    public static void configure(Javalin app) {
        // Configure static file locations
        app.get("/css/{path:.*}", ctx -> {
            String path = ctx.pathParam("path");
            ctx.result(ResourceConfig.class.getResourceAsStream("/static/css/" + path));
        });

        app.get("/js/{path:.*}", ctx -> {
            String path = ctx.pathParam("path");
            ctx.result(ResourceConfig.class.getResourceAsStream("/static/js/" + path));
        });

        app.get("/img/{path:.*}", ctx -> {
            String path = ctx.pathParam("path");
            ctx.result(ResourceConfig.class.getResourceAsStream("/static/img/" + path));
        });
    }
} 