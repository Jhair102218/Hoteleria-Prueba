package web_integrado.Hoteleria.service;

import org.springframework.stereotype.Service;
import web_integrado.Hoteleria.model.Cliente;
import web_integrado.Hoteleria.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}