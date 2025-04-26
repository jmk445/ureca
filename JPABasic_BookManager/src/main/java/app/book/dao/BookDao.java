package app.book.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;


import app.book.dto.BookDto;
import app.book.entity.Book;
import config.MyPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// book table 에 대한 crud
//bookDto(dto)와 book(entity)를 따로 하는게 바람직 -> 기능이 다르다 
public class BookDao {
	EntityManager em;
	
	public BookDao() {
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		this.em = emf.createEntityManager();
		
	}
	public void insertBook(BookDto bookDto) {
		em.getTransaction().begin();
		Book book = new Book();
		book.setBookId(bookDto.getBookId());
		book.setBookName(bookDto.getBookName());
		book.setPublisher(bookDto.getPublisher());
		book.setPrice(bookDto.getPrice());
		em.persist(book);
		
		em.getTransaction().commit();
	}
	
	public void updateBook(BookDto bookDto) {
		em.getTransaction().begin();
		Book book = em.find(Book.class, bookDto.getBookId());
		book.setBookId(bookDto.getBookId());
		book.setBookName(bookDto.getBookName());
		book.setPublisher(bookDto.getPublisher());
		book.setPrice(bookDto.getPrice());
		//em.persist(book); 주의!
		
		em.getTransaction().commit();
	}
	
	public void deleteBook(int bookId) {
		em.getTransaction().begin();
		Book book = em.find(Book.class, bookId);
		em.remove(book);		
		em.getTransaction().commit();
	}
	
	public List<BookDto> listBook(){
		List<BookDto> list = new ArrayList<>();
		
		em.createQuery("select b from Book b", Book.class)
		  .getResultList()
		  .forEach(book -> {
			  list.add(new BookDto(book.getBookId(), book.getBookName(), book.getPublisher(), book.getPrice()));
		  });
		return list;
	}
	
	public List<BookDto> listBook(String searchWord){
		List<BookDto> list = new ArrayList<>();
		
		em.createQuery("select b from Book b where b.bookName like :searchWord", Book.class)
		  .setParameter("searchWord", "%" + searchWord + "%")
		  .getResultList()		  
		  .forEach(book -> {
			  list.add(new BookDto(book.getBookId(), book.getBookName(), book.getPublisher(), book.getPrice()));
		  });
		return list;
	}
	
	public BookDto detailBook(int bookId) {
		Book book = em.find(Book.class, bookId);
		
		
		
		return new BookDto(book.getBookId(), book.getBookName(), book.getPublisher(), book.getPrice());
	}
}




















