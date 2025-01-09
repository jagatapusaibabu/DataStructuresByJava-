import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class HashMapOperations {
    static Map<Integer, String> map = new HashMap<>();

    public static void display() {
        JFrame frame = new JFrame("HashMap Operations");
        frame.setSize(600, 500);
        frame.setLayout(new FlowLayout());

        JTextField keyField = new JTextField(10);
        JTextField valueField = new JTextField(10);
        JButton addButton = new JButton("Add Key-Value Pair");
        JButton removeButton = new JButton("Remove Key");
        JButton searchButton = new JButton("Search Key");
        JButton displayButton = new JButton("Display All");
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Add key-value pair
        addButton.addActionListener(e -> {
            int key = Integer.parseInt(keyField.getText());
            String value = valueField.getText();
            addKeyValuePair(key, value);
            keyField.setText("");
            valueField.setText("");
            updateOutput(outputArea);
        });

        // Remove key
        removeButton.addActionListener(e -> {
            int key = Integer.parseInt(keyField.getText());
            removeKey(key);
            keyField.setText("");
            updateOutput(outputArea);
        });

        // Search key
        searchButton.addActionListener(e -> {
            int key = Integer.parseInt(keyField.getText());
            String value = searchKey(key);
            if (value != null) {
                JOptionPane.showMessageDialog(frame, "Key found with value: " + value);
            } else {
                JOptionPane.showMessageDialog(frame, "Key not found");
            }
        });

        // Display all
        displayButton.addActionListener(e -> {
            String result = displayAll();
            outputArea.setText(result);
        });

        frame.add(new JLabel("Enter Key:"));
        frame.add(keyField);
        frame.add(new JLabel("Enter Value:"));
        frame.add(valueField);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(searchButton);
        frame.add(displayButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    public static void addKeyValuePair(int key, String value) {
        map.put(key, value);
    }

    public static void removeKey(int key) {
        map.remove(key);
    }

    public static String searchKey(int key) {
        return map.get(key);
    }

    public static String displayAll() {
        StringBuilder result = new StringBuilder("HashMap Entries:\n");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    private static void updateOutput(JTextArea outputArea) {
        outputArea.setText(displayAll());
    }
}
