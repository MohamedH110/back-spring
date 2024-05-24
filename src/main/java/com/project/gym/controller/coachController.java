package com.project.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gym.model.coach;

import com.project.gym.repository.coachRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2")
public class coachController {
	
	@Autowired
	private coachRepository coachrepository;

	@GetMapping(value="/coaches" ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<coach>> getlist() {
	    try {
	        List<coach> members = coachrepository.findAll();
	        return ResponseEntity.ok(members);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}

	 @PostMapping(value = "/coaches",consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<coach> addcoach(@RequestBody coach newcoach) {
	     
	    	coach savedcoach = coachrepository.save(newcoach);
	      
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedcoach);
	    }
	    
	    @PutMapping(value = "/coaches/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<coach> updatecoach(@PathVariable int id, @RequestBody coach updatedcoach) {
	        if (!coachrepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedcoach.setId(id);
	        return ResponseEntity.ok(coachrepository.save(updatedcoach));
	    }

	    
	    @DeleteMapping(value = "/coaches/{id}")
	    @ResponseBody
	    public void deletcoach(@PathVariable int id) {
	    	coachrepository.deleteById(id);
	    }

}
