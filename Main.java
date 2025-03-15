package com.example.advancedapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class AdvancedApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdvancedApplication.class, args);
    }
}

@RestController
class GreetingController {

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "User") String name) {
        String appName = System.getenv("APP_NAME");
        if (appName == null || appName.isEmpty()) {
            appName = "Default Java Web App";
        }
        
        executorService.submit(() -> simulateProcessing());

        return "Hello, " + name + "! 🎉 Welcome to " + appName;
    }

    private void simulateProcessing() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Processing step " + i + " of 3...");
                Thread.sleep(1000);
            }
            System.out.println("Processing complete!");
        } catch (InterruptedException e) {
            System.out.println("Processing interrupted!");
        }
    }
}
