package Korrea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Korrea.services.ProjectService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping(value="/projects")
	public ResponseEntity<List> getProjects(){
		return ResponseEntity.ok(this.projectService.getAllProject());
	}
	
}
