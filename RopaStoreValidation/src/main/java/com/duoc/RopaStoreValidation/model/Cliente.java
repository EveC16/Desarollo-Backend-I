package com.duoc.RopaStoreValidation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    @NotBlank(message = "El rut es obligatorio")
    private String rut; 

    @Column(nullable = false, length = 15)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre; 

    @Column(nullable = false, length = 80)
    @NotBlank(message = "El correo es obligatorio")
    private String correo; 

    @Column(nullable = false)
    private int telefono; 

    @Column(nullable = false, length = 80)
    @NotBlank(message = "La direccion es obligatoria")
    private String direccion; 

    public Cliente (){

    }

    public Cliente(Long id, String rut, String nombre, String correo, int telefono, String direccion){
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
