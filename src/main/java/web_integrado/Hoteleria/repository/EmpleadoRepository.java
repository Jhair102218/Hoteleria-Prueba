package web_integrado.Hoteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web_integrado.Hoteleria.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {}