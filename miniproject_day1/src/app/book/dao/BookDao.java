package app.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.book.common.DBManager;
import app.book.dto.BookDto;

// book table 에 대한 crud
public class BookDao {

	public int insertBook(BookDto bookDto) {
		int ret = -1;
		String sql = "insert into book values ( ?, ?, ?, ? ); ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bookDto.getBookId());
			pstmt.setString(2, bookDto.getBookName());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setInt(4, bookDto.getPrice());
			
			ret = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int updateBook(BookDto bookDto) {
		int ret = -1;		
		String sql = "update book set bookname = ?, publisher = ?, price = ? where bookid = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bookDto.getBookName());
			pstmt.setString(2, bookDto.getPublisher());
			pstmt.setInt(3, bookDto.getPrice());
			pstmt.setInt(4, bookDto.getBookId());
			
			ret = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int deleteBook(int bookId) {
		int ret = -1;
		String sql = "delete from book where bookid = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, bookId);
			
			ret = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public List<BookDto> listBook(){
		List<BookDto> list = new ArrayList<>();
		
		String sql = "select * from book; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDto bookDto = new BookDto();
				bookDto.setBookId(rs.getInt("bookid"));
				bookDto.setBookName(rs.getString("bookname"));
				bookDto.setPublisher(rs.getString("publisher"));
				bookDto.setPrice(rs.getInt("price"));
				list.add(bookDto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return list;
	}
	
	public List<BookDto> listBook(String searchWord){
		List<BookDto> list = new ArrayList<>();
		
		String sql = "select * from book where bookname like ?; "; // % 사용 X
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDto bookDto = new BookDto();
				bookDto.setBookId(rs.getInt("bookid"));
				bookDto.setBookName(rs.getString("bookname"));
				bookDto.setPublisher(rs.getString("publisher"));
				bookDto.setPrice(rs.getInt("price"));
				list.add(bookDto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return list;
	}
	
	public BookDto detailBook(int bookId) {
		BookDto book = null;
		
		String sql = "select * from book where bookid = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bookId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new BookDto();
				book.setBookId(rs.getInt("bookid"));
				book.setBookName(rs.getString("bookname"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return book;
	}
}




















