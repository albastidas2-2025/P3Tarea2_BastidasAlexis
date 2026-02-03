package com.espe;

import com.espe.controller.AlquilerController;
import com.espe.persistence.MongoVehiculoRepository;
import com.espe.repository.IVehiculoRepository;
import com.espe.service.VehiculoService;
import com.espe.view.FrameRegistro;

public class Main {
    public static void main(String[] args) {
        // 1. Crear la capa de Persistencia (Repositorio)
        IVehiculoRepository repository = new MongoVehiculoRepository();

        // 2. Crear la capa de Servicio (Inyectamos el Repositorio)
        VehiculoService service = new VehiculoService(repository);

        // 3. Crear la Vista (Inicialmente sin funcionalidad)
        FrameRegistro view = new FrameRegistro();

        // 4. Crear el Controlador (Inyectamos Servicio y Vista)
        // El controlador conecta la lógica con la pantalla
        AlquilerController controller = new AlquilerController(service, view);

        // 5. ASIGNAR EL CONTROLADOR A LA VISTA
        // Le decimos a la vista: "Cuando toquen el botón, avísale a este controlador"
        view.setBtnRegistrarListener(controller);
    }
}