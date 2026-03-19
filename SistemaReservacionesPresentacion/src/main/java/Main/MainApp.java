/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import GUI.ClienteGUI;
import GUI.RestauranteGUI;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author USER
 */
public class MainApp extends JFrame {

    public MainApp() {
        setTitle("Sistema de Gestión - Menú Principal");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        // --- Encabezado Azul ---
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(33, 47, 148)); // Azul oscuro tipo la imagen
        headerPanel.setPreferredSize(new Dimension(800, 60));
        headerPanel.setLayout(new GridBagLayout());

        JLabel lblTitulo = new JLabel("Sistema de Gestión de Restaurantes");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        headerPanel.add(lblTitulo);
        add(headerPanel, BorderLayout.NORTH);

        // --- Panel Central (Botones en cuadrícula 2x2) ---
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 30, 30));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        centerPanel.setBackground(new Color(240, 240, 240));

        // Agregamos solo los 3 botones solicitados
        centerPanel.add(createMenuButton("Módulo Clientes", e -> new ClienteGUI().setVisible(true)));
        centerPanel.add(createMenuButton("Módulo Restaurantes", e -> new RestauranteGUI().setVisible(true)));
        centerPanel.add(createMenuButton("Insertar datos", e -> JOptionPane.showMessageDialog(this, "Módulo en construcción")));

        // Agregamos un componente vacío en la 4ta posición para mantener la cuadrícula y el tamaño de los botones
        JLabel espacioVacio = new JLabel();
        centerPanel.add(espacioVacio);

        add(centerPanel, BorderLayout.CENTER);

        // --- Footer ---
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(240, 240, 240));
        JLabel lblFooter = new JLabel("Mario Alejandro Preciado Guerrero 252940");
        lblFooter.setFont(new Font("Arial", Font.PLAIN, 12));
        footerPanel.add(lblFooter);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JButton createMenuButton(String text, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        // Borde azul claro imitando el botón de la imagen
        button.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1));
        button.addActionListener(action);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
