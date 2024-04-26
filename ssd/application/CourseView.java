package application;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
public class CourseView extends JFrame {

    private JTextArea courseTextArea;

    public CourseView() {
        setTitle("Course Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Allow closing without exiting entire app
        setSize(450, 370);
        setLocation(300, 100);

        JPanel panel = new JPanel(new BorderLayout());

        courseTextArea = new JTextArea();
        courseTextArea.setFont(courseTextArea.getFont().deriveFont(Font.BOLD));
        courseTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(courseTextArea);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setBackground(new Color(255, 192, 209));

        setContentPane(panel);
    }

    public void display() {
        setVisible(true);
    }

    public void updateCourse(String courseText) {
        courseTextArea.setText(courseText);
    }
}
