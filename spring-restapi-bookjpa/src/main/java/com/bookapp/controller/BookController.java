package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

//@RestController
@RequestMapping("/book-api/v1")
public class BookController {
	
	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	@PostMapping("/books")
	void addBook(@RequestBody Book book){
		bookService.addBook(book);
		
	}  
	@PutMapping("/books")
	void updateBook(@RequestBody Book book){
		bookService.addBook(book);
	} 
	
	@DeleteMapping("/books/bookid/{bookid}")
	void deleteBook(@PathVariable("bookid") int bookId){
		bookService.getById(bookId);
	} 
	
	
	@GetMapping("/books/bookid/{bookid}")
	Book getById(@PathVariable("bookid") int bookId) {
		return bookService.getById(bookId);
	}	

	@GetMapping("/books")
	List<Book> getAll(){
		return bookService.getAll();
	} 
	
	@GetMapping("/books/author/{authorname}")
	List<Book> getByAuthorContaining(@PathVariable("authorname") String name) {
		return bookService.getByAuthorContaining(name);
	}
	@GetMapping("/books/lesserprice/{price}")
	List<Book> getByLesserPrice(@PathVariable("price")double price) {
		return bookService.getByLesserPrice(price);
	}
	@GetMapping("/books/author/{author}/category/{category}")
	List<Book> getByAuthorCategory(@PathVariable("author")String author,@PathVariable("category")String category) {
		return bookService.getByAuthorCategory(author, category);
	}
	//add requestparam
	@GetMapping("/books/dates")
	List<Book> getByPubDateBetween(@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate) {
		return bookService.getByPubDateBetween(startdate, enddate);
	}
	
	//add requestparam
	@GetMapping("/books/authprice")
	List<Book> getByAuthPrice(@RequestParam("author") String author,@RequestParam("price")  double price) {
		return bookService.getByAuthPrice(author, price);
	}
	@GetMapping("/books/greaterprice/{price}")
	List<Book> getByPriceGreater(@PathVariable("price") double price) {
		return bookService.getByPriceGreater(price);
	}
	
	
	

}
