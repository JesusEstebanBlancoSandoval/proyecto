package com.usta.proyecto.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Ciudades")
public class CiudadEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudades")
    private Long id_ciudades;

    @NotNull
    @Size(min = 5 , max = 30)
    @Column(name = "Nombre")
    private String Nombre;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;



    public Long getIdCiudades() {
        return id_ciudades;
    }

    public void setIdCiudades(Long idCiudades) {
        this.id_ciudades = id_ciudades;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}