package com.duoc.RopaStoreValidation.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.duoc.RopaStoreValidation.model.Producto;
import com.duoc.RopaStoreValidation.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Consultar todos los productos GET
    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    //Consultar producto por ID GET
    public Optional<Producto> buscarPorId(Long id){
        return productoRepository.findById(id);
    }

    //Crear producto POST
    public Producto crearProducto(Producto vehiculo){
        return productoRepository.save(vehiculo);
    }

    //Modificar producto PUT
    public Optional<Producto> modificar(Long id, Producto productoModificado){
        Optional<Producto> encontrado = productoRepository.findById(id);
        if(encontrado.isEmpty()){
            return Optional.empty();
        }

        Producto producto = encontrado.get();
        producto.setId(productoModificado.getId());
        producto.setNombre(productoModificado.getNombre());
        producto.setPrecio(productoModificado.getPrecio());
        producto.setCategoria(productoModificado.getCategoria());
        producto.setStock(productoModificado.getStock());
        producto.setSucursalId(productoModificado.getSucursalId());

        return Optional.of(productoRepository.save(producto));
    }

    //Eliminar producto DELETE
    public boolean eliminar(Long id){
        if(!productoRepository.existsById(id)){
            return false; 
        }
        productoRepository.deleteById(id);
        return true;
    }
}
