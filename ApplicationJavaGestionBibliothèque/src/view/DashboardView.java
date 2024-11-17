package view;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {

    public DashboardView() {
        setTitle("Tableau de Bord - Bibliothèque");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("Tableau de Bord", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        JButton manageBooksButton = new JButton("Gérer les Livres");
        JButton manageUsersButton = new JButton("Gérer les Utilisateurs");
        JButton manageLoansButton = new JButton("Gérer les Emprunts");
        JButton logoutButton = new JButton("Déconnexion");

        buttonPanel.add(manageBooksButton);
        buttonPanel.add(manageUsersButton);
        buttonPanel.add(manageLoansButton);
        buttonPanel.add(logoutButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Action Listeners
        manageBooksButton.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new BookManagementView().setVisible(true));
        });

        manageUsersButton.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new UserManagementView().setVisible(true));
        });

        manageLoansButton.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new LoanManagementView().setVisible(true));
        });

        logoutButton.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardView().setVisible(true));
    }
}
