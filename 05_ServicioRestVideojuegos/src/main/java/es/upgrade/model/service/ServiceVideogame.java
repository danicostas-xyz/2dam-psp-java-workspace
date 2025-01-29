package es.upgrade.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upgrade.model.entity.Videogame;
import es.upgrade.model.persistence.DaoVideogame;

@Service
public class ServiceVideogame {

	@Autowired
	private DaoVideogame dao;

	public List<Videogame> readAllVideogames(){
		return dao.readAllVideogames();
	}
	
	public Integer createVideogame(Videogame v) {
		return dao.createVideogame(v);
	}

	public Videogame readVideogameById(int id) {
		return dao.readVideogameById(id);
	}

	public Videogame readVideogameByName(String name) {
		return dao.readVideogameByName(name);
	}

	public Videogame updateVideogame(Videogame v) {
		return dao.updateVideogame(v);
	}

	public Integer deleteVideogame(Videogame v) {
		return dao.deleteVideogame(v);
	}
}
