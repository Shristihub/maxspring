package com.bookapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	private IBookRepository bookRepository;
	
	
	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		return bookRepository.findById(bookId)
				.orElseThrow(()->new BookNotFoundException("Invalid id"));
	}

	@Override
	public List<Book> getAll() {
		Sort sort = Sort.by("author","title");
		Pageable page= Pageable.ofSize(2);
//		return bookRepository.findAll(sort);
	    return bookRepository.findAll(page).toList();
	}

	@Override
	public List<Book> getByAuthorContaining(String author) throws BookNotFoundException {
		return bookRepository.findByAuthorContains(author);
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		return bookRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Book> getByAuthorCategory(String author, String category) throws BookNotFoundException {
		return bookRepository.findByAuthorAndCategory(author, category);
	}

	@Override
	public List<Book> getByPubDateBetween(String startdate,String enddate) throws BookNotFoundException {
		LocalDate start = LocalDate.parse(startdate);
		LocalDate end = LocalDate.parse(enddate);
		return bookRepository.findByPublishedDateBetween(start, end);
	}

	@Override
	public List<Book> getByAuthPrice(String author, double price) throws BookNotFoundException {
		return null;
	}

	@Override
	public List<Book> getByPriceGreater(double price) throws BookNotFoundException {
		return bookRepository.findBookByPriceGreater(price);
	}

	@Override
	public List<Book> getByPublisherName(String pub) {
		return bookRepository.getByPublisherName(pub);
	}

	@Override
	public List<Book> getByPriceRange(double startprice, double endprice) {
		return bookRepository.findByPriceRange(startprice, endprice);
	}

}
