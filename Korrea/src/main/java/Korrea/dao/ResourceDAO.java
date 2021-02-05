package Korrea.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Korrea.model.Resources;

@Repository
public interface ResourceDAO extends JpaRepository<Resources,Integer>{
	
	public Resources findByResourceId(int id);
	//@Query("Select r.resourceName,r.resourceCode from resources r")
	public List<Resources> findAll();
	public Resources findByResourceCode(int code);
	public Resources findByResourceName(String name);
	//public boolean existByResourceName(String name);
	
}
