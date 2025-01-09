import javax.swing.*;
import java.awt.*;

public class CircularQueueOperations {
    static int[] queue = new int[5];
    static int front = -1;
    static int rear = -1;
    static int size = 0;

    public static void display() {
        JFrame frame = new JFrame("Circular Queue Operations");
        frame.setSize(600, 500);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JButton enqueueButton = new JButton("Enqueue");
        JButton dequeueButton = new JButton("Dequeue");
        JButton peekButton = new JButton("Peek");
        JButton isEmptyButton = new JButton("Is Empty?");
        JButton isFullButton = new JButton("Is Full?");
        JButton sizeButton = new JButton("Size");
        JButton resetButton = new JButton("Reset");
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Enqueue operation
        enqueueButton.addActionListener(e -> {
            if (size == queue.length) {
                JOptionPane.showMessageDialog(frame, "Queue is full");
            } else {
                if (front == -1) front = 0;
                rear = (rear + 1) % queue.length;
                queue[rear] = Integer.parseInt(inputField.getText());
                size++;
                inputField.setText("");
                updateOutput(outputArea);
            }
        });

        // Dequeue operation
        dequeueButton.addActionListener(e -> {
            if (size == 0) {
                JOptionPane.showMessageDialog(frame, "Queue is empty");
            } else {
                JOptionPane.showMessageDialog(frame, "Dequeued: " + queue[front]);
                front = (front + 1) % queue.length;
                size--;
                updateOutput(outputArea);
            }
        });

        // Peek operation
        peekButton.addActionListener(e -> {
            if (size > 0) {
                JOptionPane.showMessageDialog(frame, "Front element: " + queue[front]);
            } else {
                JOptionPane.showMessageDialog(frame, "Queue is empty");
            }
        });

        // Check if the queue is empty
        isEmptyButton.addActionListener(e -> {
            if (size == 0) {
                JOptionPane.showMessageDialog(frame, "Queue is empty");
            } else {
                JOptionPane.showMessageDialog(frame, "Queue is not empty");
            }
        });

        // Check if the queue is full
        isFullButton.addActionListener(e -> {
            if (size == queue.length) {
                JOptionPane.showMessageDialog(frame, "Queue is full");
            } else {
                JOptionPane.showMessageDialog(frame, "Queue is not full");
            }
        });

        // Display the size of the queue
        sizeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Current size of the queue: " + size);
        });

        // Reset the queue
        resetButton.addActionListener(e -> {
            front = -1;
            rear = -1;
            size = 0;
            updateOutput(outputArea);
            JOptionPane.showMessageDialog(frame, "Queue has been reset");
        });

        frame.add(new JLabel("Enter Number:"));
        frame.add(inputField);
        frame.add(enqueueButton);
        frame.add(dequeueButton);
        frame.add(peekButton);
        frame.add(isEmptyButton);
        frame.add(isFullButton);
        frame.add(sizeButton);
        frame.add(resetButton);
        frame.add(new JScrollPane(outputArea));
        frame.setVisible(true);
    }

    private static void updateOutput(JTextArea outputArea) {
        StringBuilder output = new StringBuilder("Circular Queue Elements:\n");
        for (int i = 0; i < size; i++) {
            output.append(queue[(front + i) % queue.length]).append(" ");
        }
        outputArea.setText(output.toString());
    }
}
