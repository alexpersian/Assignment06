/**
 * Alexander Persian
 * ICS 141
 * 04/27/2014
 * Assignment06
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Assignment06 extends JFrame {
    // General data fields
    private JTextField jtfName = new JTextField("Name", 20);
    private JTextField jtfAddress = new JTextField("Address", 20);
    private JTextField jtfBalance = new JTextField("Balance", 20);
    private JTextField jtfMajor = new JTextField("Major", 20);
    private JRadioButton jrbStu = new JRadioButton("Student");
    private JRadioButton jrbGrdStu = new JRadioButton("Grad Student");
    private JTextArea jtaOutput = new JTextArea();
    private Manager manager = new Manager();
    private static int year;

    // Class constructor
    public Assignment06() {

        // Create a JComboBox
        String options[] = {"Freshman", "Sophomore", "Junior", "Senior"};
        final JComboBox<String> jcbClass = new JComboBox<String>(options);

        // Create a scrollable pane
        JScrollPane jspView = new JScrollPane(jtaOutput);
        jtaOutput.setEditable(false);

        // Create a button group + panel for radio options
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(jrbStu);
        btnGroup.add(jrbGrdStu);

        // Create buttons and assign listeners
        JButton jbtSubmit = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbStu.isSelected()) {
                    manager.addStudent(jtfName.getText(), year,
                            jtfAddress.getText(), Double.parseDouble(jtfBalance.getText()),
                            jtfMajor.getText());
                    jtaOutput.append(manager.getStudent());
                } else if (jrbGrdStu.isSelected()) {
                    manager.addGradStudent(jtfName.getText(), jtfAddress.getText(),
                            Double.parseDouble(jtfBalance.getText()), jtfMajor.getText());
                    jtaOutput.append(manager.getGradStudent());
                }
            }
        });
        JButton jbtStuNms = new JButton(new AbstractAction("Student Names") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaOutput.append(manager.printStuNames());
            }
        });
        JButton jbtGrdNms = new JButton(new AbstractAction("Grad Student Names") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaOutput.append(manager.printGrdNames());
            }
        });
        JButton jbtAvgBal = new JButton(new AbstractAction("Average Balance") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaOutput.append(String.valueOf(manager.printAvgBal()));
            }
        });
        JButton jbtAllMaj = new JButton(new AbstractAction("CS Majors") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaOutput.append(manager.printStuCompSci());
            }
        });

        jcbClass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setClass(jcbClass.getSelectedIndex());
            }
        });

        // Create panel and add elements to it
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(jrbStu);
        inputPanel.add(jtfName);
        inputPanel.add(jrbGrdStu);
        inputPanel.add(jtfAddress);
        inputPanel.add(jcbClass);
        inputPanel.add(jtfBalance);
        inputPanel.add(jbtSubmit);
        inputPanel.add(jtfMajor);
        inputPanel.add(jbtStuNms);
        inputPanel.add(jbtGrdNms);
        inputPanel.add(jbtAvgBal);
        inputPanel.add(jbtAllMaj);

        // Add panel/scrollable output area to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(jspView);
    }

    public JMenuBar createMenuBar() {
        // Create JMenuBar and add menu+items
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuItem;

        menuItem = new JMenuItem(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaOutput.append("Saved\n");
                try {
                    manager.saveData();
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem(new AbstractAction("Load") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaOutput.append("Loaded\n");
                try {
                    manager.loadData();
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        return menuBar;
    }

    // Main method (creates frame)
    public static void main(String[] args) {
        Assignment06 frame = new Assignment06();
        frame.setTitle("Student Database");
        frame.setJMenuBar(frame.createMenuBar());
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setClass(int index) {
        Assignment06.year = index;
    }
}