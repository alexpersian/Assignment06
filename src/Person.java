/**
 * Alexander Persian
 * ICS 141
 * 04/27/2014
 * Person
 */

import java.io.Serializable;

public abstract class Person implements Serializable {
    // Abstract data fields and methods for Student/GradStudent
    protected String name;
    protected int year;
    protected String address;
    protected double balance;
    protected String major;

    protected Person() {
    }

    protected abstract String getNme();

    protected abstract double getBal();

    protected abstract String getMaj();

}
