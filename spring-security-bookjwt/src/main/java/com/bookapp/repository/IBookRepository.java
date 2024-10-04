package com.bookapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	//derived query
	// findBy<propertyname>
	// getBy
	//readBy
	
	List<Book> findByAuthorContains(String name);
	List<Book> findByAuthorAndCategory(String author,String category );
	List<Book> findByPriceLessThan(double price );
	List<Book> findByPublishedDateBetween(LocalDate startdate, LocalDate enddate  );
	
//	 custom query - can have any method name
	@Query("from Book b where b.author=?1 and b.price=?2 ")
	List<Book> getByAuthPrice(String author, double price);
	
	@Query("from Book b where b.category=?1")
	List<Book> findBooksByCat(String category);
	
	//native query - write query in sql, using table name and column names ONLY
	@Query(value="select * from book where cost>?1",nativeQuery = true)	
	List<Book> findBookByPriceGreater(double price);
	
	//named query. this is created in Book class
	@Query(name="findBooksByPub")
	List<Book> getByPublisherName(String pub);
	
	@Query(name = "findByPriceBetween",nativeQuery = true)
	List<Book> findByPriceRange(double startprice, double endprice);
	
//	void updateBook(int bookId,double price)
}






