package web_integrado.Hoteleria.service;

import org.springframework.stereotype.Service;
import web_integrado.Hoteleria.model.Habitacion;
import web_integrado.Hoteleria.repository.HabitacionRepository;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public Habitacion registrarHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public List<Habitacion> listarHabitaciones() {
        return habitacionRepository.findAll();
    }

    public List<Habitacion> listarPorEstado(String estado) {
        return habitacionRepository.findByEstado(estado);
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }
}