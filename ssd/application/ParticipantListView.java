package application;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ParticipantListView extends JFrame implements ParticipantListModel.Observer {
    private ParticipantListModel participantModel;
    private JTextArea participantTextArea;

    public ParticipantListView(ParticipantListModel participantModel, int h, int v) {
        this.participantModel = participantModel;
        this.participantModel.addObserver(this);

        setTitle("Participant List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 370);
        setLocation(h, v);

        JPanel panel = new JPanel(new BorderLayout());

        participantTextArea = new JTextArea();
        participantTextArea.setFont(participantTextArea.getFont().deriveFont(Font.BOLD));
        participantTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(participantTextArea);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setBackground(new Color(255, 192, 209)); 
        
        setContentPane(panel);
        setVisible(true);
    }

    @Override
    public void update() {
        List<Participant> participants = participantModel.getParticipants();
        StringBuilder sb = new StringBuilder();

        for (Participant participant : participants) {
            sb.append("ID: ").append(participant.getId()).append("\n");
            sb.append("Pseudo: ").append(participant.getPseudo()).append("\n");
            sb.append("Password: ").append(participant.getPassword()).append("\n\n");
        }

        participantTextArea.setText(sb.toString());
    }
}