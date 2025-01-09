import java.awt.*;
import java.util.TreeMap;
import javax.swing.*;

public class TreeMapExample {
    static TreeMap<Integer, String> treeMap = new TreeMap<>();

    public static void display() {
        JFrame frame = new JFrame("TreeMap Operations");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        JTextField keyField = new JTextField(10);
        JTextField valueField = new JTextField(10);
        JButton addButton = new JButton("Add Key-Value");
        JButton removeButton = new JButton("Remove Key");
        JButton sizeButton = new JButton("Size of TreeMap");
        JButton checkKeyButton = new JButton("Check Key Existence");
        JButton clearButton = new JButton("Clear TreeMap");
        JButton firstEntryButton = new JButton("First Entry");
        JButton lastEntryButton = new JButton("Last Entry");
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        addButton.addActionListener(e -> {
            int key = Integer.parseInt(keyField.getText());
            String value = valueField.getText();
            treeMap.put(key, value);
            keyField.setText("");
            valueField.setText("");
            updateOutput(outputArea);
        });

        removeButton.addActionListener(e -> {
            int key = Integer.parseInt(keyField.getText());
            treeMap.remove(key);
            updateOutput(outputArea);
        });

        sizeButton.addActionListener(e -> {
            outputArea.setText("Size of TreeMap: " + treeMap.size());
        });

        checkKeyButton.addActionListener(e -> {
            int key = Integer.parseInt(keyField.getText());
            boolean exists = treeMap.containsKey(key);
            outputArea.setText(exists ? "Key exists" : "Key does not exist");
        });

        clearButton.addActionListener(e -> {
            treeMap.clear();
            updateOutput(outputArea);
        });

        firstEntryButton.addActionListener(e -> {
            if (!treeMap.isEmpty()) {
                outputArea.setText("First Entry: " + treeMap.firstEntry());
            } else {
                outputArea.setText("TreeMap is empty");
            }
        });

        lastEntryButton.addActionListener(e -> {
            if (!treeMap.isEmpty()) {
                outputArea.setText("Last Entry: " + treeMap.lastEntry());
            } else {
                outputArea.setText("TreeMap is empty");
            }
        });

        frame.add(new JLabel("Enter Key:"));
        frame.add(keyField);
        frame.add(new JLabel("Enter Value:"));
        frame.add(valueField);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(sizeButton);
        frame.add(checkKeyButton);
        frame.add(clearButton);
        frame.add(firstEntryButton);
        frame.add(lastEntryButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    private static void updateOutput(JTextArea outputArea) {
        StringBuilder output = new StringBuilder("TreeMap Entries:\n");
        for (Integer key : treeMap.keySet()) {
            output.append(key).append(": ").append(treeMap.get(key)).append("\n");
        }
        outputArea.setText(output.toString());
    }
}
