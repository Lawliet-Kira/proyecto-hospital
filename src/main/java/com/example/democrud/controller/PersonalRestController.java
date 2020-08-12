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
import com.example.democrud.model.Personal;
import com.example.democrud.model.dto.MedicoDTO;
import com.example.democrud.model.dto.PersonalDTO;
import com.example.democrud.service.api.PersonalServiceAPI;

@RestController
@RequestMapping(value = "/personal/")
@CrossOrigin("*")
public class PersonalRestController {

	@Autowired
	private PersonalServiceAPI personalServiceAPI;
	
	@GetMapping(value = "/all")
	public List<Personal> getAll(){
		return personalServiceAPI.getAll();
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<Personal> update(@RequestBody PersonalDTO personal){
		Personal obj = personalServiceAPI.get(personal.getId());
		obj.setCargo(personal.getCargo());
		obj.setTipo(personal.getTipo());
		obj.setPermisos(personal.getPermisos());
		obj.setActivo(personal.getActivo());
		personalServiceAPI.save(obj);
		return new ResponseEntity<Personal>(obj, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/find/{id}")
	public Personal find(@PathVariable Long id) {
		return personalServiceAPI.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Personal> save(@RequestBody PersonalDTO personal){
		
		Personal obj = personalServiceAPI.createPersonal(personal);
		
		if( obj != null) {
			personalServiceAPI.save(obj);
		}else {
			return new ResponseEntity<Personal>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Personal>(obj,HttpStatus.OK);	
	}
	
	@GetMapping(value="/delete/{id}")
	public ResponseEntity<Personal> delete(@PathVariable Long id){
		Personal personal = personalServiceAPI.get(id);
		if( personal != null) {
			personalServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Personal>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Personal>(personal, HttpStatus.OK);			
	}
	
	
}
