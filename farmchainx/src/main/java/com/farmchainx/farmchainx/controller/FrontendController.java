package com.farmchainx.farmchainx.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConditionalOnProperty(name = "app.spa.enabled", havingValue = "true", matchIfMissing = true)
public class FrontendController {

    // Serve index.html for all SPA routes
    @GetMapping(value = {
            "/",
            "/dashboard",
            "/upload",
            "/products/my",
            "/scanner",
            "/login",
            "/register",
            "/verify/{uuid:^[0-9a-fA-F\\-]{36}$}", // valid
            "/verify/**",
            "/{path:[^\\.]*}" // <-- VALID Spring Boot 3 fallback
    })
    @ResponseBody
    public Resource index() {
        return new ClassPathResource("static/index.html");
    }

    // Optional: fallback for error page
    @GetMapping("/error")
    @ResponseBody
    public Resource error() {
        return new ClassPathResource("static/index.html");
    }
}
