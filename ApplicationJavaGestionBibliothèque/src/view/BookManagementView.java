package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class BookManagementView extends JFrame {

    public BookManagementView() {
        setTitle("Gestion des Livres");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("Gestion des Livres", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Data Table
        String[] columnNames = {"ID", "Titre", "Auteur", "Genre"};
        Object[][] data = {
            {"1", "Les Misérables", "Victor Hugo", "Fiction"},
            {"2", "The Origin of Species", "Charles Darwin", "Science"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable bookTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addButton = new JButton("Ajouter");
        JButton editButton = new JButton("Modifier");
        JButton deleteButton = new JButton("Supprimer");
        JButton backButton = new JButton("Retour");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        backButton.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new DashboardView().setVisible(true));
        });

        // Add/Edit/Delete Button Actions here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookManagementView().setVisible(true));
    }
}
