package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.Medico;

public interface MedicoDaoAPI extends CrudRepository<Medico, Long> { 
	
}
