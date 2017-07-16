package umg.edu.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import umg.edu.model.Acceso;
import umg.edu.model.Usuario;
import umg.edu.service.UsuarioService;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UsuarioService usuarioService; 
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario user = usuarioService.buscarPorUsuario(username);
		if(user==null){
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getNombreUsuario(), user.getPassword(), 
				 true, true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Usuario user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Acceso> roles = usuarioService.listarPermisosUsuario(user.getCodigoUsuario());
		for(Acceso rol:roles){
			authorities.add(new SimpleGrantedAuthority(rol.getCodigoRol().getDescripcion()));
		}
		return authorities;
	}

}
