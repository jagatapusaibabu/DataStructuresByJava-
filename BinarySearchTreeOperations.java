import java.awt.*;
import javax.swing.*;

public class BinarySearchTreeOperations {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Node root = null;

    public static void display() {
        JFrame frame = new JFrame("Binary Search Tree Operations");
        frame.setSize(600, 500);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JButton addButton = new JButton("Add Node");
        JButton deleteButton = new JButton("Delete Node");
        JButton searchButton = new JButton("Search Node");
        JButton inorderButton = new JButton("Inorder Traversal");
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Add node
        addButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            addNode(value);
            inputField.setText("");
            updateOutput(outputArea);
        });

        // Delete node
        deleteButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            deleteNode(value);
            inputField.setText("");
            updateOutput(outputArea);
        });

        // Search node
        searchButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            boolean found = search(value);
            if (found) {
                JOptionPane.showMessageDialog(frame, "Node found");
            } else {
                JOptionPane.showMessageDialog(frame, "Node not found");
            }
        });

        // Inorder traversal
        inorderButton.addActionListener(e -> {
            String result = inorderTraversal(root);
            outputArea.setText(result);
        });

        frame.add(new JLabel("Enter Node Value:"));
        frame.add(inputField);
        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(searchButton);
        frame.add(inorderButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
    }

    private static Node addNodeRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.data) {
            node.right = addNodeRecursive(node.right, value);
        }
        return node;
    }

    public static void deleteNode(int value) {
        root = deleteNodeRecursive(root, value);
    }

    private static Node deleteNodeRecursive(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.data) {
            root.left = deleteNodeRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNodeRecursive(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = findMin(root.right);
            root.right = deleteNodeRecursive(root.right, root.data);
        }
        return root;
    }

    private static int findMin(Node root) {
        return root.left == null ? root.data : findMin(root.left);
    }

    public static boolean search(int value) {
        return searchRecursive(root, value);
    }

    private static boolean searchRecursive(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return searchRecursive(root.left, value);
        } else {
            return searchRecursive(root.right, value);
        }
    }

    private static String inorderTraversal(Node root) {
        StringBuilder result = new StringBuilder();
        inorderRecursive(root, result);
        return result.toString();
    }
    
    private static void inorderRecursive(Node root, StringBuilder result) {
        if (root != null) {
            inorderRecursive(root.left, result);
            result.append(root.data).append(" ");
            inorderRecursive(root.right, result);
        }
    }
    
    private static void updateOutput(JTextArea outputArea) {
        StringBuilder output = new StringBuilder("Binary Search Tree (Inorder Traversal):\n");
        output.append(inorderTraversal(root));  // This now returns a String, and can be appended
        outputArea.setText(output.toString());  // Converts StringBuilder to String before setting
    }
    
}
