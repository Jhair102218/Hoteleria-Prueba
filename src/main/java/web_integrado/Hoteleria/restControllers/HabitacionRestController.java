package web_integrado.Hoteleria.restControllers;

import org.springframework.web.bind.annotation.*;
import web_integrado.Hoteleria.model.Habitacion;
import web_integrado.Hoteleria.service.HabitacionService;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionRestController {

    private final HabitacionService habitacionService;

    public HabitacionRestController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PostMapping
    public Habitacion registrarHabitacion(@RequestBody Habitacion habitacion) {
        return habitacionService.registrarHabitacion(habitacion);
    }

    @GetMapping
    public List<Habitacion> listarHabitaciones() {
        return habitacionService.listarHabitaciones();
    }

    @GetMapping("/estado/{estado}")
    public List<Habitacion> listarPorEstado(@PathVariable String estado) {
        return habitacionService.listarPorEstado(estado);
    }

    @PutMapping("/{id}")
    public Habitacion actualizarHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        habitacion.setId(id);
        return habitacionService.registrarHabitacion(habitacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
    }
}