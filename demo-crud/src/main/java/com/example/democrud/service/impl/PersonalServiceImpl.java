package com.example.democrud.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.PersonalDaoAPI;
import com.example.democrud.model.Persona;
import com.example.democrud.model.Personal;
import com.example.democrud.model.dto.PersonalDTO;
import com.example.democrud.service.api.PersonaServiceAPI;
import com.example.democrud.service.api.PersonalServiceAPI;


@Service
public class PersonalServiceImpl extends GenericServiceImpl<Personal, Long>  implements PersonalServiceAPI {
	
	@Autowired
	private PersonalDaoAPI personalDaoAPI;
	
	@Autowired
	private PersonaServiceAPI personaServiceAPI;
	
	@Override
	public CrudRepository<Personal, Long> getDao() {
		return personalDaoAPI;
	}

	@Override
	public Personal createPersonal(PersonalDTO personal) {
		Personal New_personal;
		
		Persona persona = personaServiceAPI.get(personal.getPersona_id());
		
		if(persona != null) {
			New_personal = new Personal();
			New_personal.setActivo(personal.getActivo());
			New_personal.setCargo(personal.getCargo());
			New_personal.setTipo(personal.getTipo());
			New_personal.setPermisos(personal.getPermisos());
			New_personal.setPersona(persona);			
		}else {
			New_personal = null;
		}
		
		return New_personal;
	}


}
