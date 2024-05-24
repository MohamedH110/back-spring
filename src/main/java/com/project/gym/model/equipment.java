package com.project.gym.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="equipment")

public class equipment {

	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	@Column(name = "number") 
	int number;
	 
	@Column(name = "name")  
	String name;
	
	@Column(name = "category") 
	String category;
	
	@Column(name = "availability") 
	boolean availability;
	
	@Column(name = "weight") 
	double weight;
	 @OneToOne
	 @JoinColumn(name = "coach_id")
	    private coach coach;
	
	 public equipment() {
	        
	    }
	public equipment(String name, String category, boolean availability, double weight,coach coach) {
	    super();
	    this.name = name;
	    this.category = category;
	    this.availability = availability;
	    this.weight = weight;
	    this.coach = coach;
	}



	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public boolean isAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}
	public coach getCoach() {
        return coach;
    }

    public void setCoach(coach coach) {
        this.coach = coach;
    }
	
	
	
}
