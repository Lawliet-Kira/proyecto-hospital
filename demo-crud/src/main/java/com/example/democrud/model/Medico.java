package com.example.democrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String especialidad;
    
    @Column
    private String permisos;
    
    @Column
    private Boolean activo;
    
    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona Persona;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getPermisos() {
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

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona persona) {
		Persona = persona;
	}

	
    
}