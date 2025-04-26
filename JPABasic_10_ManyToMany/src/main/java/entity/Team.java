package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//ManyToMany의 Owning Entity, 양방향
@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
//	@ManyToMany
//	@JoinTable(
//		name="teams_users",
//		joinColumns=@JoinColumn(name="team_id"),
//		inverseJoinColumns=@JoinColumn(name="user_id")
//	)	
//	private List<User> users; //User와 연결돼야함(mappedBy)

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="teams_users",
			joinColumns=@JoinColumn(name="team_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)	
	private List<User> users; //User와 연결돼야함(mappedBy)
	
	
//	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
//	@JoinTable(
//			name="teams_users",
//			joinColumns=@JoinColumn(name="team_id"),
//			inverseJoinColumns=@JoinColumn(name="user_id")
//			)	
//	private List<User> users; //User와 연결돼야함(mappedBy)
	
	
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name  + "]";
	} 
	
	
}
