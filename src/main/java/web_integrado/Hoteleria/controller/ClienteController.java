package web_integrado.Hoteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web_integrado.Hoteleria.model.Cliente;
import web_integrado.Hoteleria.service.ClienteService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "clientes";
    }

    @GetMapping("/clientes/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro-cliente";
    }

    @PostMapping("/clientes/registro")
    public String registrarCliente(Cliente cliente) {
        clienteService.registrarCliente(cliente);
        return "redirect:/clientes";
    }
}