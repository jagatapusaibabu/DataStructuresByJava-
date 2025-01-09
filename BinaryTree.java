import java.awt.*;
import javax.swing.*;

public class BinaryTree {
    static Node root = null;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void display() {
        JFrame frame = new JFrame("Binary Tree Operations");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JButton addButton = new JButton("Add Node");
        JButton inorderButton = new JButton("Inorder Traversal");
        JButton preorderButton = new JButton("Preorder Traversal");
        JButton postorderButton = new JButton("Postorder Traversal");
        JButton searchButton = new JButton("Search Node");
        JButton deleteButton = new JButton("Delete Node");
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        addButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            addNode(value);
            inputField.setText("");
        });

        inorderButton.addActionListener(e -> {
            String result = inorderTraversal(root);
            outputArea.setText("Inorder: " + result);
        });

        preorderButton.addActionListener(e -> {
            String result = preorderTraversal(root);
            outputArea.setText("Preorder: " + result);
        });

        postorderButton.addActionListener(e -> {
            String result = postorderTraversal(root);
            outputArea.setText("Postorder: " + result);
        });

        searchButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            boolean found = searchNode(root, value);
            outputArea.setText(found ? "Node found" : "Node not found");
        });

        deleteButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            root = deleteNode(root, value);
            inputField.setText("");
            outputArea.setText("Node deleted if it existed.");
        });

        frame.add(new JLabel("Enter Number:"));
        frame.add(inputField);
        frame.add(addButton);
        frame.add(inorderButton);
        frame.add(preorderButton);
        frame.add(postorderButton);
        frame.add(searchButton);
        frame.add(deleteButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    public static void addNode(int value) {
        root = addRecursively(root, value);
    }

    private static Node addRecursively(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = addRecursively(node.left, value);
        } else if (value > node.data) {
            node.right = addRecursively(node.right, value);
        }
        return node;
    }

    private static String inorderTraversal(Node node) {
        if (node == null) return "";
        return inorderTraversal(node.left) + " " + node.data + " " + inorderTraversal(node.right);
    }

    private static String preorderTraversal(Node node) {
        if (node == null) return "";
        return node.data + " " + preorderTraversal(node.left) + " " + preorderTraversal(node.right);
    }

    private static String postorderTraversal(Node node) {
        if (node == null) return "";
        return postorderTraversal(node.left) + " " + postorderTraversal(node.right) + " " + node.data;
    }

    private static boolean searchNode(Node node, int value) {
        if (node == null) return false;
        if (node.data == value) return true;
        return value < node.data ? searchNode(node.left, value) : searchNode(node.right, value);
    }

    private static Node deleteNode(Node root, int key) {
        if (root == null) return root;

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    private static int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}
