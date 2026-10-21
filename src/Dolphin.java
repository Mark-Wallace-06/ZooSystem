public class Dolphin extends Animal implements Swimmable {

    private double sonarRange;

    //Dolphin Details
    public Dolphin(String name, int age, String colour, double weight, double sonarRange) {
        super(name, age, colour, weight);
        this.sonarRange = sonarRange;
    }

    //Dolphin sound
    @Override
    public String makeSound() {
        return "Click, I am " + name + ", a " + age + " year old dolphin.";
    }

    //Swim method
    @Override
    public void canSwim() {
        System.out.println(name + " is swimming using sonar range of " + sonarRange + " meters.");
    }

    //Water care
    @Override
    public void waterCare() {
        System.out.println(name + " has had their water health check completed.");
    }

    //Return dolphin details as string
    @Override
    public String getDetails() {
        return "Type: Dolphin, " + super.getDetails() +
                ", Sonar Range: " + sonarRange + " m";
    }

    //Convert for file
    @Override
    public String toFileString() {
        return "Dolphin," + name + "," + age + "," + colour + "," + weight + "," + sonarRange;
    }

    //Getter
    public double getSonarRange() {
        return sonarRange;
    }

    //Setter
    public void setSonarRange(double sonarRange) {
        this.sonarRange = sonarRange;
    }
}
