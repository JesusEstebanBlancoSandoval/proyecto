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

    @NotNull
    @Size(min = 1,max= 13)
    @Column(name = "nit",unique = true)
    private String nit;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;




    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, optional = true)
    private CiudadEntity  idciudad;

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public CiudadEntity getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(CiudadEntity idciudad) {
        this.idciudad = idciudad;
    }
}
