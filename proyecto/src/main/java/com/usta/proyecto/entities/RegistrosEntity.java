package com.usta.proyecto.entities;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Registros")
public class RegistrosEntity  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_registro")
    private Long id_registro;


    @NotNull
    @Column(name = "FechaMedicion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date FechaMedicion;

    @NotNull
    @Column(name = "Estado")
    private Boolean Estado;



    //espacio para conexion con otro entity//
    @JoinColumn(name = "id_persona" , referencedColumnName = "id_persona")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,optional = true)
    private PersonasEntity id_persona;



    //espacio para conexion con otro entity//

    public Long getIdRegistro() {
        return id_registro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.id_registro = idRegistro;
    }


    public Date getFechaMedicion() {
        return FechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        FechaMedicion = fechaMedicion;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    public PersonasEntity getIdPersona() {
        return id_persona;
    }

    public void setIdPersona(PersonasEntity idPersona) {
        this.id_persona = idPersona;
    }
}
