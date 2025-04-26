package entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	private String content;
	

//	@ManyToOne
//	private Post post;
	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	private Post post;
	
	@ManyToOne(fetch=FetchType.LAZY)	
	private Post post;
	
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	//상호 참조 제거한 버전
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content+ "]";
	}
			
	
	
	
	
}
