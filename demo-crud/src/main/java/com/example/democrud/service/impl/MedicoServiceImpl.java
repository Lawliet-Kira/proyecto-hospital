package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.MedicoDaoAPI;
import com.example.democrud.model.Medico;
import com.example.democrud.service.api.MedicoServiceAPI;


@Service
public class MedicoServiceImpl extends GenericServiceImpl<Medico, Long> implements MedicoServiceAPI {

	@Autowired
	private MedicoDaoAPI medicoDaoAPI;
	
	@Override
	public CrudRepository<Medico, Long> getDao() {
		return medicoDaoAPI;
	}

}
