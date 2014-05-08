/**
 * Alexander Persian
 * ICS 141
 * 04/27/2014
 * Student
 */

import java.io.Serializable;

public class Student extends Person implements StudentDescription, Serializable {

    // Student constructor with values
    public Student(String name, int year, String address, double balance,
                   String major) {
        this.name = name;
        this.year = year;
        this.address = address;
        this.balance = balance;
        this.major = major;
    }

    // Override toString to return info from array
    public String toString() {
        return "\nStudent added: " + "\n  Name: " + name + "\n  " + returnTimeSpent(year)
                + "\n  Address: " + address + "\n  Balance: $" + balance
                + "\n  Major: " + major;
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
        String timeSpent = null;
        if (year == 0) {
            timeSpent = "Time spent: < 1 year.";
        } else if (year == 1) {
            timeSpent = "Time spent: 1 - 2 years.";
        } else if (year == 2) {
            timeSpent = "Time spent: 2 - 3 years.";
        } else if (year == 3) {
            timeSpent = "Time spent: 3 - 4 years.";
        }
        return timeSpent;
    }
}