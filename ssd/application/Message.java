package application;
public class Message {
    private int messageId;
    private String sender;
    private String receiver;
    private String messageContent;

    public Message(String sender, String receiver, String messageContent) {
        this.messageId = generateMessageId();
        this.sender = sender;
        this.receiver = receiver;
        this.messageContent = messageContent;
    }

    private static int messageCounter = 0;

    private static int generateMessageId() {
        return ++messageCounter;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}