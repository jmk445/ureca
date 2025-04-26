package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name="id") //column명이나 테이블명이 다를 경우 지정
//	@GeneratedValue(strategy = GenerationType.AUTO) //hibernate에 위임 (hibernate가 db에 맞게 알아서 처리)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Entity table의 auto increment 이용
//	@GeneratedValue(starategy = GenerationType.)
	private int id;
	private String name;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
