package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

//Passport  <-> Person (O) (Person < -> Passport (O)), 양방향!연관관계

@Entity
public class Passport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String number;
	
	//양방향이기 때문에 추가 
	//Ownership을 가진 Entity인 Person의 passport와 연계, 
	//passport table person 관련 컬럼이 만들어지지 않는다.	
	@OneToOne(mappedBy="passport", fetch=FetchType.LAZY,cascade=CascadeType.PERSIST) 
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]"; //toString에 Person 포함 X ( 순환 구조 방지...? )
	}
}
