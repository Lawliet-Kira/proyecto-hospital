package com.example.democrud.service.api;

import com.example.democrud.commons.GenericServiceAPI;
import com.example.democrud.model.Medico;
import com.example.democrud.model.dto.MedicoDTO;

public interface MedicoServiceAPI extends GenericServiceAPI<Medico, Long> {
	
	public Medico createMedico(MedicoDTO medico);
	
}
