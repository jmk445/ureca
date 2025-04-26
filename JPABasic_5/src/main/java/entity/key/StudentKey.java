package entity.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
	The composite primary key class must be public.
It must have a no-args constructor.
It must define the equals() and hashCode() methods.
It must be Serializable.
*/
@Embeddable //다른 entity 클래스의 field로 사용 
public class StudentKey implements Serializable {
	
	@Override
	public String toString() {
		return "StudentKey [code=" + code + ", number=" + number + "]";
	}
	private static final long serialVersionUID = 1L;
	private String code;	
	private int number;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentKey other = (StudentKey) obj;
		return Objects.equals(code, other.code) && number == other.number;
	}
	
	
	

}
