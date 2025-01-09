// import javax.swing.*;

// public class HomePage {
//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Data Structures Visualization");
//         frame.setSize(400, 400);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

//         // Buttons for each data structure
//         JButton arrayButton = new JButton("Array");
//         JButton queueButton = new JButton("Queue");
//         JButton stackButton = new JButton("Stack");
//         JButton circularQueueButton = new JButton("Circular Queue");
//         JButton linkedListButton = new JButton("Linked List");
//         JButton doublyLinkedListButton = new JButton("Doubly Linked List");
//         JButton binaryTreeButton = new JButton("Binary Tree");
//         JButton hashMapButton = new JButton("HashMap");
//         JButton treeMapButton = new JButton("TreeMap");

//         // Button actions
//         arrayButton.addActionListener(e -> ArrayOperations.display());
//         queueButton.addActionListener(e -> QueueOperations.display());
//         stackButton.addActionListener(e -> StackOperations.display());
//         circularQueueButton.addActionListener(e -> CircularQueueOperations.display());
//         linkedListButton.addActionListener(e -> SinglyLinkedListOperations.display());
//         doublyLinkedListButton.addActionListener(e -> DoublyLinkedListOperations.display());
//         binaryTreeButton.addActionListener(e -> BinaryTree.display());
//         hashMapButton.addActionListener(e -> HashMapOperations.display());
//         treeMapButton.addActionListener(e -> TreeMapExample.display());

//         // Add buttons to the frame
//         frame.add(arrayButton);
//         frame.add(queueButton);
//         frame.add(stackButton);
//         frame.add(circularQueueButton);
//         frame.add(linkedListButton);
//         frame.add(doublyLinkedListButton);
//         frame.add(binaryTreeButton);
//         frame.add(hashMapButton);
//         frame.add(treeMapButton);

//         frame.setVisible(true);
//     }
// }


import java.awt.*;
import javax.swing.*;

public class HomePage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Data Structures Visualization");
        frame.setSize(500, 400);  // Adjusted size to accommodate buttons side by side
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));  // Adjusted flow layout with horizontal (10) and vertical (10) gaps

        JButton arrayButton = new JButton("Array");
        JButton queueButton = new JButton("Queue");
        JButton stackButton = new JButton("Stack");
        JButton circularQueueButton = new JButton("Circular Queue");
        JButton linkedListButton = new JButton("Linked List");
        JButton doublyLinkedListButton = new JButton("Doubly Linked List");
        JButton binaryTreeButton = new JButton("Binary Tree");
        JButton hashMapButton = new JButton("HashMap");
        JButton treeMapButton = new JButton("TreeMap");

        arrayButton.addActionListener(e -> ArrayOperations.display());
        queueButton.addActionListener(e -> QueueOperations.display());
        stackButton.addActionListener(e -> StackOperations.display());
        circularQueueButton.addActionListener(e -> CircularQueueOperations.display());
        linkedListButton.addActionListener(e -> SinglyLinkedListOperations.display());
        doublyLinkedListButton.addActionListener(e -> DoublyLinkedListOperations.display());
        binaryTreeButton.addActionListener(e -> BinaryTree.display());
        hashMapButton.addActionListener(e -> HashMapOperations.display());
        treeMapButton.addActionListener(e -> TreeMapExample.display());

        // Add buttons to the frame
        frame.add(arrayButton);
        frame.add(queueButton);
        frame.add(stackButton);
        frame.add(circularQueueButton);
        frame.add(linkedListButton);
        frame.add(doublyLinkedListButton);
        frame.add(binaryTreeButton);
        frame.add(hashMapButton);
        frame.add(treeMapButton);

        // Set the frame visible
        frame.setVisible(true);
    }
}
