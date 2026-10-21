public class Penguin extends Animal implements Swimmable {

    private double swimSpeed;

    //Penguin Details
    public Penguin(String name, int age, String colour, double weight, double swimSpeed) {
        super(name, age, colour, weight);
        this.swimSpeed = swimSpeed;
    }

    //Penguin sound
    @Override
    public String makeSound() {
        return "Squawk I am " + name + ", a " + age + " year old penguin.";
    }

    //Swim method
    @Override
    public void canSwim() {
        System.out.println(name + " is swimming at " + swimSpeed + " mph.");
    }

    //Water care
    @Override
    public void waterCare() {
        System.out.println(name + " has had their water health check completed.");
    }

    //Return penguin details
    @Override
    public String getDetails() {
        return "Type: Penguin, " + super.getDetails() +
                ", Swim Speed: " + swimSpeed + " mph ";
    }

    // Convert for file
    @Override
    public String toFileString() {
        return "Penguin," + name + "," + age + "," + colour + "," + weight + "," + swimSpeed;
    }

    //Getter
    public double getSwimSpeed() {
        return swimSpeed;
    }

    //Setter
    public void setSwimSpeed(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }
}
