package application;

public class MVCChat {
    public static void main(String[] args) {
        ParticipantListModel participantModel = new ParticipantListModel();
        RegisterView registerView = new RegisterView(participantModel, 100, 100);
        ParticipantListView participantListView = new ParticipantListView(participantModel, 600, 100);
    }
}