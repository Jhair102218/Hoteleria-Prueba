package web_integrado.Hoteleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_integrado.Hoteleria.model.Habitacion;
import web_integrado.Hoteleria.repository.HabitacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public Habitacion registrarHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public List<Habitacion> listarHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Optional<Habitacion> obtenerPorId(Long id) {
        return habitacionRepository.findById(id);
    }

    public List<Habitacion> listarPorEstado(String estado) {
        return habitacionRepository.findByEstado(estado);
    }

    public Habitacion actualizar(Long id, Habitacion habitacion) {
        habitacion.setId(id);
        return habitacionRepository.save(habitacion);
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }
}