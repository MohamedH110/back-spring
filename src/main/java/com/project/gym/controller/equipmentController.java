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

import com.project.gym.model.equipment;
import com.project.gym.repository.equipmentRepository;






@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v3")
public class equipmentController {

	
	@Autowired
	private equipmentRepository equipmentRepository;

	@GetMapping(value="/equipments" ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<equipment>> getlist() {
	    try {
	        List<equipment> equipments = equipmentRepository.findAll();
	        return ResponseEntity.ok(equipments);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	
	 @PostMapping(value = "/equipments",consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<equipment> addequipment(@RequestBody equipment newequipment) {
	     
	    	equipment savedequipment = equipmentRepository.save(newequipment);
	      
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedequipment);
	    }
	    
	    
	    

		 @PutMapping(value = "/equipments/{number}", consumes = MediaType.APPLICATION_JSON_VALUE)
		    @ResponseBody
		    public ResponseEntity<equipment> updateequipment(@PathVariable int number, @RequestBody equipment updatedequipment) {
		        if (!equipmentRepository.existsById(number)) {
		            return ResponseEntity.notFound().build();
		        }
		        updatedequipment.setNumber(number);
		        return ResponseEntity.ok(equipmentRepository.save(updatedequipment));
		    }
		    
		    
		    @DeleteMapping(value = "/equipments/{number}")
		    @ResponseBody
		    public void deleteequipment(@PathVariable int number) {
		    	equipmentRepository.deleteById(number);
		    }
}
