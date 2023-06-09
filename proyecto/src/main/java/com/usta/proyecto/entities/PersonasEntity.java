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
@Column(name="id_persona")
private Long id_persona;


@NotNull
@Size(min = 1,max= 30)
@Column(name ="Nombre")
private String Nombre;


@NotNull
@Size(min = 1,max = 30)
@Column(name = "Apellido")
private String Apellido;

@NotNull
@Size(min = 10,max = 30)
@Column(name = "Cedula")
private String Cedula;

@Column(name = "Funcionario")
private Boolean Funcionario;

@NotNull
@Column(name = "Estrato")
private Integer Estrato;

@NotNull
@Column(name = "PuntosDeAgua")
private Integer PuntosDeAgua;


    @JoinColumn(name= "id_telefono",referencedColumnName = "id_telefono")
    @OneToOne( fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, optional = true)
    private TelefonoEntity id_telefono;


    @JoinColumn(name = "id_empresa",referencedColumnName = "id_empresa")
    @OneToOne( fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE,optional = true)
    private EmpresasEntity Id_empresa;



@NotNull
@Column(name = "Estado")
private Boolean Estado;

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
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

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public Boolean getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        Funcionario = funcionario;
    }

    public TelefonoEntity getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(TelefonoEntity id_telefono) {
        this.id_telefono = id_telefono;
    }

    public EmpresasEntity getIdEmpresa() {
        return Id_empresa;
    }

    public void setIdEmpresa(EmpresasEntity idEmpresa) {
        Id_empresa = idEmpresa;
    }

    public Long getid_persona() {
        return id_persona;
    }

    public void setid_persona(Long id_Persona) {
        this.id_persona = id_Persona;
    }


}
