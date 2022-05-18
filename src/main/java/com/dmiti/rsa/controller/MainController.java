package com.dmiti.rsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping
    public String mainPage() {
        logger.info("Showing the main page");

        return "index";
    }

    @GetMapping("/laboratory")
    public String laboratoryPage() {
        logger.info("Showing the laboratory page");

        return "main/laboratory";
    }

    @GetMapping("/about")
    public String aboutPage() {
        logger.info("Showing the about page");

        return "main/about";
    }

    @GetMapping("/rsa_generator")
    public String rsaGeneratorPage() {
        logger.info("Showing the rsa generator page");

        return "main/rsa_generator";
    }

    @GetMapping("/poor_rsa")
    public String rsaPoorPage() {
        logger.info("Showing the poor rsa notification");

        return "main/poor_rsa";
    }

    @GetMapping("/stable_rsa")
    public String rsaStablePage() {
        logger.info("Showing the stable rsa notification");

        return "main/stable_rsa";
    }

    @GetMapping("/decrypt_process")
    public String rsaDecryptPage() {
        logger.info("Showing the start decrypt notification");

        return "main/decrypt_process";
    }
}
