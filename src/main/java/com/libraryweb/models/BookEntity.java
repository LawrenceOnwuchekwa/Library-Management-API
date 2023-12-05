package com.libraryweb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//BookEntity is based on Book model
//Its purpose is to connnect the Book Model to the Book table in the database



@Table("Book")  //Mapping the book class to the database table


public class BookEntity {
	

	@Id
	@Column("IdBook")
	private Long id;
	
	@Column("Title")
	private String title;
	
	@Column("Author")
	private String author;
	
	@Column("Isbn")
	private String isbn;
	
	@Column("Genre")
	private String genre;

	
	public BookEntity(Long id, String title, String author, String isbn, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.genre = genre;
	}

	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", genre=" + genre
				+ "]";
	}
	
	
	
	

}
