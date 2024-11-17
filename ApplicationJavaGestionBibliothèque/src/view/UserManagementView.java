package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class UserManagementView extends JFrame {

    public UserManagementView() {
        setTitle("Gestion des Utilisateurs");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("Gestion des Utilisateurs", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Data Table
        String[] columnNames = {"ID", "Nom", "Rôle", "Email"};
        Object[][] data = {
            {"1", "John Doe", "Membre", "john.doe@example.com"},
            {"2", "Jane Smith", "Bibliothécaire", "jane.smith@example.com"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable userTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(userTable);
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
        SwingUtilities.invokeLater(() -> new UserManagementView().setVisible(true));
    }
}
