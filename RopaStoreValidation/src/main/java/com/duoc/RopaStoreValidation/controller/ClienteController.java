package com.duoc.RopaStoreValidation.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.RopaStoreValidation.model.Cliente;
import com.duoc.RopaStoreValidation.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    //Consultar todos los clientes GET
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    //Consultar cliente por Rut GET
    @GetMapping("/rut/{rut}")
    public ResponseEntity<Cliente> buscarPorRut(@PathVariable String rut){
        return clienteService.buscarPorRut(rut)
            .map(ResponseEntity::ok)
            .orElseGet(()-> ResponseEntity.notFound().build());
    }

    //Crear cliente POST
    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }

    //Modificar cliente PUT
    @PutMapping("/rut/{rut}")
    public ResponseEntity<Cliente> modificar(@PathVariable String rut, @RequestBody Cliente clienteModificado) {
        return clienteService.modificar(rut, clienteModificado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar cliente DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        boolean eliminado = clienteService.eliminar(id);

        if(!eliminado){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
