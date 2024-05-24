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
@Table(name="member")
public class member {
	
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
			 
	@Column(name = "id") 
	int id;
	@Column(name = "first_name") 
	String first_name;
	
	@Column(name = "last_name") 
	String last_name;
	
	@Column(name = "age") 
	int age;
	@Column(name = "email") 
	String email;
	@Column(name = "sport") 
	String sport;
	@Column(name = "password") 
	String password;
	@OneToOne
	@JoinColumn(name = "coach_id")
	private coach coach;
	
	
	public member() {
		
	}
	
	public member(String first_name, String last_name, int age, String email, String sport,String password,coach coach) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.email = email;
		this.sport = sport;
		this.password=password;
		this.coach=coach;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSport() {
		return sport;
	}


	public void setSport(String sport) {
		this.sport = sport;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public coach getCoach() {
        return coach;
    }

    public void setCoach(coach coach) {
        this.coach = coach;
    }

}
