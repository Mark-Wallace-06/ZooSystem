public class Zoo {

    private String zooName;
    private String location;

    //Zoo Details
    public Zoo(String zooName, String location) {
        this.zooName = zooName;
        this.location = location;
    }

    //Return zoo details
    public String getZooDetails() {
        return "Zoo Name: " + zooName + ", Location: " + location;
    }

    //Convert for file
    public String toFileString() {
        return zooName + "," + location;
    }

    //Getters
    public String getZooName() {
        return zooName;
    }

    public String getLocation() {
        return location;
    }

    //Setters
    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
