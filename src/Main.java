import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ZooManager manager = new ZooManager();

        //Load previous data
        manager.loadFromFiles();

        int choice;

        do {
            System.out.println("\n--- Belfast Zoo Management ---");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. View All Animals");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Colour");
            System.out.println("6. Perform Daily Care");
            System.out.println("7. Zoo Report");
            System.out.println("8. Save and Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); //clear buffer

            switch (choice) {

                case 1:
                    System.out.println("Choose Animal Type:");
                    System.out.println("1. Penguin");
                    System.out.println("2. Parrot");
                    System.out.println("3. Dolphin");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    System.out.print("Colour: ");
                    sc.nextLine();
                    String colour = sc.nextLine();

                    System.out.print("Weight: ");
                    double weight = sc.nextDouble();

                    if (type == 1) {
                        System.out.print("Swim Speed: ");
                        double speed = sc.nextDouble();
                        manager.addAnimal(new Penguin(name, age, colour, weight, speed));

                    } else if (type == 2) {
                        System.out.print("Wing Span: ");
                        double wing = sc.nextDouble();
                        manager.addAnimal(new Parrot(name, age, colour, weight, wing));

                    } else if (type == 3) {
                        System.out.print("Sonar Range: ");
                        double sonar = sc.nextDouble();
                        manager.addAnimal(new Dolphin(name, age, colour, weight, sonar));
                    }
                    break;

                case 2:
                    System.out.print("Enter animal to remove: ");
                    String removeName = sc.nextLine();
                    manager.removeAnimal(removeName);
                    break;

                case 3:
                    manager.viewAllAnimals();
                    break;

                case 4:
                    System.out.print("Enter name: ");
                    String searchName = sc.nextLine();
                    manager.searchByName(searchName);
                    break;

                case 5:
                    System.out.print("Enter colour: ");
                    String searchColour = sc.nextLine();
                    manager.searchByColour(searchColour);
                    break;

                case 6:
                    manager.performDailyCare();
                    break;

                case 7:
                    manager.printZooReport();
                    break;

                case 8:
                    manager.saveToFiles();
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}