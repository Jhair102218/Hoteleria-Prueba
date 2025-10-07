package web_integrado.Hoteleria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web_integrado.Hoteleria.model.Habitacion;
import web_integrado.Hoteleria.model.Usuario;
import web_integrado.Hoteleria.repository.HabitacionRepository;
import web_integrado.Hoteleria.repository.UsuarioRepository;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN");
            admin.setNombre("Administrador");
            admin.setApellido("Sistema");
            admin.setEmail("admin@oasisdigital.com");
            usuarioRepository.save(admin);

            Usuario recepcionista = new Usuario();
            recepcionista.setUsername("recepcion");
            recepcionista.setPassword(passwordEncoder.encode("recep123"));
            recepcionista.setRole("ROLE_RECEPCIONISTA");
            recepcionista.setNombre("María");
            recepcionista.setApellido("López");
            recepcionista.setEmail("recepcion@oasisdigital.com");
            usuarioRepository.save(recepcionista);

            Usuario cliente = new Usuario();
            cliente.setUsername("cliente");
            cliente.setPassword(passwordEncoder.encode("cliente123"));
            cliente.setRole("ROLE_CLIENTE");
            cliente.setNombre("Juan");
            cliente.setApellido("Pérez");
            cliente.setEmail("cliente@example.com");
            usuarioRepository.save(cliente);

            System.out.println("✅ Usuarios creados correctamente");
        }

        if (habitacionRepository.count() == 0) {
            for (int i = 101; i <= 110; i++) {
                Habitacion hab = new Habitacion();
                hab.setNumero(String.valueOf(i));
                hab.setEstado("DISPONIBLE");
                hab.setPrecio(new BigDecimal(i <= 103 ? "250.00" : (i <= 106 ? "180.00" : "120.00")));
                habitacionRepository.save(hab);
            }
            System.out.println("✅ Habitaciones creadas correctamente");
        }
    }
}
