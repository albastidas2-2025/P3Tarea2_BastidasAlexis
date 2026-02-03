package com.espe.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener; // <--- ESTE IMPORT ES VITAL

public class FrameRegistro extends JFrame {
    // Componentes
    private JTextField txtPlaca = new JTextField(10);
    private JTextField txtMarca = new JTextField(10);
    private JTextField txtModelo = new JTextField(10);
    private JTextField txtPrecio = new JTextField(10);
    private JButton btnRegistrar = new JButton("Registrar");

    public FrameRegistro() {
        super("Registro de Vehículos");
        setLayout(new FlowLayout());

        // Diseño visual
        add(new JLabel("Placa:")); add(txtPlaca);
        add(new JLabel("Marca:")); add(txtMarca);
        add(new JLabel("Modelo:")); add(txtModelo);
        add(new JLabel("Precio/Día:")); add(txtPrecio);
        add(btnRegistrar);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // --- AQUÍ ESTÁ EL MÉTODO QUE TE DABA ERROR ---
    public void setBtnRegistrarListener(ActionListener listener) {
        this.btnRegistrar.addActionListener(listener);
    }

    // Getters para que el controlador lea los datos
    public JTextField getTxtPlaca() { return txtPlaca; }
    public JTextField getTxtMarca() { return txtMarca; }
    public JTextField getTxtModelo() { return txtModelo; }
    public JTextField getTxtPrecio() { return txtPrecio; }
}