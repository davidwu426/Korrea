package Korrea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Resources")
public class Resources {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int resourceId;
	
	@Column
	private String resourceName;
	
	@Column
	private int resourceCode;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Project project;
	
	public Resources() {
		
	}
	
	public Resources(String resourceName, int resourceCode) {
		this.resourceName = resourceName;
		this.resourceCode = resourceCode;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(int resourceCode) {
		this.resourceCode = resourceCode;
	}
	
}
