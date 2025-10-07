package web_integrado.Hoteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web_integrado.Hoteleria.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
