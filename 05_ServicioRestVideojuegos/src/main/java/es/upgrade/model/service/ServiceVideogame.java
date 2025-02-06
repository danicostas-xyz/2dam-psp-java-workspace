package es.upgrade.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upgrade.model.entity.Videogame;
import es.upgrade.model.persistence.DaoVideogame;

@Service
public class ServiceVideogame {

	@Autowired
	private DaoVideogame dao;

	public List<Videogame> readAllVideogames() {
		return dao.readAllVideogames();
	}

	/**
	 * 
	 * @param v El videojuego a persistir.
	 * @return 0 en caso de que el videojuego tenga el nombre en blanco, 666 en caso
	 *         de que ya exista un videojuego en la persistencia con el mismo
	 *         nombre, 1 en caso de que el videojuego se haya persistido
	 *         correctamente
	 */
	public Integer createVideogame(Videogame v) {

		if (v.getName().isBlank()) {
			return 0;
		}

		if (!dao.readVideogameByName(v.getName()).isEmpty()) {
			return 666;
		}

		return dao.createVideogame(v);
	}

	public Videogame readVideogameById(int id) {
		return dao.readVideogameById(id);
	}

	public List<Videogame> readVideogameByName(String name) {
		return dao.readVideogameByName(name);
	}

	public Videogame updateVideogame(Videogame v) {
		return dao.updateVideogame(v);
	}

	public Integer deleteVideogameById(int id) {
		return dao.deleteVideogameById(id);
	}

	public List<Videogame> readVideogameByCompany(String company) {
		return dao.readVideogameByCompany(company);
	}

	public List<Videogame> readVideogameByRating(Double rating) {
		return dao.readVideogameByRating(rating);
	}
}
