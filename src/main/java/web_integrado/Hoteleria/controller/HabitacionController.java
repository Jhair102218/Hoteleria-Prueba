package web_integrado.Hoteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web_integrado.Hoteleria.service.HabitacionService;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/habitaciones")
    public String listar(Model model) {
        model.addAttribute("habitaciones", habitacionService.listarHabitaciones());
        return "habitaciones";
    }
}