package umg.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umg.edu.dao.AdminDao;
import umg.edu.model.Rol;



public interface AdminService {
	public Rol getRol(String rol);
	
}


@Service("adminServiceBean")
class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	

	@Override
	public Rol getRol(String rol) {
		try {
			return adminDao.getRol(rol);
		} catch (Exception e) {
			return null;
		}
	}



}
