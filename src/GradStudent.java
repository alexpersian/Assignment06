/**
 * Alexander Persian
 * ICS 141
 * 04/27/2014
 * GradStudent
 */

import java.io.Serializable;

public class GradStudent extends Person implements StudentDescription, Serializable {

    // GradStudent constructor with values
    public GradStudent(String name, String address, double balance, String major) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.major = major;
    }

    // Override toString to return info from array
    public String toString() {
        return "\nGraduate student added: " + "\n  Name: " + name + "\n  "
                + returnTimeSpent(0) + "\n  Address: " + address
                + "\n  Balance: $" + balance + "\n  Major: " + major;
    }

    public String getNme() {
        return name;
    }

    public double getBal() {
        return balance;
    }

    public String getMaj() {
        return major;
    }

    //    @Override
    public String returnTimeSpent(int year) {
        return "Time spent: more than 4 years.";
    }
}