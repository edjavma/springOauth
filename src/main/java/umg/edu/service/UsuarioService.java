package umg.edu.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import umg.edu.dao.UsuarioDao;
import umg.edu.model.Acceso;
import umg.edu.model.Usuario;


public interface UsuarioService {
	public Usuario crear(Usuario usuario);
	public void modificar(Usuario usuario);
	public List<Usuario> listar();
	public Usuario buscarPorCodigo(Integer codigo);
	public Usuario buscarPorUsuario(String usuario);
	public List<Acceso> listarPermisosUsuario(Integer codigo);
}

@Service("usuarioServiceBean")
class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario crear(Usuario usuario) {
		try {
			System.out.println(passwordEncoder.encode(usuario.getPassword()));
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			return usuarioDao.crear(usuario);
		} catch (Exception e) {			
			return null;
		}
	}

	@Override
	public void modificar(Usuario usuario) {
			usuarioDao.modificar(usuario);		
	}

	@Override
	public List<Usuario> listar() {
		try {
			return usuarioDao.listar();
		} catch (Exception e) {
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public Usuario buscarPorCodigo(Integer codigo) {
		return usuarioDao.buscarPorCodigo(codigo);
	}

	@Override
	public Usuario buscarPorUsuario(String usuario) {
		try {
			Usuario temp = usuarioDao.buscarPorUsuario(usuario);
			return temp;
			//return usuarioDao.buscarPorUsuario(usuario);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Acceso> listarPermisosUsuario(Integer codigo) {
		try {
			return usuarioDao.listarPermisosUsuario(codigo);
		} catch (Exception e) {
			return new ArrayList<Acceso>();
		}
	}

}
