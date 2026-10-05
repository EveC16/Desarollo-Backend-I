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
import com.duoc.RopaStoreValidation.model.Pedido;
import com.duoc.RopaStoreValidation.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
    //Consultar todos los pedidos GET
    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoService.listar());
    }

    //Consultar pedidos por cliente GET
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> buscarPorCliente(@PathVariable Long clienteId){
        List<Pedido> pedidos = pedidoService.buscarPorCliente(clienteId);
        return ResponseEntity.ok(pedidos);
    }

    //Crear pedido POST
    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody Pedido pedido){
        Pedido pedidoCreado = pedidoService.crearPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCreado);
    }

    //Modificar pedido PUT
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> modificar(@PathVariable Long id, @RequestBody Pedido pedidoModificado) {
        return pedidoService.modificar(id, pedidoModificado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar pedido DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        boolean eliminado = pedidoService.eliminar(id);

        if(!eliminado){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
