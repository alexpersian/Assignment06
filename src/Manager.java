/**
 * Alexander Persian
 * ICS 141
 * 04/08/2014
 * Manager
 */

import java.io.*;
import java.util.ArrayList;

public class Manager {
    // Create an array of student/grad student objects + counters

    ArrayList<Student> stuObjects = new ArrayList<Student>();
    ArrayList<GradStudent> grdObjects = new ArrayList<GradStudent>();

//    private Student[] stuObjects = new Student[50];
//    private GradStudent[] grdObjects = new GradStudent[50];
//    private int stuCount = 0, grdCount = 0;

    public Manager() {
    }

    // Methods for creating & storing students & grad students
    public void addStudent(String name, int year, String address,
                           double balance, String major) {
        Student stu1 = new Student(name, year, address, balance, major);
        stuObjects.add(stu1);
//        stuObjects[stuCount] = stu1;
//        stuCount++;
    }
    public void addGradStudent(String name, String address, double balance,
                               String major) {
        GradStudent grd1 = new GradStudent(name, address, balance, major);
        grdObjects.add(grd1);
//        grdObjects[grdCount] = grd1;
//        grdCount++;
    }

    // Return the last student or grad student added
    public String getStudent() {
        return stuObjects.get(stuObjects.size() - 1) + "\n";
    }
    public String getGradStudent() {
        return grdObjects.get(stuObjects.size() - 1) + "\n";
    }

    // Methods for retrieving data from objects in the arrays
    public String printStuNames() {
        String info = "";
        for (Student stuObject : stuObjects) {
            info += stuObject.getNme() + ", ";
        }
//        for (int i = 0; i < stuCount; i++) {
//            info += stuObjects[i].getNme() + ", ";
//        }
        return "\nStudents: \n" + info;
    }

    public String printGrdNames() {
        String info = "";
        for (GradStudent grdObject : grdObjects) {
            info += grdObject.getNme() + ", ";
        }
//        for (int i = 0; i < grdCount; i++) {
//            info += grdObjects[i].getNme() + ", ";
//        }
        return "\nGraduate Students: \n" + info;
    }

    public String printAvgBal() {
        double total = 0, avg;
        for (Student stuObject : stuObjects) {
            total += stuObject.getBal();
        }
//        for (int i = 0; i < stuCount; i++) {
//            total += stuObjects[i].getBal();
//        }
        for (GradStudent grdObject : grdObjects) {
            total += grdObject.getBal();
        }
//        for (int j = 0; j < grdCount; j++) {
//            total += grdObjects[j].getBal();
//        }
        avg = total / ((stuObjects.size()) + (grdObjects.size()));
        return "\nAverage balance of all students: \n$" + avg;
    }

    public String printStuCompSci() {
        String mNames = "";
        for (Student stuObject : stuObjects) {
            if (stuObject.getMaj().equalsIgnoreCase("computer science")) {
                mNames += stuObject.getNme() + ", ";
            }
        }
//        for (int i = 0; i < stuCount; i++) {
//            if (stuObjects[i].getMaj().equalsIgnoreCase("computer science")) {
//                mNames += stuObjects[i].getNme() + ", ";
//            }
//        }
        for (GradStudent grdObject : grdObjects) {
            if (grdObject.getMaj().equalsIgnoreCase("computer science")) {
                mNames += grdObject.getNme() + ", ";
            }
        }
//        for (int j = 0; j < grdCount; j++) {
//            if (grdObjects[j].getMaj().equalsIgnoreCase("computer science")) {
//                mNames += grdObjects[j].getNme() + ", ";
//            }
//        }
        return "\nStudents with the Computer Science major: \n" + mNames;
    }

    public void saveData() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(new File("data.dat"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(stuObjects);
            oos.writeObject(grdObjects);

            oos.close();
            fos.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadData() throws IOException {
        try {
            FileInputStream fis = new FileInputStream("data.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object objS = ois.readObject();
            ArrayList<Student> stuObjects = (ArrayList<Student>) objS;

            Object objG = ois.readObject();
            ArrayList<GradStudent> grdObjects = (ArrayList<GradStudent>) objG;

            ois.close();
            fis.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}