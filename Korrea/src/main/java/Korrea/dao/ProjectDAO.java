package Korrea.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Korrea.model.Project;

@Repository
public interface ProjectDAO extends JpaRepository<Project,Integer>{
	
	public Project findByProjectId(int id);
	public List<Project> findAll();
}
