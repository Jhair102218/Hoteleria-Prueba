package web_integrado.Hoteleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_integrado.Hoteleria.model.Empleado;
import web_integrado.Hoteleria.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado registrarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> obtenerPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado actualizar(Long id, Empleado empleado) {
        empleado.setId(id);
        return empleadoRepository.save(empleado);
    }

    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }
}