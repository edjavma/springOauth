package umg.edu.dao;

import java.util.ArrayList;
import java.util.List;







import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import umg.edu.model.Acceso;
import umg.edu.model.Usuario;



public interface UsuarioDao {
	public Usuario crear(Usuario usuario);
	public void modificar(Usuario usuario);
	public List<Usuario> listar();
	public Usuario buscarPorCodigo(Integer codigo);
	public Usuario buscarPorUsuario(String usuario);
	public Integer correlativo();
	public List<Acceso> listarPermisosUsuario(Integer codigo);
}

@Repository
@Transactional
class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Usuario crear(Usuario usuario) {
		try {
			Usuario temp = new Usuario();
			temp.setCodigoUsuario(this.correlativo());
			temp.setNombreUsuario(usuario.getNombreUsuario());
			temp.setPassword(usuario.getPassword());
			temp.setNombre(usuario.getNombre());
			temp.setDireccion(usuario.getDireccion());				
			entityManager.persist(temp);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modificar(Usuario usuario) {
		try {
			entityManager.merge(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> listar() {
		try {
			TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.listar",Usuario.class);
			return CollectionUtils.isEmpty(query.getResultList()) ? new ArrayList<Usuario>() : query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public Usuario buscarPorCodigo(Integer codigo) {
		try {
			TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.find",Usuario.class);
			query.setParameter("codigo", codigo);
			return (query.getSingleResult()!= null) ? query.getSingleResult() : null;
		} catch (NonUniqueResultException p) { 
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Usuario buscarPorUsuario(String usuario) {
		try {
			TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.findByUsername",Usuario.class);
			query.setParameter("nombre", usuario);
			Usuario temp = query.getSingleResult();
			return temp;
			
		} catch (NoResultException nr) {
			return null;
		} catch (NonUniqueResultException p) { 
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer correlativo() {
		try {
			TypedQuery<Integer> query = entityManager.createNamedQuery("Usuario.correlativo",Integer.class);
			if(query.getSingleResult()!=null){
				return query.getSingleResult() + 1;
			}else{
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Acceso> listarPermisosUsuario(Integer codigo) {
		try {
			TypedQuery<Acceso> query = entityManager.createNamedQuery("Acceso.listarPorUsuario",Acceso.class);
			query.setParameter("codigo", codigo);
			List<Acceso> temp = query.getResultList();
			return temp;
			//return CollectionUtils.isEmpty(query.getResultList()) ? null : query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Acceso>();
		}
	}

}
