package umg.edu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import umg.edu.model.UserPermission;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import umg.edu.service.UsuarioService;

@RestController
public class HomeController {
	
	 @Autowired
	 UsuarioService usuarioService;  //Service which will do all data retrieval/manipulation work
	 
	     
	    //-------------------Retrieve All Users--------------------------------------------------------
	     
	    
	    @SuppressWarnings("unchecked")
	    @RequestMapping(value = "/verify",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<String> authVerify() throws JsonGenerationException, JsonMappingException, IOException{
	    	ObjectMapper mapper = new ObjectMapper();
	    	List<String> authorities = new ArrayList<String>();
	    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
	        	
	    	
			Collection<SimpleGrantedAuthority> collectionAuthorities =  (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			for(SimpleGrantedAuthority authority : collectionAuthorities){
				authorities.add(authority.getAuthority());
			}
			
			UserPermission permission = new UserPermission();
			permission.setRoles(authorities);
			permission.setUsername(username);
			
			
	    	return new ResponseEntity<String>(mapper.writeValueAsString(permission),HttpStatus.OK);
	    }
	 

}
