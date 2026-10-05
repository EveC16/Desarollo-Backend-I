package com.duoc.RopaStoreValidation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(nullable = false)
    private int precio;

    @Column(nullable = false, length = 25)
    @NotBlank(message = "La categoria es obligatoria")
    private String categoria;

    @Column(nullable = false)
    private int stock;

    @Column(name = "SUCURSAL_ID", nullable = false)
    private Long sucursalId;

    public Producto() {
    }

    public Producto(Long id, String nombre, int precio, String categoria, int stock, Long sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.sucursalId = sucursalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }
    
}
