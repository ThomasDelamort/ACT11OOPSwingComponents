import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistration extends JFrame implements ActionListener {

    // Components
    JTextField nameField;
    ButtonGroup yearGroup;
    JRadioButton firstYear;
    JRadioButton secondYear;
    JRadioButton thirdYear;
    JRadioButton fourthYear;

    JCheckBox javaCourse;
    JCheckBox webCourse;

    JMenuItem submitItem = new JMenuItem("Submit");
    JMenuItem Clear = new JMenuItem("Clear");
    JMenuItem exitItem = new JMenuItem("Exit");

    public StudentRegistration() {
        setTitle("Student Registration (Menu-Based)");
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu actions = new JMenu("Actions");
        menuBar.add(actions);
        setJMenuBar(menuBar);

        // Action menu
        actions.add(submitItem);
        actions.add(Clear);
        actions.add(exitItem);

        submitItem.addActionListener(this);
        Clear.addActionListener(this);
        exitItem.addActionListener(this);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10,10, 10));

        // Student name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nameLabel = new JLabel("Student Name: ");
        nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Year Level Panel
        JPanel yearPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        yearPanel.setBorder(BorderFactory.createTitledBorder("Year Level"));

        firstYear = new JRadioButton("1st Year");
        secondYear = new JRadioButton("2nd Year");
        thirdYear = new JRadioButton("3rd Year");
        fourthYear = new JRadioButton("4th Year");

        yearGroup = new ButtonGroup();
        yearGroup.add(firstYear);
        yearGroup.add(secondYear);
        yearGroup.add(thirdYear);
        yearGroup.add(fourthYear);

        yearPanel.add(firstYear);
        yearPanel.add(secondYear);
        yearPanel.add(thirdYear);
        yearPanel.add(fourthYear);

        // Courses Panel
        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        coursePanel.setBorder(BorderFactory.createTitledBorder("Course Enrolled"));

        javaCourse = new JCheckBox("Java Programming");
        webCourse = new JCheckBox("Web Development");

        coursePanel.add(javaCourse);
        coursePanel.add(webCourse);

        // Add all panels
        panel.add(namePanel);
        panel.add(yearPanel);
        panel.add(coursePanel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String yearLvl = "\nYear Level: ";
        String message2 = "Courses Enrolled:\n";

        if (e.getSource() == exitItem) {
            System.exit(0);
        }
        if (e.getSource() == submitItem) {
            if (firstYear.isSelected() ) {
                yearLvl += "1st Year\n";
            } else if (secondYear.isSelected()) {
                yearLvl += "2nd Year\n";
            } else if (thirdYear.isSelected()) {
                yearLvl += "3rd Year\n";
            } else if (fourthYear.isSelected()) {
                yearLvl += "4th Year\n";
            }

            if (javaCourse.isSelected()) {
                message2 += "-Java Programming\n";
            }
            if (webCourse.isSelected()) {
                message2 += "-Web Development\n";
            }
            JOptionPane.showMessageDialog(this, "Student Name: "+name+yearLvl+message2, "Registration Summary", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == Clear) {
            nameField.setText("");
            javaCourse.setSelected(false);
            webCourse.setSelected(false);
            yearGroup.clearSelection();

        }
    }
    public static void main (String[] args) {
        new StudentRegistration();
    }
}