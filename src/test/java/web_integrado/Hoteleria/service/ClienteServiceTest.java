package web_integrado.Hoteleria.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import web_integrado.Hoteleria.model.Cliente;
import web_integrado.Hoteleria.repository.ClienteRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        clienteRepository = Mockito.mock(ClienteRepository.class);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    void testRegistrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni("87654321");
        cliente.setNombre("Maria");
        cliente.setApellido("Lopez");
        cliente.setNacionalidad("Peruana");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente guardado = clienteService.registrarCliente(cliente);

        assertThat(guardado).isNotNull();
        assertThat(guardado.getNombre()).isEqualTo("Maria");
    }

    @Test
    void testBuscarPorDni() {
        Cliente cliente = new Cliente();
        cliente.setDni("11223344");
        cliente.setNombre("Carlos");

        when(clienteRepository.findByDni("11223344")).thenReturn(Optional.of(cliente));

        Optional<Cliente> encontrado = clienteService.buscarPorDni("11223344");

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getNombre()).isEqualTo("Carlos");
    }
}