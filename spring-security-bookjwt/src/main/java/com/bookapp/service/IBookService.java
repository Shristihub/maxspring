package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {

	// admin 
		void addBook(Book book);  // create
		void updateBook(Book book); //update
		void deleteBook(int bookId); //delete
		Book getById(int bookId) throws IdNotFoundException; // retrieve
		
		// User
		List<Book> getAll(); // retrieve
		List<Book> getByAuthorContaining(String name) throws BookNotFoundException;
		List<Book> getByLesserPrice(double price) throws BookNotFoundException;
		List<Book> getByAuthorCategory(String author,String category) throws BookNotFoundException;
		List<Book> getByPubDateBetween(String startdate,String enddate) throws BookNotFoundException;
		List<Book> getByAuthPrice(String author, double price) throws BookNotFoundException;
		// native
		List<Book> getByPriceGreater(double price) throws BookNotFoundException;
		
		// named
		List<Book> getByPublisherName(String pub);
		List<Book> getByPriceRange(double startprice,double endprice);


}
