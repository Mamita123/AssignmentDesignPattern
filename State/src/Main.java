import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for user input
        System.out.println("Enter your character's name:");
        String name = scanner.nextLine();

        System.out.println("Choose a level:");
        System.out.println("1. Novice");
        System.out.println("2. Intermediate");
        System.out.println("3. Expert");
        System.out.println("4. Master");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        // Display chosen level and character attributes
        switch (choice) {
            case 1:
                System.out.println("\nName: " + name);
                System.out.println("Level: Novice");
                System.out.println("Experience Points: 0");
                System.out.println("Health Points: 100");
                System.out.println("Actions: train");
                break;
            case 2:
                System.out.println("\nName: " + name);
                System.out.println("Level: Intermediate");
                System.out.println("Experience Points: 0");
                System.out.println("Health Points: 100");
                System.out.println("Actions: train, meditate");
                break;
            case 3:
                System.out.println("\nName: " + name);
                System.out.println("Level: Expert");
                System.out.println("Experience Points: 0");
                System.out.println("Health Points: 100");
                System.out.println("Actions: train, meditate, fight");
                break;
            case 4:
                System.out.println("\nName: " + name);
                System.out.println("Level: Master");
                System.out.println("Experience Points: 0");
                System.out.println("Health Points: 100");
                System.out.println("Actions: train, meditate, fight");
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                return; // Exit the program
        }
    }
}

