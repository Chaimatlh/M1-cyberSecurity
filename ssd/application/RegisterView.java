package application;

import javax.swing.*;  //  GUI framework for creating desktop applications in Java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame implements ParticipantListModel.Observer {
    private ParticipantListModel participantModel;
    private JTextField idField;
    private JTextField pseudoField;
    private JPasswordField passwordField;

    public RegisterView (ParticipantListModel participantModel, int h, int v) {
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
        pseudoLabel.setFont(pseudoLabel.getFont().deriveFont(Font.BOLD)); // Set the font to bold
        pseudoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pseudoField = new JTextField();


        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(Font.BOLD)); // Set the font to bold
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER); // Set the alignment to center

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setFont(registerButton.getFont().deriveFont(Font.BOLD));

        panel.setBackground(new Color(255, 192, 209)); 

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String pseudo = pseudoField.getText();
                String password = new String(passwordField.getPassword());
                participantModel.registerParticipant(id, pseudo, password);
                clearFields();
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
}