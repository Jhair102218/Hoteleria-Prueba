package web_integrado.Hoteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web_integrado.Hoteleria.service.ClienteService;
import web_integrado.Hoteleria.service.HabitacionService;

@Controller
public class DashboardController {

    @Autowired
    private HabitacionService habitacionService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        String username = authentication.getName();
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("USER");

        long totalHabitaciones = habitacionService.listarHabitaciones().size();
        long totalClientes = clienteService.listarClientes().size();
        long disponibles = habitacionService.listarPorEstado("DISPONIBLE").size();
        long ocupadas = habitacionService.listarPorEstado("OCUPADA").size();
        long mantenimiento = habitacionService.listarPorEstado("MANTENIMIENTO").size();

        model.addAttribute("username", username);
        model.addAttribute("role", role);
        model.addAttribute("totalHabitaciones", totalHabitaciones);
        model.addAttribute("totalClientes", totalClientes);
        model.addAttribute("disponible", disponibles);
        model.addAttribute("ocupada", ocupadas);
        model.addAttribute("mantenimiento", mantenimiento);

        return "dashboard";
    }
}