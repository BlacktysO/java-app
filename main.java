import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Welcome to the Advanced Dockerized Java App! 🚀");

        // Reading environment variables
        String appName = System.getenv("APP_NAME");
        if (appName == null || appName.isEmpty()) {
            appName = "Default Java App";
        }
        System.out.println("App Name: " + appName);

        // Interactive input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Simulate some work with threads
        System.out.println("Processing your request...");
        simulateProcessing();

        // Final message
        System.out.println("Hello, " + name + "! 🎉");
        System.out.println("Thanks for trying out " + appName + ".");
        
        scanner.close();
    }

    private static void simulateProcessing() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Step " + i + " of 3...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Processing interrupted!");
        }
    }
}
