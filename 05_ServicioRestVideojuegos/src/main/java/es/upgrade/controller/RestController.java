package es.upgrade.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.upgrade.model.entity.ErrorResponse;
import es.upgrade.model.entity.Videogame;
import es.upgrade.model.service.ServiceVideogame;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private ServiceVideogame service;

	/**
	 * Get Videogame List or Videogame List by Name
	 * 
	 * -> GET localhost:6969/videogame -> GET localhost:6969/videogame?name=whatever
	 * 
	 */
	@GetMapping(path = "videogame", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videogame>> getVideogameList(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "company", required = false) String company,
			@RequestParam(name = "rating", required = false) Double rating) {
		
		List<Videogame> videogamesList = null;
		HashSet<Videogame> hashSet = new HashSet<Videogame>();

		if (name == null && company == null && rating == null) {
			videogamesList = service.readAllVideogames();
		} else {
			if(name == null || company == null || rating == null) {
				
				if (name != null){
					videogamesList = service.readVideogameByName(name);
					hashSet.addAll(videogamesList);
				}
				if (company != null){
					videogamesList = service.readVideogameByCompany(company);
					hashSet.addAll(videogamesList);
				}
				if (rating != null){
					videogamesList = service.readVideogameByRating(rating);
					hashSet.addAll(videogamesList);
				}
				
				videogamesList = new ArrayList<Videogame>(hashSet);
			}
		}

		return new ResponseEntity<List<Videogame>>(videogamesList, HttpStatus.OK);
	}

	/**
	 * Get Videogame by id
	 * 
	 * -> GET localhost:6969/videogame/{id}
	 * 
	 */
	@GetMapping(path = "videogame/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videogame> getVideogameById(@PathVariable(name = "id") int id) {

		Videogame v = service.readVideogameById(id);
		return new ResponseEntity<Videogame>(v, HttpStatus.OK);
	}

	/**
	 * Create Videogame
	 * 
	 * -> POST localhost:6969/videogame/ (videogame.json in Request Body)
	 * 
	 */
	@PostMapping(path = "videogame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createVideogame(@RequestBody Videogame v) {

		Integer result = service.createVideogame(v);
		if (result == 666) {
			ErrorResponse error = new ErrorResponse("El videojuego ya existe");
			return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
		}
		
		if (result == 0) {
			ErrorResponse error = new ErrorResponse("El videojuego tiene que tener un nombre");
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(v, HttpStatus.OK);
	}
	
		/**
	 * Update Videogame
	 * 
	 * -> PUT localhost:6969/videogame/ (videogame.json in Request Body)
	 * 
	 */
	@PutMapping(path = "videogame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videogame> updateVideogame(@RequestBody Videogame v) {

		v = service.updateVideogame(v);
		return new ResponseEntity<Videogame>(v, HttpStatus.OK);
	}

	/**
	 * Delete Videogame by id
	 * 
	 * -> DELETE localhost:6969/videogame/{id}
	 * 
	 */
	@DeleteMapping(path = "videogame/{id}")
	public ResponseEntity<Videogame> deleteVideogameByID(@PathVariable(name = "id") int id) {

		service.deleteVideogameById(id);
		return new ResponseEntity<Videogame>(HttpStatus.OK);
	}

}
