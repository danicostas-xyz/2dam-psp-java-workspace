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
		String jpql = "SELECT v FROM Videogame v";
		TypedQuery<Videogame> query = eManager.createQuery(jpql, Videogame.class);
		return query.getResultList();
	}

	public List<Videogame> readVideogameByName(String name) {
		EntityManager eManager = factory.createEntityManager();
		String jpql = "SELECT v FROM Videogame v WHERE v.name = :name"; // Usar :name como parámetro
		TypedQuery<Videogame> query = eManager.createQuery(jpql, Videogame.class);
		query.setParameter("name", name); // Asignar el valor al parámetro
		return query.getResultList();
	}

	public List<Videogame> readVideogameByCompany(String company) {
		EntityManager eManager = factory.createEntityManager();
		String jpql = "SELECT v FROM Videogame v WHERE v.company = :company"; // Usar :name como parámetro
		TypedQuery<Videogame> query = eManager.createQuery(jpql, Videogame.class);
		query.setParameter("company", company); // Asignar el valor al parámetro
		return query.getResultList();
	}

	public List<Videogame> readVideogameByRating(Double rating) {
		EntityManager eManager = factory.createEntityManager();
		String jpql = "SELECT v FROM Videogame v WHERE v.rating = :rating"; // Usar :name como parámetro
		TypedQuery<Videogame> query = eManager.createQuery(jpql, Videogame.class);
		query.setParameter("rating", rating); // Asignar el valor al parámetro
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
		return result = 1;
	}

	public Videogame readVideogameById(int id) {
		Videogame result = null;
		EntityManager eManager = factory.createEntityManager();
		result = eManager.find(Videogame.class, id);
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

	public Integer deleteVideogameById(int id) {
		Integer result = null;
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		transaction.begin();
		Videogame v = eManager.find(Videogame.class, id);
		eManager.remove(v);
		transaction.commit();
		eManager.close();
		return result;
	}

}
