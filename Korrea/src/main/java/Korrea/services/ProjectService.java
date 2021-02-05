package Korrea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Korrea.dao.ProjectDAO;
import Korrea.model.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public Project getProjectById(int id) {
		return this.projectDAO.findByProjectId(id);
	}
	
	public List<Project> getAllProject(){
		return this.projectDAO.findAll();
	}

}
