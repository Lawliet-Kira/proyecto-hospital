package com.example.democrud.model.dto;

public class MedicoDTO {

	    private Long id;
	    
	    private String especialidad;
	    
	    private String permisos;
	   
	    private Boolean activo;
	   
	    private Long persona_id;

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

		public Long getPersona_id() {
			return persona_id;
		}

		public void setPersona_id(Long persona_id) {
			this.persona_id = persona_id;
		}
	    
	    
	    	

}
