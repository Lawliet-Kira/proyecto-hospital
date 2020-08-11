package com.example.democrud.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.GestorDaoAPI;
import com.example.democrud.model.Gestor;
import com.example.democrud.model.Persona;
import com.example.democrud.model.dto.GestorDTO;
import com.example.democrud.service.api.GestorServiceAPI;
import com.example.democrud.service.api.PersonaServiceAPI;

@Service
public class GestorServiceImpl extends GenericServiceImpl<Gestor, Long> implements GestorServiceAPI {
	
	@Autowired
	private GestorDaoAPI gestorDaoAPI;
	
	@Autowired
	private PersonaServiceAPI personaServiceAPI;

	@Override
	public CrudRepository<Gestor, Long> getDao() {
		return gestorDaoAPI;
	}
	
	@Override
	public Gestor createGestor(GestorDTO gestor) {
		Gestor New_gestor;
		Persona persona = personaServiceAPI.get(gestor.getPersona_id());
		
		if(persona != null) {
			New_gestor = new Gestor();
			New_gestor.setActivo(gestor.getActivo());
			New_gestor.setPermisos(gestor.getPermisos());
			New_gestor.setPersona(persona);
		}else {
			New_gestor = null;
		}
		
		return New_gestor;
	}




}
