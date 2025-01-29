package es.upgrade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.upgrade.model.entity.Videogame;
import es.upgrade.model.service.ServiceVideogame;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private ServiceVideogame service;

	@GetMapping(path = "videogame", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videogame>> getVideogameList(@RequestParam(name="name", required = false) String name) {
		System.out.println("Buscando lista videojuegos");
		List<Videogame> videogamesList = service.readAllVideogames();
		if(name == null) {
			System.out.println("Listando todos los videojuegos");
			videogamesList = service.readAllVideogames();			
		}else {
			System.out.println("Listando videojuegos por nombre: " + name);
			videogamesList = null;
		}
		System.out.println(videogamesList);
		return new ResponseEntity<List<Videogame>>(videogamesList,HttpStatus.OK);
	}
		
		
}
