package es.upgrade.model.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import es.upgrade.model.entity.Videogame;

@Repository
public class DaoVideogame {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaUnit");
	
	
	public List<Videogame> readAllVideogames() {
		EntityManager eManager = factory.createEntityManager();
		String jpql = "SELECT m FROM videogames m";
        TypedQuery<Videogame> query = eManager.createQuery(jpql, Videogame.class);
        return query.getResultList();
	}
	
	public Integer createVideogame(Videogame v) {
		Integer result = null;
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		transaction.begin();
		eManager.persist(v);
		transaction.commit();
		eManager.close();
		return result;
	}
		
	public Videogame readVideogameById(int id) {
		Videogame result = null;
		EntityManager eManager = factory.createEntityManager();
		result = eManager.find(Videogame.class, id);
		eManager.close();
		return result;
	}
	
	public Videogame readVideogameByName(String name) {
		Videogame result = null;
		EntityManager eManager = factory.createEntityManager();
		result = eManager.find(Videogame.class, name);
		eManager.close();
		return result;
	}
	
	public Videogame updateVideogame(Videogame v) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		transaction.begin();
		v = eManager.merge(v);
		transaction.commit();
		eManager.close();
		return v;
	}
	
	public Integer deleteVideogame(Videogame v) {
		Integer result = null;
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		transaction.begin();
		eManager.remove(v);
		transaction.commit();
		eManager.close();
		return result;
	}
}
