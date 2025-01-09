import java.awt.*;
import javax.swing.*;

public class ArrayOperations {
    static int[] array = new int[10];
    static int size = 0;

    public static void display() {
        JFrame frame = new JFrame("Array Operations");
        frame.setSize(600, 500);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JTextField indexField = new JTextField(5);
        JButton addButton = new JButton("Add");
        JButton insertButton = new JButton("Insert at Index");
        JButton deleteButton = new JButton("Delete at Index");
        JButton searchButton = new JButton("Search");
        JButton isEmptyButton = new JButton("Is Empty?");
        JButton isFullButton = new JButton("Is Full?");
        JButton updateButton = new JButton("Update at Index");
        JButton sizeButton = new JButton("Size");
        JButton resetButton = new JButton("Reset");
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Add element to the end of the array
        addButton.addActionListener(e -> {
            if (size < array.length) {
                array[size++] = Integer.parseInt(inputField.getText());
                inputField.setText("");
                updateOutput(outputArea);
            } else {
                JOptionPane.showMessageDialog(frame, "Array is full");
            }
        });

        // Insert element at a specific index
        insertButton.addActionListener(e -> {
            int index = Integer.parseInt(indexField.getText());
            if (size < array.length && index >= 0 && index <= size) {
                for (int i = size; i > index; i--) {
                    array[i] = array[i - 1];
                }
                array[index] = Integer.parseInt(inputField.getText());
                size++;
                inputField.setText("");
                updateOutput(outputArea);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid index or Array is full");
            }
        });

        // Delete element at a specific index
        deleteButton.addActionListener(e -> {
            int index = Integer.parseInt(indexField.getText());
            if (index >= 0 && index < size) {
                for (int i = index; i < size - 1; i++) {
                    array[i] = array[i + 1];
                }
                size--;
                updateOutput(outputArea);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid index");
            }
        });

        // Search for an element
        searchButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (array[i] == value) {
                    JOptionPane.showMessageDialog(frame, "Value found at index: " + i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(frame, "Value not found");
            }
        });

        // Check if the array is empty
        isEmptyButton.addActionListener(e -> {
            if (size == 0) {
                JOptionPane.showMessageDialog(frame, "Array is empty");
            } else {
                JOptionPane.showMessageDialog(frame, "Array is not empty");
            }
        });

        // Check if the array is full
        isFullButton.addActionListener(e -> {
            if (size == array.length) {
                JOptionPane.showMessageDialog(frame, "Array is full");
            } else {
                JOptionPane.showMessageDialog(frame, "Array is not full");
            }
        });

        // Update an element at a specific index
        updateButton.addActionListener(e -> {
            int index = Integer.parseInt(indexField.getText());
            if (index >= 0 && index < size) {
                array[index] = Integer.parseInt(inputField.getText());
                inputField.setText("");
                updateOutput(outputArea);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid index");
            }
        });

        // Display the size of the array
        sizeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Current size of the array: " + size);
        });

        // Reset the array
        resetButton.addActionListener(e -> {
            size = 0;
            updateOutput(outputArea);
            JOptionPane.showMessageDialog(frame, "Array has been reset");
        });

        frame.add(new JLabel("Enter Number:"));
        frame.add(inputField);
        frame.add(new JLabel("Index:"));
        frame.add(indexField);
        frame.add(addButton);
        frame.add(insertButton);
        frame.add(deleteButton);
        frame.add(searchButton);
        frame.add(updateButton);
        frame.add(isEmptyButton);
        frame.add(isFullButton);
        frame.add(sizeButton);
        frame.add(resetButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    private static void updateOutput(JTextArea outputArea) {
        StringBuilder output = new StringBuilder("Array Elements:\n");
        for (int i = 0; i < size; i++) {
            output.append(array[i]).append(" ");
        }
        outputArea.setText(output.toString());
    }
}
