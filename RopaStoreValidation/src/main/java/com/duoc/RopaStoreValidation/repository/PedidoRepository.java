package com.duoc.RopaStoreValidation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.duoc.RopaStoreValidation.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    //METODO PARA LISTAR LOS PEDIDOS POR CLIENTE
    List<Pedido> findByClienteId(Long clienteId);
}
