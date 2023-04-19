package com.usta.proyecto.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table

public class EmpresasEntity implements Serializable {
    private static final long serialVersionUID=1L;


@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "idEmpresa")
private Long idEmpresa;


@NotNull
@Size(min = 10, max = 30)
@Column(name = "Nombre")
private String Nombre;

@JoinColumn(name = "idCiudad")
@OneToOne(cascade = CascadeType.REMOVE,optional = true)
private PersonasEntity idCiudad;

    @OneToOne (mappedBy = "idEmpresa")
    private PersonasEntity idPersona;

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
