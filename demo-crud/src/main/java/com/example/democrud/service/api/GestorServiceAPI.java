package com.example.democrud.service.api;

import com.example.democrud.commons.GenericServiceAPI;
import com.example.democrud.model.Gestor;
import com.example.democrud.model.dto.GestorDTO;

public interface GestorServiceAPI extends GenericServiceAPI<Gestor, Long> {
	
	public Gestor createGestor(GestorDTO gestor);
	
}
