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


@JoinColumn(name= "idRegistro",referencedColumnName = "idRegistro")
@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, optional = true)
private RegistrosEntity idregistro;

@NotNull
@Column(name = "Estrato")
private Integer Estrato;

@NotNull
@Column(name = "PuntosDeAgua")
private Integer PuntosDeAgua;


    @JoinColumn(name= "idTelefono",referencedColumnName = "idTelefono")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, optional = true)
    private TelefonoEntity idTelefono;


    @JoinColumn(name = "idEmpresa",referencedColumnName = "idEmpresa")
    @OneToOne( fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE,optional = true)
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

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer cedula) {
        Cedula = cedula;
    }

    public Boolean getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        Funcionario = funcionario;
    }

    public RegistrosEntity getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(RegistrosEntity idregistro) {
        this.idregistro = idregistro;
    }

    public TelefonoEntity getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(TelefonoEntity idTelefono) {
        this.idTelefono = idTelefono;
    }

    public EmpresasEntity getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(EmpresasEntity idEmpresa) {
        IdEmpresa = idEmpresa;
    }

    public RegistrosEntity getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(RegistrosEntity idRegistro) {
        this.idRegistro = idRegistro;
    }
}
