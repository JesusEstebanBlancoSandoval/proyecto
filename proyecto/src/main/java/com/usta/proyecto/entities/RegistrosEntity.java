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
    @Column(name ="idRegistro")
    private Long idRegistro;


    @NotNull
    @Column(name="GastoPasado")
    private Integer GastoPasado;


    @NotNull
    @Column(name="MedicionPasada")
    private Integer MedicionPasada;



    @NotNull
    @Column(name = "GastoActual")
    private Integer GastoActual;



    @NotNull
    @Column(name = "MedicionActual")
    private Integer MedicionActual;



    @NotNull
    @Column(name = "FechaMedicion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date FechaMedicion;

    @NotNull
    @Column(name = "Estado")
    private Boolean Estado;



    //espacio para conexion con otro entity//
    @JoinColumn(name = "idPersona" , referencedColumnName = "idPersona")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,optional = true)
    private PersonasEntity idPersona;


    @OneToOne (mappedBy = "idRegistro")  //comparte el id registro a la tabla pagos//
    private PagosEntity idPago;

    @OneToOne(mappedBy = "MedicionActual")  //este que mande la medicion actual a la medicion de pagos//
    private PagosEntity medicion;

    //espacio para conexion con otro entity//

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getGastoPasado() {
        return GastoPasado;
    }

    public void setGastoPasado(Integer gastoPasado) {
        GastoPasado = gastoPasado;
    }

    public Integer getMedicionPasada() {
        return MedicionPasada;
    }

    public void setMedicionPasada(Integer medicionPasada) {
        MedicionPasada = medicionPasada;
    }

    public Integer getGastoActual() {
        return GastoActual;
    }

    public void setGastoActual(Integer gastoActual) {
        GastoActual = gastoActual;
    }

    public Integer getMedicionActual() {
        return MedicionActual;
    }

    public void setMedicionActual(Integer medicionActual) {
        MedicionActual = medicionActual;
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
        return idPersona;
    }

    public void setIdPersona(PersonasEntity idPersona) {
        this.idPersona = idPersona;
    }
}
