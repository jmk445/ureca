package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Connection 객체를 생성, 전달
// ResultSet, PreparedStatement, Connection 객체 종료 close()
public class DBManager {
    static String url = "jdbc:mysql://localhost:3306/madangdb";
    static String user = "root";
    static String pwd = "root";
    //외부에서 이 메소드를 호출화면 Connenction 객체를 만들어서 리턴해준다. 정보도 여기서 일괄적으로 관리를 해준다.   
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pwd);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return con;     
    }
    
    //releaseConnection Variable Args ...을 이용해서 줄이는 것 적용 해보는 경험 해봐도 됨(개인 적으로는 별로 ,,for...때문)
    //release Connection을 두개 세개 만들 필요가 없어짐
    //close해주는 것들 (insert delect update일 경우에만)
    public static void releaseConnection(PreparedStatement pstmt, Connection con) {
        try {
            pstmt.close();
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    //close해주는 것들 (select일 경우에만)
    public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
