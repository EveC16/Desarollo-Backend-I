package com.duoc.RopaStoreValidation.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.duoc.RopaStoreValidation.model.Cliente;
import com.duoc.RopaStoreValidation.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Consultar todos los clientes GET
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    //Consultar cliente por Rut GET
    public Optional<Cliente> buscarPorRut(String rut) {
        return clienteRepository.findByRut(rut);
    }

    //Crear cliente POST
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Modificar cliente PUT
    public Optional<Cliente> modificar(String rut, Cliente clienteModificado){
    Optional<Cliente> encontrado = clienteRepository.findByRut(rut);
    if(encontrado.isEmpty()){
            return Optional.empty();
    }

    Cliente cliente = encontrado.get();
    cliente.setRut(clienteModificado.getRut());
    cliente.setNombre(clienteModificado.getNombre());
    cliente.setCorreo(clienteModificado.getCorreo());
    cliente.setTelefono(clienteModificado.getTelefono());
    cliente.setDireccion(clienteModificado.getDireccion());
    return Optional.of(clienteRepository.save(cliente));
    }

    //Eliminar cliente DELETE
    public boolean eliminar(Long id){
        if(!clienteRepository.existsById(id)){
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
}
