package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Lecture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	private String name;
	

	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)  
	private Professor professor;
	

	@Override
	public String toString() {
		return "Lecture [id=" + id + ", name=" + name + ", professor=" + professor + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
		
}
