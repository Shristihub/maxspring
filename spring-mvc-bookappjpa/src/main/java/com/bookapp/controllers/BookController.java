package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@Controller
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String homePage(Model model) {
//		// call service layer to get all books
		List<Book> bookList = bookService.getAll();
//		// add the books to model and sent to homepage
		model.addAttribute("books", bookList);
		return "home";
	}
	
	@RequestMapping("/search")
	public String searchByAuthor(@RequestParam("author")String author,Model model) {
		// call service layer to getbooks by author
		List<Book> bookList = bookService.getByAuthorContaining(author);
		// add the books to model and sent to homepage
		model.addAttribute("books", bookList);
		return "home";
	}
	
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addBook(Book book, Model model) {
		// call the addBook method of service layer
		bookService.addBook(book);
		model.addAttribute("message", "Book added succesfully");
		return "admin";
	}
	
	@RequestMapping(value = "/deletebook")
	public String deleteBook(@RequestParam("bookId") int bookId, Model model) {
		// call the deleteBook method of service layer
		bookService.deleteBook(bookId);
		model.addAttribute("message", "Book deleted succesfully");
		return "admin";
	}
	
	@RequestMapping(value = "/updateform")
	public String getById(@RequestParam("bookId") int bookId, Model model) {
		// call the getById method of service layer
		Book book = bookService.getById(bookId);
		model.addAttribute("book", book);
		return "updateform";
	}
	
	@RequestMapping(value = "/updatebook", method = RequestMethod.POST)
	public String updateBook(Book book, Model model) {
		// call the updateBook method of service layer
		bookService.updateBook(book);
		model.addAttribute("message", "Book updated succesfully");
		return "admin";
	}
}
