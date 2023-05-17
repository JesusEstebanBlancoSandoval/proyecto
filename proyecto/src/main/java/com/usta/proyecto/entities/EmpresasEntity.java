package com.usta.proyecto.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name ="empresas")

public class EmpresasEntity implements Serializable {
    private static final long serialVersionUID=1L;


@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "id_empresa")
private Long id_empresa;


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

    @NotNull
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudades")
    @ManyToOne(fetch = FetchType.LAZY)
    private CiudadEntity id_ciudad;

    public Long getIdEmpresa() {
        return id_empresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.id_empresa = id_empresa;
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
        return id_ciudad;
    }

    public void setIdciudad(CiudadEntity idciudad) {
        this.id_ciudad = idciudad;
    }
}
