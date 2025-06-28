import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChatbotGUI extends JFrame {
    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    Map<String, String> responses;

    public ChatbotGUI() {
        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        responses = new HashMap<>();
        responses.put("hello", "Hi! How can I help you?");
        responses.put("how are you", "I'm just a bot, but I'm doing great!");
        responses.put("what is your name", "I am a simple AI chatbot.");
        responses.put("bye", "Goodbye! Have a nice day.");

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    public void sendMessage() {
        String userText = inputField.getText().toLowerCase().trim();
        chatArea.append("You: " + userText + "\n");
        inputField.setText("");

        String response = getResponse(userText);
        chatArea.append("Bot: " + response + "\n");
    }

    public String getResponse(String input) {
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }
        return "I'm sorry, I don't understand.";
    }

    public static void main(String[] args) {
        new ChatbotGUI();
    }
}
