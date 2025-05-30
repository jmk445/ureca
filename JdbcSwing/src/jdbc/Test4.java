package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// Statement 사용
// CRUD 를 메소드화 - url, user, pwd 를 static
//   메소드내에서 Connection, Statement, ResutSet 객체화
//   메소드내에서 예외 처리

//Statement -> prepraedStatement 전환
//하드 코딩된 value -> 메소드의 parameter
//Dto -> select 에 적용

//DBManager Utility Class 사용
// - Connection 객체 생성 및 리턴
// - close 작업들
// - 전역 변수 삭제 (url 등)
// - insert , update, delete가 작업 결과(int)를 return 하도록 변경
//각 메소드에서 Connection 객체등 관련 Auto Closable 처리??

public class Test4 {
  
    public static void main(String[] args) {    	
	    System.out.println(insertCustomer(7, "손흥민", "대한민국 부산", "010-1111-1111"));
	    System.out.println(updateCustomer(7,"대한민국 부산 개금동"));
	    System.out.println(deleteCustomer(7));
	    List<CustomerDto> list = listCustomer();
		
		for(CustomerDto dto : list) {
			System.out.println(dto);
		}
		CustomerDto dto = detailCustomer(2);
		System.out.println(dto);
      
       
    }
    static int insertCustomer(int custId, String name, String address, String phone) {
        Connection con = null;
        PreparedStatement pstmt = null;
        //prepared인 경우 paramter로 넘겨주기 위해 위로 올라온다 sql문이
        String insertSql = "insert into customer values ( ?, ?, ?, ? ); "; //value 부분을 ?로 대체        
        int ret = -1;
        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(insertSql); //물음표가 채워진 sql을 보내준다.
            //?로 넘겨주면 이 구문을 보내준 순간 parsing을 미리 해두고 ? 값을 기다리고 있는다.
            //"1,2..은 몇번째 물음표인가"
            pstmt.setInt(1,custId);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, phone);
            ret = pstmt.executeUpdate(); //insertsql을 넘겨주면 안된다.
            System.out.println(ret);
            
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DBManager.releaseConnection(pstmt,con);
        }
        
        return ret;
    }
    
    static int updateCustomer(int custId, String address) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int ret = -1;
        String updateSql = "update customer set address = ? where custid = ?; ";
        try {
        	con = DBManager.getConnection();
            pstmt = con.prepareStatement(updateSql);
            
            pstmt.setString(1, address);
            pstmt.setInt(2, custId);
            ret = pstmt.executeUpdate();
            System.out.println(ret);
            
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
        	DBManager.releaseConnection(pstmt,con);
        }
        return ret;
    }
    
    static int deleteCustomer(int custid) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String deleteSql = "delete from customer where custid = ?; ";
        int ret = -1;
        try {
        	con = DBManager.getConnection();
            pstmt = con.prepareStatement(deleteSql);            

            pstmt.setInt(1, custid);
            ret = pstmt.executeUpdate();
            System.out.println(ret);
            
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
        	DBManager.releaseConnection(pstmt,con);
        }
        return ret;
    }
    
    static List<CustomerDto> listCustomer() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String selectSql = "select * from customer; ";
        List<CustomerDto> list = new ArrayList<>();        
        try {
        	con = DBManager.getConnection();
            pstmt = con.prepareStatement(selectSql);            
                        
            rs = pstmt.executeQuery();
	        while(rs.next()) { // row 이동
	        	//각 row를 customerDto 객체에 담아서 만들고, ArrayList에 담는다.
	        	CustomerDto dto = new CustomerDto();
	        	dto.setCustId(rs.getInt("custid"));
	        	dto.setName(rs.getString("name"));
	        	dto.setAddress(rs.getString("address"));
	        	dto.setPhone(rs.getString("phone"));	        			
	            list.add(dto);
	        	System.out.println(rs.getInt("custid") + " | " + rs.getString("name")+ " | " + rs.getString("address")+ " | " + rs.getString("phone"));	        		        	
	        }
            
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
        	DBManager.releaseConnection(rs, pstmt,con);
        }
        
        return list;
    }
    
    static CustomerDto detailCustomer(int custId) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        CustomerDto dto = null;
        String selectSql = "select * from customer where custid = ?; ";
        try {
        	con = DBManager.getConnection();
            pstmt = con.prepareStatement(selectSql);            
            pstmt.setInt(1, custId);
            rs = pstmt.executeQuery();
        if(rs.next()) { 
          dto = new CustomerDto();
          dto.setCustId(rs.getInt("custid"));
      	  dto.setName(rs.getString("name"));
      	  dto.setAddress(rs.getString("address"));
      	  dto.setPhone(rs.getString("phone"));	        			          
        }
            
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
        	DBManager.releaseConnection(rs, pstmt,con);
        }
        
        return dto;
    }
}