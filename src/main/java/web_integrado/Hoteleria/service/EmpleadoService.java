package web_integrado.Hoteleria.service;

import org.springframework.stereotype.Service;
import web_integrado.Hoteleria.model.Empleado;
import web_integrado.Hoteleria.repository.EmpleadoRepository;

import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado registrarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }
}