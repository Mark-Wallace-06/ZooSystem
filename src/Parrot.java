public class Parrot extends Animal implements Flyable {

    private double wingSpan;

    //Parrot Details
    public Parrot(String name, int age, String colour, double weight, double wingSpan) {
        super(name, age, colour, weight);
        this.wingSpan = wingSpan;
    }

    //Parrot sound
    @Override
    public String makeSound() {
        return "Squawk, I am " + name + ", a " + age + " year old parrot.";
    }

    //Fly method
    @Override
    public void canFly() {
        System.out.println(name + " is flying with a wingspan of " + wingSpan + " meters.");
    }

    //Wing care
    @Override
    public void wingCare() {
        System.out.println(name + " has had their wing health check completed.");
    }

    //Return parrot details
    @Override
    public String getDetails() {
        return "Type: Parrot, " + super.getDetails() +
                ", Wing Span: " + wingSpan + " m";
    }

    //Convert for file
    @Override
    public String toFileString() {
        return "Parrot," + name + "," + age + "," + colour + "," + weight + "," + wingSpan;
    }

    //Getter
    public double getWingSpan() {
        return wingSpan;
    }

    //Setter
    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }
}
