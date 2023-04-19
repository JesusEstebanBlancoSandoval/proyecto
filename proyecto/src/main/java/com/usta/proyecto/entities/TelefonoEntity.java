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
    @Column(name = "idTelefono")
    private Long idTelefono;

    @NotNull
    @Size(min = 10 , max = 30)
    @Column(name="Tipo")
    private String Tipo;

    @NotNull
    @Column(name="Numero")
    private Integer Numero;

    @NotNull
    @Column(name = "Estado")
    private Boolean Estado;


    @OneToOne(mappedBy = "idTelefono")
    private PersonasEntity idPersona;

    public Long getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Long idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        Numero = numero;
    }
}






