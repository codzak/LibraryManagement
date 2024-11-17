package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class LoanManagementView extends JFrame {

    public LoanManagementView() {
        setTitle("Gestion des Emprunts");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("Gestion des Emprunts", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Data Table
        String[] columnNames = {"ID", "Livre", "Utilisateur", "Date Emprunt", "Date Retour", "Prolonger"};
        Object[][] data = {
            {"1", "Les Misérables", "John Doe", "01/01/2024", "15/01/2024", "Non"},
            {"2", "The Origin of Species", "Jane Smith", "05/01/2024", "19/01/2024", "Oui"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable loanTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(loanTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton extendButton = new JButton("Prolonger");
        JButton backButton = new JButton("Retour");
        buttonPanel.add(extendButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        backButton.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new DashboardView().setVisible(true));
        });

        // Extend Loan Button Action here
        extendButton.addActionListener(e -> {
            int selectedRow = loanTable.getSelectedRow();
            if (selectedRow != -1) {
                String loanID = (String) loanTable.getValueAt(selectedRow, 0);
                JOptionPane.showMessageDialog(this, "Le prêt " + loanID + " a été prolongé!");
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un emprunt à prolonger.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoanManagementView().setVisible(true));
    }
}
