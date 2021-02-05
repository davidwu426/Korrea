package Korrea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Korrea.dao.ResourceDAO;
import Korrea.model.Resources;

@Service
public class ResourceService {
	
	@Autowired
	private ResourceDAO resourceDAO;
	
	public Resources getResource(int id) {
		return this.resourceDAO.findByResourceId(id);
	}
	
	public List<Resources> getAllResources(){
		return this.resourceDAO.findAll();
	}
	
	public Resources getResourceByCode(int code) {
		return this.resourceDAO.findByResourceCode(code); 
	}
	
	public Resources getResourceByName(String name) {
		return this.resourceDAO.findByResourceName(name);
	}
	
//	public boolean checkIfResourceExistsByName(String name) {
//		return this.resourceDAO.existByResourceName(name);
//	}
}
