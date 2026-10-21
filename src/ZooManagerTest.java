public class ZooManagerTest {
    public static void main(String[] args) {

        testAddValidAnimal();
        testAddInvalidAnimal();
    }

    public static void testAddValidAnimal() {
        ZooManager manager = new ZooManager();

        Animal animal = new Penguin("Pingu", 5, "Black", 13.5, 10.2);
        manager.addAnimal(animal);

        if (manager.getAnimalCount() == 1) {
            System.out.println("testAddValidAnimal: Passed");
        } else {
            System.out.println("testAddValidAnimal: Failed");
        }
    }

    public static void testAddInvalidAnimal() {
        ZooManager manager = new ZooManager();

        Animal animal = new Penguin("", 4, "Black", 12.5, 8.2);
        manager.addAnimal(animal);

        if (manager.getAnimalCount() == 0) {
            System.out.println("testAddInvalidAnimal: Passed");
        } else {
            System.out.println("testAddInvalidAnimal: Failed");
        }
    }
}