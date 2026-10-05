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
import com.duoc.RopaStoreValidation.model.Producto;
import com.duoc.RopaStoreValidation.services.ProductoService;

@RestController
@RequestMapping
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //Consultar todos los productos GET
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    //Consultar producto por Id GET
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable long id){
        return productoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElseGet(()-> ResponseEntity.notFound().build());
    }

    //Crear producto POST
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        Producto productoCreado = productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    //Modificar producto PUT
    @PutMapping("/{id}")
    public ResponseEntity<Producto> modificar(@PathVariable Long id, @RequestBody Producto productoModificado) {
        return productoService.modificar(id, productoModificado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar prroducto DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        boolean eliminado = productoService.eliminar(id);

        if(!eliminado){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
