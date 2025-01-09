import java.awt.*;
import javax.swing.*;

public class StackOperations {
    static int[] stack = new int[10];
    static int top = -1;

    public static void display() {
        JFrame frame = new JFrame("Stack Operations");
        frame.setSize(600, 500);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JButton pushButton = new JButton("Push");
        JButton popButton = new JButton("Pop");
        JButton peekButton = new JButton("Peek");
        JButton isEmptyButton = new JButton("Is Empty?");
        JButton isFullButton = new JButton("Is Full?");
        JButton sizeButton = new JButton("Size");
        JButton resetButton = new JButton("Reset");
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        pushButton.addActionListener(e -> {
            if (top < stack.length - 1) {
                stack[++top] = Integer.parseInt(inputField.getText());
                inputField.setText("");
                updateOutput(outputArea);
            } else {
                JOptionPane.showMessageDialog(frame, "Stack is full");
            }
        });

        popButton.addActionListener(e -> {
            if (top >= 0) {
                JOptionPane.showMessageDialog(frame, "Popped: " + stack[top--]);
                updateOutput(outputArea);
            } else {
                JOptionPane.showMessageDialog(frame, "Stack is empty");
            }
        });

        peekButton.addActionListener(e -> {
            if (top >= 0) {
                JOptionPane.showMessageDialog(frame, "Top element: " + stack[top]);
            } else {
                JOptionPane.showMessageDialog(frame, "Stack is empty");
            }
        });

        isEmptyButton.addActionListener(e -> {
            if (top == -1) {
                JOptionPane.showMessageDialog(frame, "Stack is empty");
            } else {
                JOptionPane.showMessageDialog(frame, "Stack is not empty");
            }
        });

        isFullButton.addActionListener(e -> {
            if (top == stack.length - 1) {
                JOptionPane.showMessageDialog(frame, "Stack is full");
            } else {
                JOptionPane.showMessageDialog(frame, "Stack is not full");
            }
        });

        sizeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Current size of the stack: " + (top + 1));
        });

        resetButton.addActionListener(e -> {
            top = -1;
            updateOutput(outputArea);
            JOptionPane.showMessageDialog(frame, "Stack has been reset");
        });

        frame.add(new JLabel("Enter Number:"));
        frame.add(inputField);
        frame.add(pushButton);
        frame.add(popButton);
        frame.add(peekButton);
        frame.add(isEmptyButton);
        frame.add(isFullButton);
        frame.add(sizeButton);
        frame.add(resetButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    private static void updateOutput(JTextArea outputArea) {
        StringBuilder output = new StringBuilder("Stack Elements:\n");
        for (int i = 0; i <= top; i++) {
            output.append(stack[i]).append(" ");
        }
        outputArea.setText(output.toString());
    }
}
