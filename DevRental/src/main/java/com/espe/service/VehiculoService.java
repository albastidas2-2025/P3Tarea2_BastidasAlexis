package com.espe.service;

import com.espe.model.Vehiculo;
import com.espe.repository.IVehiculoRepository;

public class VehiculoService {
    private final IVehiculoRepository repository;

    public VehiculoService(IVehiculoRepository repository) {
        this.repository = repository;
    }

    public void registrarVehiculo(Vehiculo v) throws Exception {
        if (v.getPlaca() == null || v.getPlaca().isEmpty()) {
            throw new Exception("Error: La placa es obligatoria.");
        }
        repository.guardar(v);
    }
}
