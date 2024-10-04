package com.bookapp.model;

import java.awt.List;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// use JPQL
@NamedQuery(name = "findBooksByPub", query="from Book b where b.publisher=?1") //this is JPQL
@NamedNativeQuery(name="findByPriceBetween",
                  query="select * from book where cost between ?1 and ?2",
                  resultClass = Book.class) // this is sql

public class Book {

	@Column(length = 30)
	private String title;
	@Column(length = 20)
	private String author;
	@Column(name="cost")
	private double price;
	@Id
	@GeneratedValue
	private Integer bookId;
	@Column(length = 20)
	private String category;
	@Column(name="published_date")
	private LocalDate publishedDate;
	@Column(length = 30)
	private String publisher;
	
	public Book(String title, String author, double price, String category, LocalDate publishedDate, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
		this.publishedDate = publishedDate;
		this.publisher = publisher;
	}
	
	
	
	
}
