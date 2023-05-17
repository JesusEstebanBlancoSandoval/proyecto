package com.usta.proyecto.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name ="telefono")
public class TelefonoEntity implements Serializable {

    private static final long serialVersionUID=1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private Long id_telefono;

    @NotNull
    @Size(min = 10 , max = 30)
    @Column(name="Tipo")
    private String Tipo;

    @NotNull
    @Size(min = 10 , max = 30)
    @Column(name="Numero")
    private String Numero;

    @NotNull
    @Column(name = "Estado")
    private Boolean Estado;


   // @OneToOne(mappedBy = "id_telefono")
    //private PersonasEntity id_Persona;

    public Long getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(Long id_telefono) {
        this.id_telefono = id_telefono;
    }

    //public PersonasEntity getIdPersona() {
    //    return id_Persona;
    //}

    //public void setIdPersona(PersonasEntity idPersona) {
    //    this.id_Persona = idPersona;
    //}

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }
}






