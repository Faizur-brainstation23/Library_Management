import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryGUI extends JFrame {
    private JTextField titleField, authorField, nameField, emailField;
    private JTextArea displayArea;

    public LibraryGUI() {
        setTitle("Library Management System");
        setLayout(new BorderLayout());

        // Create components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        JLabel titleLabel = new JLabel("Book Title:");
        titleField = new JTextField();

        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField();

        JLabel nameLabel = new JLabel("Member Name:");
        nameField = new JTextField();

        JLabel emailLabel = new JLabel("Member Email:");
        emailField = new JTextField();

        JButton addBookButton = new JButton("Add Book");
        JButton addMemberButton = new JButton("Add Member");
        JButton checkoutButton = new JButton("Checkout Book");
        JButton returnButton = new JButton("Return Book");

        // Display area
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add components to input panel
        inputPanel.add(titleLabel);
        inputPanel.add(titleField);
        inputPanel.add(authorLabel);
        inputPanel.add(authorField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(addBookButton);
        inputPanel.add(addMemberButton);

        // Add action listeners
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                LibraryManagement.addBook(title, author);
                displayArea.append("Book added: " + title + " by " + author + "\n");
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                LibraryManagement.addMember(name, email);
                displayArea.append("Member added: " + name + "\n");
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                LibraryManagement.checkoutBook(title);
                displayArea.append("Checked out: " + title + "\n");
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                LibraryManagement.returnBook(title);
                displayArea.append("Returned: " + title + "\n");
            }
        });

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(checkoutButton, BorderLayout.WEST);
        add(returnButton, BorderLayout.EAST);

        // Set window properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryGUI().setVisible(true);
            }
        });
    }
}