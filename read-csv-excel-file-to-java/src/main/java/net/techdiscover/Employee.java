package net.techdiscover;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String physicalAddress;
    private String emailAddress;

    public Employee(String id, String firstName, String lastName, String physicalAddress, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.physicalAddress = physicalAddress;
        this.emailAddress = emailAddress;
    }

    public void print() {
        System.out.println(this.id + " | "  + this.firstName + " | " +this.lastName + " | " + this.physicalAddress + " | " + this.emailAddress);
    }
}
