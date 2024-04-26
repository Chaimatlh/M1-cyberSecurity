package application;

import javax.swing.*;

import application.MessageListModel.MessageObserver;

import java.awt.*;
import java.util.List;
public class MessageView extends JFrame implements MessageObserver {

    private MessageListModel messageListModel;
    private JTextArea messageTextArea;

    public MessageView(MessageListModel messageListModel, int x, int y) {
        this.messageListModel = messageListModel;
        this.messageListModel.addObserver(this);

        setTitle("Message View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 370);
        setLocation(x, y);

        JPanel panel = new JPanel(new BorderLayout());

        messageTextArea = new JTextArea();
        messageTextArea.setFont(messageTextArea.getFont().deriveFont(Font.BOLD));
        messageTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(messageTextArea);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setBackground(new Color(192, 255, 209));

        setContentPane(panel);
    }

    public void display() {
        setVisible(true);
    }

    @Override
    public void update(String message) {
        if (messageTextArea != null) {
            messageTextArea.append(message + "\n");
        } else {
            System.out.println("Warning: messageTextArea not set in MessageView!");
        }
    }
}
