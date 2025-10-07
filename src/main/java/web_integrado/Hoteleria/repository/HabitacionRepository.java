package web_integrado.Hoteleria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import web_integrado.Hoteleria.model.Habitacion;
import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByEstado(String estado);
}