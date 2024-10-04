package com.bookapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/book-api/v1")
public class BookController {
	
	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	@PostMapping("/admin/books")
	ResponseEntity<Void> addBook(@RequestBody Book book){
		bookService.addBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Add in one book to  db");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();		
	}  
	@PutMapping("/admin/books")
	ResponseEntity<Void>  updateBook(@RequestBody Book book){
		bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.OK).build();
	} 
	
	@DeleteMapping("/admin/books/bookid/{bookid}")
	ResponseEntity<Void>  deleteBook(@PathVariable("bookid") int bookId){
		bookService.getById(bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "delete one book from db with id "+bookId);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	} 
	
	
	@GetMapping("/user/books/bookid/{bookid}")
	ResponseEntity<Book> getById(@PathVariable("bookid") int bookId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting one book");
		headers.add("info","One book retrieved with id "+bookId);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookService.getById(bookId));
	}	
	@GetMapping("/user/books")
	ResponseEntity<List<Book>> getAll(){
		List<Book> books =  bookService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all books");
		headers.add("info","Books retrieved");
		// create userdefined headers
		ResponseEntity<List<Book>> responseEntity = 
				new ResponseEntity<List<Book>>(books, headers, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/user/books/author/{authorname}")
	ResponseEntity<List<Book>> getByAuthorContaining(@PathVariable String name) {
		List<Book> books =  bookService.getByAuthorContaining(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting books by author having "+ name);
		headers.add("timestamp",LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}
	@GetMapping("/user/books/lesserprice/{price}")
	ResponseEntity<List<Book>> getByLesserPrice(@PathVariable("price")double price) {
		List<Book> books =  bookService.getByLesserPrice(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting books by price less than "+ price);
		headers.add("timestamp",LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.OK).body(books);
		
	}
	@GetMapping("/user/books/author/{author}/category/{category}")
	ResponseEntity<List<Book>> getByAuthorCategory(@PathVariable("author")String author,@PathVariable("category")String category) {
		List<Book> books =  bookService.getByAuthorCategory(author, category);
		return ResponseEntity.ok(books);
	}
	//add requestparam
	@GetMapping("/user/books/dates")
	ResponseEntity<List<Book>> getByPubDateBetween(@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate) {
		List<Book> books =  bookService.getByPubDateBetween(startdate, enddate);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting books by date between" );
		headers.add("timestamp",LocalDateTime.now().toString());
		return ResponseEntity.status(200).body(books);
	}
	
	//add requestparam
	@GetMapping("/books/authprice")
	ResponseEntity<List<Book>> getByAuthPrice(@RequestParam String author,@RequestParam("price")  double price) {
		return ResponseEntity.status(200).body(bookService.getByAuthPrice(author, price));
	}
	@GetMapping("/books/greaterprice/{price}")
	ResponseEntity<List<Book>> getByPriceGreater(@PathVariable("price") double price) {
		List<Book> books =  bookService.getByPriceGreater(price);
		return ResponseEntity.status(200).body(books);
	}
	
	
    

	

}
