package web_integrado.Hoteleria.restControllers;

import org.springframework.web.bind.annotation.*;
import web_integrado.Hoteleria.model.Cliente;
import web_integrado.Hoteleria.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    private final ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
        return clienteService.registrarCliente(cliente);
    }

    @GetMapping("/{dni}")
    public Cliente buscarPorDni(@PathVariable String dni) {
        return clienteService.buscarPorDni(dni).orElse(null);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
}