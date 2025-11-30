package com.farmchainx.farmchainx.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConditionalOnProperty(name = "app.spa.enabled", havingValue = "true", matchIfMissing = true)
public class FrontendController {

    // Handles specific SPA routes
    @GetMapping({
            "/",
            "/dashboard",
            "/upload",
            "/products/my",
            "/scanner",
            "/verify/{uuid:^[0-9a-fA-F\\-]{36}$}",
            "/verify/**",
            "/login",
            "/register"
    })
    @ResponseBody
    public Resource serveIndex() {
        return new ClassPathResource("static/index.html");
    }

    // Generic fallback for ALL non-API and non-static routes
    @RequestMapping("/{path:^(?!api|uploads|static|js|css|images|fonts).*$}/**")
    @ResponseBody
    public Resource forwardFallback() {
        return new ClassPathResource("static/index.html");
    }

    @GetMapping("/error")
    @ResponseBody
    public Resource error() {
        return new ClassPathResource("static/index.html");
    }
}
