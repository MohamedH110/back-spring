package com.project.gym.controller;

import java.util.List;
import java.util.Optional;

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

import com.project.gym.model.LoginRequest;
import com.project.gym.model.member;
import com.project.gym.repository.memberRepository;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class memberController {
	
	@Autowired
	private memberRepository memberrepository;


	@GetMapping(value="/members" ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<member>> getlist() {
	    try {
	        List<member> members = memberrepository.findAll();
	        return ResponseEntity.ok(members);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	
	 @PostMapping(value = "/members",consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<member> addmember(@RequestBody member newmember) {
	     
	    	member savedmember = memberrepository.save(newmember);
	      
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedmember);
	    }
	    
	    
	    @PutMapping(value = "/members/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<member> updatedmember(@PathVariable int id, @RequestBody member updatedmember) {
	        if (!memberrepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedmember.setId(id);
	        return ResponseEntity.ok(memberrepository.save(updatedmember));
	    }

	    
	    @DeleteMapping(value = "/members/{id}")
	    @ResponseBody
	    public void deletemember(@PathVariable int id) {
	    	memberrepository.deleteById(id);
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	        Optional<member> optionalMember = memberrepository.findByEmail(loginRequest.getEmail());

	        if (optionalMember.isPresent()) {
	            member member = optionalMember.get();
	            if (member.getPassword().equals(loginRequest.getPassword())) {
	                return ResponseEntity.ok(member);
	            } else {
	                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
	        }
	    }

	    
	    @GetMapping(value = "/members/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<member> getMember(@PathVariable int id) {
	        Optional<member> optionalMember = memberrepository.findById(id);
	        if (optionalMember.isPresent()) {
	            member foundMember = optionalMember.get();
	            return ResponseEntity.ok(foundMember);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	 
	    
}
