import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for computer type
        System.out.println("Choose computer type:");
        System.out.println("1. Gaming Computer");
        System.out.println("2. Office Computer");
        int computerTypeChoice = scanner.nextInt();

        // Choose appropriate builder based on user choice
        ComputerBuilder computerBuilder;
        if (computerTypeChoice == 1) {
            computerBuilder = new GamingComputerBuilder();
        } else {
            computerBuilder = new OfficeComputerBuilder();
        }

        // Construct computer
        ComputerDirector computerDirector = new ComputerDirector(computerBuilder);

        // Ask user to select components
        System.out.println("Enter processor:");
        String processor = scanner.next();
        System.out.println("Enter RAM size (in GB):");
        int ramSizeGB = scanner.nextInt();
        System.out.println("Enter hard drive specification:");
        String hardDrive = scanner.next();
        System.out.println("Enter graphics card:");
        String graphicsCard = scanner.next();
        System.out.println("Enter operating system:");
        String operatingSystem = scanner.next();

        // Construct computer without accessories
        computerDirector.constructComputer(processor, ramSizeGB, hardDrive, graphicsCard, operatingSystem);

        // Ask user for additional accessories
        List<String> accessories = new ArrayList<>();
        while (true) {
            System.out.println("Add accessory? (yes/no)");
            String addAccessory = scanner.next().toLowerCase();
            if (addAccessory.equals("yes")) {
                System.out.println("Choose accessory:");
                System.out.println("1. Keyboard");
                System.out.println("2. Mouse");
                System.out.println("3. Headset");
                int accessoryChoice = scanner.nextInt();
                switch (accessoryChoice) {
                    case 1:
                        accessories.add("Keyboard");
                        break;
                    case 2:
                        accessories.add("Mouse");
                        break;
                    case 3:
                        accessories.add("Headset");
                        break;
                }
            } else {
                break;
            }
        }

        // Add accessories to the computer
        computerDirector.addAccessories(accessories);

        // Display final computer configuration
        System.out.println("Final Configuration:");
        Computer computer = computerDirector.getComputer();
        System.out.println("Processor: " + computer.getProcessor());
        System.out.println("RAM Size: " + computer.getRamSizeGB() + " GB");
        System.out.println("Hard Drive: " + computer.getHardDrive());
        System.out.println("Graphics Card: " + computer.getGraphicsCard());
        System.out.println("Operating System: " + computer.getOperatingSystem());
        System.out.println("Accessories: " + computer.getAccessories());
    }
}
