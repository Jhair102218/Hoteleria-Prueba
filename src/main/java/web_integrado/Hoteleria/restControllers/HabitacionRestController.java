package web_integrado.Hoteleria.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_integrado.Hoteleria.model.Habitacion;
import web_integrado.Hoteleria.service.HabitacionService;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@CrossOrigin(origins = "*")
public class HabitacionRestController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public ResponseEntity<List<Habitacion>> listarTodas() {
        return ResponseEntity.ok(habitacionService.listarHabitaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerPorId(@PathVariable Long id) {
        return habitacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Habitacion>> listarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(habitacionService.listarPorEstado(estado));
    }

    @PostMapping
    public ResponseEntity<Habitacion> crear(@RequestBody Habitacion habitacion) {
        return ResponseEntity.ok(habitacionService.registrarHabitacion(habitacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizar(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        return habitacionService.obtenerPorId(id)
                .map(h -> ResponseEntity.ok(habitacionService.actualizar(id, habitacion)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (habitacionService.obtenerPorId(id).isPresent()) {
            habitacionService.eliminarHabitacion(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}