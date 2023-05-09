package com.usta.proyecto.entities;

import jakarta.persistence.*;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Detalles")

public class DetallesEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalles")
    private Long idDetalles;

    @JoinColumn(name = "idPago",referencedColumnName = "idPago")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,optional = true)
    private PagosEntity idpago;

    @NotNull
    @Column(name = "CostoAPagar")    //que contabilice la medicion y genere un costo a pagar ej:20000 por una medicion de 1000 mts^3//
    private Integer CostoAPagar;

    @JoinColumn(name = "medicion", referencedColumnName = "MedicionActual")
    @OneToOne( fetch =FetchType.LAZY ,cascade = CascadeType.REMOVE, optional = true)   //aca se debe mostrar la medicion registrada en registros//
    private RegistrosEntity medicion;

    @JoinColumn(name = "medicionPasada",referencedColumnName = "medicionPasada")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,optional = true)
    private RegistrosEntity medicionPasada;


    @NotNull
    @Column(name = "costo pasado")
    private Integer CostoPasado;


    @Column(name = "DeudaTotal")
    private Integer DeudaTotal;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;


    public Long getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(Long idDetalles) {
        this.idDetalles = idDetalles;
    }

    public Integer getCostoAPagar() {
        return CostoAPagar;
    }

    public void setCostoAPagar(Integer costoAPagar) {
        CostoAPagar = costoAPagar;
    }

    public Integer getCostoPasado() {
        return CostoPasado;
    }

    public void setCostoPasado(Integer costoPasado) {
        CostoPasado = costoPasado;
    }

    public Integer getDeudaTotal() {
        return DeudaTotal;
    }

    public void setDeudaTotal(Integer deudaTotal) {
        DeudaTotal = deudaTotal;
    }

    public RegistrosEntity getMedicion() {
        return medicion;
    }

    public void setMedicion(RegistrosEntity medicion) {
        this.medicion = medicion;
    }

    public RegistrosEntity getMedicionPasada() {
        return medicionPasada;
    }

    public void setMedicionPasada(RegistrosEntity medicionPasada) {
        this.medicionPasada = medicionPasada;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PagosEntity getIdpago() {
        return idpago;
    }

    public void setIdpago(PagosEntity idpago) {
        this.idpago = idpago;
    }
}
