package com.pruebas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;

import antlr.collections.List;

@RestController
@RequestMapping("personas")
public class PersonaRest {
	
	@Autowired
	private PersonaDAO personaDAO;
	
	//Metodos HTTP - solicitud al servidor
	
	//GET post, put delete  --> (200 -- 500 algo mal en la logica -- 404 ruta mal escrita) respuesta del servidor
	@PostMapping("/guardar")//localhost:8080/personas/guardar
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
	@GetMapping("/listar")
	public java.util.List<Persona> listar(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona) {
	personaDAO.save(persona);
	}

}
