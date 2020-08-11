package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.MedicoDaoAPI;
import com.example.democrud.model.Medico;
import com.example.democrud.model.Persona;
import com.example.democrud.model.dto.MedicoDTO;
import com.example.democrud.service.api.MedicoServiceAPI;
import com.example.democrud.service.api.PersonaServiceAPI;


@Service
public class MedicoServiceImpl extends GenericServiceImpl<Medico, Long> implements MedicoServiceAPI {

	@Autowired
	private MedicoDaoAPI medicoDaoAPI;
	
	@Autowired
	private PersonaServiceAPI personaServiceAPI;
	
	@Override
	public CrudRepository<Medico, Long> getDao() {
		return medicoDaoAPI;
	}
	
	@Override
	public Medico createMedico(MedicoDTO medico) {
		Medico New_medico;
		Persona persona = personaServiceAPI.get(medico.getPersona_id());
		
		if( persona != null ) {
			New_medico = new Medico();
			New_medico.setEspecialidad(medico.getEspecialidad());
			New_medico.setPermisos(medico.getPermisos());
			New_medico.setActivo(medico.getActivo());
			New_medico.setPersona(persona);
		}else{
			New_medico = null;
		}	
		
		return New_medico;
	}
	
	
}
