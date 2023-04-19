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
    @Column(name = "idCiudades")
    private Long idCiudades;



    @NotNull
    @Size(min = 5 , max = 30)
    @Column(name = "Nombre")
    private String Nombre;

    public Long getIdCiudades() {
        return idCiudades;
    }

    public void setIdCiudades(Long idCiudades) {
        this.idCiudades = idCiudades;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    @OneToOne (mappedBy = "idCiudad")
    private EmpresasEntity idEmpresa;
}
