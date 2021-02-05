package Korrea.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int projectId;
	
	@Column
	private String projectName;
	
//	@OneToMany( targetEntity = Resources.class, mappedBy = "project", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
//	private Set<Resources> resources;
 
	public Project() {
		
	}
	
	public Project(String projectName) {
		this.projectName = projectName;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
