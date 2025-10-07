package web_integrado.Hoteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web_integrado.Hoteleria.service.EmpleadoService;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleados")
    public String listar(Model model) {
        model.addAttribute("empleados", empleadoService.listarEmpleados());
        return "empleados";
    }
}