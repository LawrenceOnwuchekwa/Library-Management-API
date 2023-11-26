package com.libraryweb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryweb.models.Book;
import com.libraryweb.services.LibraryService;

@RestController
@RequestMapping("api/v1/books")
public class LibraryController {
	
	@Autowired
	LibraryService libraryservice;
	
	@GetMapping("/")
	public List<Book> showallbooks(){
		List<Book> gotcha = libraryservice.showallbooks();
		return gotcha;
	}
	
	@PostMapping("/")
	public long addbooks(@RequestBody Book book) {
		return libraryservice.addbook(book);

}
	@GetMapping("/searchId/{searchTerm}")
	public Book searchbooks(@PathVariable(name="searchTerm") long searchTerm) {
		return libraryservice.searchbookId(searchTerm);
		
	}
	@GetMapping("/searchss/{searchTerm}")
	public List<Book> searchbooks(@PathVariable(name="searchTerm") String searchTerm) {
		return libraryservice.searchbookTitle(searchTerm);
		
	}
	

}