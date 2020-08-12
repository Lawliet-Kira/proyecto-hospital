package com.example.democrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democrud.model.Medico;
import com.example.democrud.model.Persona;
import com.example.democrud.model.dto.MedicoDTO;
import com.example.democrud.service.api.MedicoServiceAPI;
import com.example.democrud.service.api.PersonaServiceAPI;

@RestController
@RequestMapping(value = "/medico/")
@CrossOrigin("*")
public class MedicoRestController {

	@Autowired
	private MedicoServiceAPI medicoServiceAPI;

	@GetMapping(value = "/all")
	public List<Medico> getAll() {
		return medicoServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Medico find(@PathVariable Long id) {
		return medicoServiceAPI.get(id);
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<Medico> update(@RequestBody MedicoDTO medico){
		Medico obj = medicoServiceAPI.get(medico.getId());
		obj.setActivo(medico.getActivo());
		obj.setEspecialidad(medico.getEspecialidad());
		obj.setPermisos(medico.getPermisos());
		medicoServiceAPI.save(obj);
		return new ResponseEntity<Medico>(obj, HttpStatus.OK);
	}
	
	// Gestionar el ConstraintViolationException cuando ya existe un medico
	@PostMapping(value = "/save")
	public ResponseEntity<Medico> save(@RequestBody MedicoDTO medico) {
		
		Medico obj = medicoServiceAPI.createMedico(medico);
		
		if( obj != null) {
			medicoServiceAPI.save(obj);
		}else {
			return new ResponseEntity<Medico>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Medico>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Medico> delete(@PathVariable Long id) {
		
		Medico medico = medicoServiceAPI.get(id);
		if (medico != null) {
			medicoServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Medico>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Medico>(medico, HttpStatus.OK);
	}
	
}
