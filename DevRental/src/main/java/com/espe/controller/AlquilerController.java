package com.espe.controller;

import com.espe.model.Vehiculo;
import com.espe.service.VehiculoService;
import com.espe.view.FrameRegistro; // Necesario para leer la vista

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlquilerController implements ActionListener {

    private final VehiculoService service;
    private final FrameRegistro view;
    public AlquilerController(VehiculoService service, FrameRegistro view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String placa = view.getTxtPlaca().getText();
            String marca = view.getTxtMarca().getText();
            // Nuevos campos del UML
            int modelo = Integer.parseInt(view.getTxtModelo().getText());
            double precioDia = Double.parseDouble(view.getTxtPrecio().getText());

            Vehiculo v = new Vehiculo(placa, marca, modelo, precioDia);

            service.registrarVehiculo(v);

            JOptionPane.showMessageDialog(view, "Éxito: Vehículo guardado.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Error: Precio o Modelo inválido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
}
