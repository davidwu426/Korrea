package Korrea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Korrea.model.Resources;
import Korrea.services.ResourceService;

@Controller
@RestController
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	@GetMapping(value="/resources")
	public ResponseEntity<List> getResources(){
		return ResponseEntity.ok(this.resourceService.getAllResources());
	}
	
//	@GetMapping(value="/resources/{code}")
//	public ResponseEntity<Object> getResourceByCode(@PathVariable int code){
//		System.out.println(code);
////		Resources temp = this.resourceService.getResourceByCode(code);
////		System.out.println(temp.getResourceId());
//		return ResponseEntity.ok("hello world");	
//	}
	
	@GetMapping(value="/resources/{name}")
	public ResponseEntity<Object> getResourceByName(@PathVariable String name){
		return ResponseEntity.ok(this.resourceService.getResourceByName(name));
	}
	
//	@GetMapping(value="resources/check/name")
//	public ResponseEntity<Boolean> checkIfResourceExistsByName(@PathVariable String name){
//		return ResponseEntity.ok(this.resourceService.checkIfResourceExistsByName(name));
//	}
}
