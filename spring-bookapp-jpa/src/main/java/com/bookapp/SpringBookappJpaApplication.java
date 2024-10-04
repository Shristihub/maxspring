package com.bookapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJpaApplication.class, args);
	}
	
	@Autowired
	private IBookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		Book book =  new Book("Azure","Kevin",1500,"Tech",LocalDate.of(2001, 12, 1),"Eagle Publishers");
		bookService.addBook(book);
		
////		bookService.deleteBook(2);
//		Book nbook = bookService.getById(102);
//		nbook.setCategory("selfhelp");
//		bookService.updateBook(nbook);
//		System.out.println();
		bookService.getAll().forEach(System.out::println);
//		
//		bookService.getByPriceGreater(800).forEach(System.out::println);
//		System.out.println();
//		bookService.getByPublisherName("Cuckoo publishers").forEach(System.out::println);
		System.out.println();
//		bookService.getByPriceRange(800, 1200).forEach(System.out::println);
		
	}

}
