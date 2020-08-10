package com.example.democrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GestorAsignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestor;

    @Column
    private String permisos;
    
    @Column
    private Boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id")
    private Persona Persona;

    public Long getidGestor() {
        return idGestor;
    }

    public void setidGestor(Long id) {
        this.idGestor = id;
    }

    public String getpermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}