public class Animal {

    protected String name;
    protected int age;
    protected String colour;
    protected double weight;


    //Animal Details
    public Animal(String name, int age, String colour, double weight) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }

    public String makeSound() {
        return "This animal makes a sound.";
    }

    // Validation
    public boolean isValid() {
        return name != null && name.length() > 0 &&
                colour != null && colour.length() > 0 &&
                age >= 0 &&
                weight > 0;
    }
    // Return animal details as string
    public String getDetails() {
        return "Name: " + name +
                ", Age: " + age +
                ", Colour: " + colour +
                ", Weight: " + weight + "kg";
    }
    // Convert for file
    public String toFileString() {
        return "Animal," + name + "," + age + "," + colour + "," + weight;
    }


    //Getters
    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}