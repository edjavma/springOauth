package umg.edu.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umg.edu.model.Rol;


public interface AdminDao {
	public Rol getRol(String rol);
	
}

@Repository
@Transactional
class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Rol getRol(String rol) {
		try {
			TypedQuery<Rol> query = entityManager.createNamedQuery("Rol.findByName",Rol.class);
			query.setParameter("rolName", rol);
			return (query.getSingleResult()!=null) ? query.getSingleResult() : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	



}
