package com.duoc.RopaStoreValidation.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.duoc.RopaStoreValidation.model.Pedido;
import com.duoc.RopaStoreValidation.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
    }

    //Consultar todos los pedidos GET
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    //Consultar pedidos por cliente GET
    public List<Pedido> buscarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    //Crear pedido POST
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    //Modificar pedido PUT
    public Optional<Pedido> modificar(Long id, Pedido pedidoModificado){
    Optional<Pedido> encontrado = pedidoRepository.findById(id);
    if(encontrado.isEmpty()){
            return Optional.empty();
    }

    Pedido pedido = encontrado.get();
    pedido.setId(pedidoModificado.getId());
    pedido.setClienteId(pedidoModificado.getClienteId());
    pedido.setFechaPedido(pedidoModificado.getFechaPedido());
    pedido.setTotal(pedidoModificado.getTotal());
    pedido.setEstado(pedidoModificado.getEstado());

    return Optional.of(pedidoRepository.save(pedido));
    }

    //Eliminar pedido DELETE
    public boolean eliminar(Long id){
        if(!pedidoRepository.existsById(id)){
            return false;
        }
        pedidoRepository.deleteById(id);
        return true;
    }
}
