package models;

public class Contact {
    private String name, phNumber;

    public Contact(String name, String phNumber) {
        this.name = name;
        this.phNumber = phNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
}
