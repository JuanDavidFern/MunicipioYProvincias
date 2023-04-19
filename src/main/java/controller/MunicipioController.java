package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Municipio;
import model.Provincia;


public class MunicipioController {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MunicipiosYProvincias");
	
	public static List<Municipio> findByDesc(String cadena) {
		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM municipio where lower(nombre) like ?;", Municipio.class);
		q.setParameter(1, "%" + cadena.toLowerCase() + "%");
		List<Municipio> lista = (List<Municipio>) q.getResultList();

		em.close();

		return lista;

	}
	
	public static void update(Municipio m) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}
	
	

}
