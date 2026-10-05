package com.duoc.RopaStoreValidation.model;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @Column(name = "FECHA_PEDIDO", nullable = false)
    private Date fechaPedido;

    @Column(nullable = false)
    private int total;

    @Column(nullable = false, length = 15)
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    public Pedido () {

    }

    public Pedido (Long id, Long clienteId, Date fechaPedido, int total, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
