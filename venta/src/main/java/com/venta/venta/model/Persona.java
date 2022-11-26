package com.venta.venta.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "emisor",nullable = false)
    private String emisor;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    private Double valor;
    private Date fechaFactura;

    // @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // @JoinColumn(name = "direccion_id")
    // private Direccion direccion;
        
	public Persona() {
    }

    public Persona(long id, String emisor, String descripcion, Double valor, Date fechaFactura) {
        this.id = id;
        this.emisor = emisor;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fechaFactura = fechaFactura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
}
