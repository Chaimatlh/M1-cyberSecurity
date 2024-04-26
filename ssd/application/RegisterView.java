package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame implements ParticipantListModel.Observer {
    private ParticipantListModel participantModel;
    private JTextField idField;
    private JTextField pseudoField;
    private JPasswordField passwordField;

    public RegisterView(ParticipantListModel participantModel, int h, int v) {
        this.participantModel = participantModel;
        this.participantModel.addObserver(this);

        setTitle("Registration of New User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 370);
        setLocation(h, v);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(idLabel.getFont().deriveFont(Font.BOLD));
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);

        idField = new JTextField();
        JLabel pseudoLabel = new JLabel("Pseudo:");
        pseudoLabel.setFont(pseudoLabel.getFont().deriveFont(Font.BOLD));
        pseudoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pseudoField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(Font.BOLD));
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setFont(registerButton.getFont().deriveFont(Font.BOLD));

        panel.setBackground(new Color(255, 192, 209));

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                String pseudo = pseudoField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (isValidInput(id, pseudo, password)) {
                    participantModel.registerParticipant(id, pseudo, password);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(RegisterView.this, "Invalid input. Please try again.");
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(pseudoLabel);
        panel.add(pseudoField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);

        setContentPane(panel);
        setVisible(true);
    }

    @Override
    public void update() {
        // Update view if needed
    }

    private void clearFields() {
        idField.setText("");
        pseudoField.setText("");
        passwordField.setText("");
    }

    private boolean isValidInput(String id, String pseudo, String password) {
        // Check if the input contains special characters
        String specialChars = "[!@#$%^&*(),.?\":{}|<>]";
        if (id.matches(".*" + specialChars + ".*") || pseudo.matches(".*" + specialChars + ".*") || password.matches(".*" + specialChars + ".*")) {
            return false;
        }

        // Additional input validation if needed
        return true;
    }
}