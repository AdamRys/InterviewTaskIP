package data;

public class UserData {
    private final String name;
    private final String last;
    private final String zip;


    public UserData(String name, String last, String zip) {
        this.name = name;
        this.last = last;
        this.zip = zip;
    }
    // Getters
    public String getName() {
        return name;
    }

    public String getLast() {
        return last;
    }

    public String getZip() {
        return zip;
    }
    //Static user data
    public static final UserData BASICUSER = new UserData(
            "Firstian",
            "LastNejmski",
            "12-345"
    );
}
