package Facade;

public class User {
    private int userID;
    private String name;
    private String address;
    private String phone;


    public User(int userID, String name, String address, String phone) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public User(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
