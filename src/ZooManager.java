import java.io.*;
import java.util.ArrayList;

public class ZooManager {

    private ArrayList<Animal> animals;
    private Zoo zoo;

    //Zoo manager details
    public ZooManager() {
        animals = new ArrayList<>();
        zoo = new Zoo("Belfast Zoo", "Belfast");
    }

    //Add animal
    public void addAnimal(Animal animal) {
        if (animal != null && animal.isValid()) {
            animals.add(animal);
            System.out.println("Animal added successfully.");
        } else {
            System.out.println("Animal details are invalid and were not saved.");
        }
    }

    //Remove animal by name
    public void removeAnimal(String name) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equalsIgnoreCase(name)) {
                animals.remove(i);
                System.out.println("Animal removed successfully.");
                return;
            }
        }

        System.out.println("Animal not found.");
    }

    //View all animals
    public void viewAllAnimals() {
        if (animals.size() == 0) {
            System.out.println("No animals registered.");
            return;
        }

        for (Animal animal : animals) {
            System.out.println(animal.getDetails());
            System.out.println(animal.makeSound());
            System.out.println();
        }
    }

    //Search by name
    public void searchByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println(animal.getDetails());
                System.out.println(animal.makeSound());
                return;
            }
        }

        System.out.println("Animal not found.");
    }

    //Search by colour
    public void searchByColour(String colour) {
        boolean found = false;

        for (Animal animal : animals) {
            if (animal.getColour().equalsIgnoreCase(colour)) {
                System.out.println(animal.getDetails());
                System.out.println(animal.makeSound());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No animals found with that colour.");
        }
    }

    //Daily care for animals
    public void performDailyCare() {
        if (animals.size() == 0) {
            System.out.println("No animals registered.");
            return;
        }

        for (Animal animal : animals) {
            System.out.println("General care completed for " + animal.getName());

            if (animal instanceof Swimmable) {
                Swimmable swimmer = (Swimmable) animal;
                swimmer.waterCare();
            }

            if (animal instanceof Flyable) {
                Flyable flyer = (Flyable) animal;
                flyer.wingCare();
            }

            System.out.println();
        }
    }

    //Zoo report
    public void printZooReport() {
        int penguinCount = 0;
        int parrotCount = 0;
        int dolphinCount = 0;

        for (Animal animal : animals) {
            if (animal instanceof Penguin) {
                penguinCount++;
            } else if (animal instanceof Parrot) {
                parrotCount++;
            } else if (animal instanceof Dolphin) {
                dolphinCount++;
            }
        }

        System.out.println(zoo.getZooDetails());
        System.out.println("Total animals: " + animals.size());
        System.out.println("Penguins: " + penguinCount);
        System.out.println("Parrots: " + parrotCount);
        System.out.println("Dolphins: " + dolphinCount);
        System.out.println("Main colour: " + getDominantColour());
    }

    //Find most common colour
    public String getDominantColour() {
        if (animals.size() == 0) {
            return "None";
        }

        String dominantColour = animals.get(0).getColour();
        int highestCount = 0;

        for (Animal animal1 : animals) {
            int count = 0;

            for (Animal animal2 : animals) {
                if (animal1.getColour().equalsIgnoreCase(animal2.getColour())) {
                    count++;
                }
            }

            if (count > highestCount) {
                highestCount = count;
                dominantColour = animal1.getColour();
            }
        }

        return dominantColour;
    }

    //Save details
    public void saveToFiles() {
        try {
            PrintWriter zooWriter = new PrintWriter(new FileWriter("ZooDetails.txt"));
            zooWriter.println(zoo.toFileString());
            zooWriter.close();

            PrintWriter animalWriter = new PrintWriter(new FileWriter("AnimalDetails.txt"));

            for (Animal animal : animals) {
                if (animal != null && animal.isValid()) {
                    animalWriter.println(animal.toFileString());
                }
            }

            animalWriter.close();
            System.out.println("Details saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    //Load details from file
    public void loadFromFiles() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("AnimalDetails.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String type = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String colour = parts[3];
                double weight = Double.parseDouble(parts[4]);
                double extra = Double.parseDouble(parts[5]);

                if (type.equalsIgnoreCase("Penguin")) {
                    animals.add(new Penguin(name, age, colour, weight, extra));
                } else if (type.equalsIgnoreCase("Parrot")) {
                    animals.add(new Parrot(name, age, colour, weight, extra));
                } else if (type.equalsIgnoreCase("Dolphin")) {
                    animals.add(new Dolphin(name, age, colour, weight, extra));
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No previous animal file found.");
        } catch (Exception e) {
            System.out.println("Error loading animal file.");
        }
    }

    //Return number of animals
    public int getAnimalCount() {
        return animals.size();
    }
}
