package com.libraryweb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryweb.data.LibraryDataServiceforRepository;
import com.libraryweb.data.LibraryRepositoryInterface;
import com.libraryweb.models.Book;
import com.libraryweb.models.BookEntity;
import com.libraryweb.services.LibraryService;

@RestController
@RequestMapping("api/v1/books")
public class LibraryController {
	
	@Autowired
	LibraryService libraryservice;
	
	@Autowired
	LibraryDataServiceforRepository serve;
	
	@GetMapping("/")
	public List<BookEntity> showallbooks(){
		List<BookEntity> gotcha = serve.showallbooks();
		return gotcha;
	}
	@PutMapping("/updateId/{id}")
	public boolean updatebooks(@RequestBody BookEntity book,@PathVariable(name="id") long id) {
		return serve.updatebook(id, book);
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
	@DeleteMapping("/deleteId/{id}")
	public boolean deletebooksId(@PathVariable(name="id") long id) {
		return libraryservice.deletebookId(id);
	}
	@DeleteMapping("/deleteTitle/{id}")
	public boolean deletebooksTitle(@PathVariable(name="id") String id) {
		return libraryservice.deletebookTitle(id);
	}

}
