import java.awt.*;
import javax.swing.*;

public class SinglyLinkedListOperations {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    public static void display() {
        JFrame frame = new JFrame("Singly Linked List Operations");
        frame.setSize(600, 500);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JTextField positionField = new JTextField(5);
        JButton addButton = new JButton("Add at End");
        JButton addAtPositionButton = new JButton("Add at Position");
        JButton deleteFirstButton = new JButton("Delete First");
        JButton deleteAtPositionButton = new JButton("Delete at Position");
        JButton deleteLastButton = new JButton("Delete Last");
        JButton searchButton = new JButton("Search");
        JButton reverseButton = new JButton("Reverse List");
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Add at end
        addButton.addActionListener(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                add(value);
                inputField.setText("");
                updateOutput(outputArea);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        });

        // Add at position
        addAtPositionButton.addActionListener(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                int position = Integer.parseInt(positionField.getText());
                addAtPosition(value, position);
                inputField.setText("");
                positionField.setText("");
                updateOutput(outputArea);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
            }
        });

        // Delete first
        deleteFirstButton.addActionListener(e -> {
            deleteFirst();
            updateOutput(outputArea);
        });

        // Delete at position
        deleteAtPositionButton.addActionListener(e -> {
            try {
                int position = Integer.parseInt(positionField.getText());
                deleteAtPosition(position);
                positionField.setText("");
                updateOutput(outputArea);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid position.");
            }
        });

        // Delete last
        deleteLastButton.addActionListener(e -> {
            deleteLast();
            updateOutput(outputArea);
        });

        // Search
        searchButton.addActionListener(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                boolean found = search(value);
                if (found) {
                    JOptionPane.showMessageDialog(frame, "Value found.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Value not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        });

        // Reverse list
        reverseButton.addActionListener(e -> {
            reverse();
            updateOutput(outputArea);
        });

        frame.add(new JLabel("Enter Number:"));
        frame.add(inputField);
        frame.add(new JLabel("Position:"));
        frame.add(positionField);
        frame.add(addButton);
        frame.add(addAtPositionButton);
        frame.add(deleteFirstButton);
        frame.add(deleteAtPositionButton);
        frame.add(deleteLastButton);
        frame.add(searchButton);
        frame.add(reverseButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    public static void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public static void addAtPosition(int value, int position) {
        Node newNode = new Node(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid position.");
            }
        }
    }

    public static void deleteFirst() {
        if (head != null) {
            head = head.next;
        } else {
            JOptionPane.showMessageDialog(null, "The list is empty. Nothing to delete.");
        }
    }

    public static void deleteAtPosition(int position) {
        if (position == 1 && head != null) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null && temp.next != null; i++) {
                temp = temp.next;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid position.");
            }
        }
    }

    public static void deleteLast() {
        if (head == null) {
            JOptionPane.showMessageDialog(null, "The list is empty. Nothing to delete.");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public static boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void reverse() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private static void updateOutput(JTextArea outputArea) {
        StringBuilder output = new StringBuilder("Singly Linked List Elements:\n");
        Node temp = head;
        while (temp != null) {
            output.append(temp.data).append(" ");
            temp = temp.next;
        }
        outputArea.setText(output.toString());
    }

    public static void main(String[] args) {
        display();
    }
}
