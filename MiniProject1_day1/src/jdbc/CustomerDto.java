package jdbc;

//Dto : data transfer object 
//즉, 데이터를 나르는 객체
//메소드의 파라미터로 사용,메소드의 리턴 결과로도 사용됨 (다목적)
//이쁘게 받겠다는 것.
//테이블의 row 한 건 한 건을 dto 객체 하나하나에 대응하겠다.
public class CustomerDto {
	private int custId;
	private String address;
	private String name;
	private String phone;

	public CustomerDto(int custId, String address, String phone) {
		super();
		this.custId = custId;
		this.address = address;
		this.phone = phone;
	}
	
	
	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}


	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	


	@Override
	public String toString() {
		return "CustomerDto [custId=" + custId + ", address=" + address + ", name=" + name + ", phone=" + phone + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
