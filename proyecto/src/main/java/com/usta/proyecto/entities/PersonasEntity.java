package com.usta.proyecto.entities;


import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Personas")
public class PersonasEntity implements Serializable {

         private static final long serialVersionUID=1L;


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idPersona")
private Long idPersona;


@NotNull
@Size(min = 1,max= 30)
@Column(name ="Nombre")
private String Nombre;


@NotNull
@Size(min = 1,max = 30)
@Column(name = "Apellido")
private String Apellido;

@NotNull
@Column(name = "Cedula")
private Integer Cedula;

@Column(name = "Funcionario")
private Boolean Funcionario;

@JoinColumn(name = "idRegistro")
@OneToOne(cascade = CascadeType.REMOVE,optional = true)
private RegistrosEntity IdRegistro;

@NotNull
@Column(name = "Estrato")
private Integer Estrato;

@NotNull
@Column(name = "PuntosDeAgua")
private Integer PuntosDeAgua;

    @JoinColumn(name = "idTelefono")
    @OneToOne(cascade = CascadeType.REMOVE,optional = true)
    private TelefonoEntity IdTelefono;

    @JoinColumn(name = "idEmpresa")
    @OneToOne(cascade = CascadeType.REMOVE,optional = true)
    private EmpresasEntity IdEmpresa;



@NotNull
@Column(name = "Estado")
private Boolean Estado;

    @OneToOne (mappedBy = "idPersona")            //combinar la tabla funcionarios y la tabla clientes dejando los datos de funcionario como nulos//
    private RegistrosEntity idRegistro;


    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Integer getEstrato() {
        return Estrato;
    }

    public void setEstrato(Integer estrato) {
        Estrato = estrato;
    }

    public Integer getPuntosDeAgua() {
        return PuntosDeAgua;
    }

    public void setPuntosDeAgua(Integer puntosDeAgua) {
        PuntosDeAgua = puntosDeAgua;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }
}
