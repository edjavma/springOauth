package umg.edu.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/")
public class LoginController {

	/*@RequestMapping(method = RequestMethod.GET)
	public ModelAndView serviceLogin() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> name = auth.getAuthorities();
		Iterator<? extends GrantedAuthority> it = name.iterator();
		while(it.hasNext()){
			GrantedAuthority role = it.next();
			if(role.getAuthority().equalsIgnoreCase("ROLE_ANONYMOUS")){
				model.setViewName("login");
			}else{
				model.setViewName("home");
			}
		}
		
		return model;
	}*/
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		
		return model;
	}
}
