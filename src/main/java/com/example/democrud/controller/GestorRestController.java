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

import com.example.democrud.model.Gestor;
import com.example.democrud.model.Personal;
import com.example.democrud.model.dto.GestorDTO;
import com.example.democrud.model.dto.PersonalDTO;
import com.example.democrud.service.api.GestorServiceAPI;

@RestController
@RequestMapping(value = "/gestor/")
@CrossOrigin("*")
public class GestorRestController {
	
	@Autowired
	private GestorServiceAPI gestorServiceAPI;
	
	@GetMapping(value = "/all")
	public List<Gestor> getAll(){
		return gestorServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Gestor find(@PathVariable Long id) {
		return gestorServiceAPI.get(id);
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<Gestor> update(@RequestBody GestorDTO gestor){
		Gestor obj = gestorServiceAPI.get(gestor.getId());
		obj.setActivo(gestor.getActivo());
		obj.setPermisos(gestor.getPermisos());
		gestorServiceAPI.save(obj);
		return new ResponseEntity<Gestor>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/save")
	public ResponseEntity<Gestor> save(@RequestBody GestorDTO gestor){
		
		Gestor obj = gestorServiceAPI.createGestor(gestor);
		
		if(obj != null) {
			gestorServiceAPI.save(obj);
		}else{
			return new ResponseEntity<Gestor>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Gestor>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Gestor> delete(@PathVariable Long id){
		
		Gestor gestor = gestorServiceAPI.get(id);
		
		if( gestor!=null ) {
			gestorServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Gestor>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Gestor>(gestor,HttpStatus.OK);
		
		
	}
	
	
	
}
