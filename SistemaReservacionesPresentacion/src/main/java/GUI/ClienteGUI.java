/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ClienteGUI extends JFrame {

    public ClienteGUI() {
        setTitle("Gestión de Clientes");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // --- Panel Superior ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        topPanel.add(new JLabel("ID:"));
        topPanel.add(new JTextField(5));
        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(new JTextField(30));
        
        // Botón agregado para acceder a las reservaciones desde el cliente
        JButton btnIrReservaciones = new JButton("Ir a Reservaciones");
        btnIrReservaciones.addActionListener(e -> new ReservacionGUI().setVisible(true));
        topPanel.add(btnIrReservaciones);
        
        add(topPanel, BorderLayout.NORTH);

        // --- Panel Izquierdo (Formulario) ---
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(350, 0));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addFormRow(formPanel, gbc, 0, "ID:", new JTextField());
        addFormRow(formPanel, gbc, 1, "Nombre:", new JTextField());
        addFormRow(formPanel, gbc, 2, "Email:", new JTextField());
        addFormRow(formPanel, gbc, 3, "Teléfono:", new JTextField());
        addFormRow(formPanel, gbc, 4, "Tipo:", new JComboBox<>(new String[]{"Normal", "Premium"}));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnPanel.add(new JButton("Guardar"));
        btnPanel.add(new JButton("Cancelar"));

        leftPanel.add(formPanel, BorderLayout.NORTH);
        leftPanel.add(btnPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        // --- Panel Central (Tabla) ---
        String[] columnas = {"ID", "Nombre", "Email", "Teléfono", "Tipo"};
        Object[][] datos = {
            {"1", "Juan Perez", "juan@gmail.com", "6441234567", "Premium"},
            {"2", "Ana Lopez", "ana@hotmail.com", "6449876543", "Normal"}
        };
        JTable table = new JTable(new DefaultTableModel(datos, columnas));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // --- Panel Derecho (Botones Editar/Borrar) ---
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        JButton btnEditar = new JButton("Editar");
        JButton btnBorrar = new JButton("Borrar");
        btnEditar.setMaximumSize(new Dimension(100, 35));
        btnBorrar.setMaximumSize(new Dimension(100, 35));

        rightPanel.add(btnEditar);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(btnBorrar);
        
        add(rightPanel, BorderLayout.EAST);
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, Component field) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        panel.add(new JLabel(labelText), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panel.add(field, gbc);
    }
}