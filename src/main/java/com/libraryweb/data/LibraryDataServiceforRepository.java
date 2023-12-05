package com.libraryweb.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.libraryweb.models.Book;
import com.libraryweb.models.BookEntity;

@Service
public class LibraryDataServiceforRepository implements DataLibraryInterface<BookEntity, Long, String> {
	
	@Autowired
	LibraryRepositoryInterface libraryRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	public LibraryDataServiceforRepository(DataSource datasource) {
		this.jdbcTemplate= new JdbcTemplate(datasource);
	}

	@Override
	public List<BookEntity> searchbookTitle(String title) {
		return null;
	}
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public BookEntity searchbookId(Long id) {
		BookEntity entity = libraryRepository.findById(id).orElse(null);
		
//		Book book = modelMapper.map(entity, Book.class);
		return entity;
	}

	@Override
	public boolean updatebook(Long id, BookEntity book) {
		// TODO Auto-generated method stub
		BookEntity data =libraryRepository.findById(id).get();
		libraryRepository.save(book);
		
		return true;
		
				
	}

	@Override
	public long addbook(BookEntity book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deletebookId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletebookTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	// This is a service that shows all books available in the Library.
	public List<BookEntity> showallbooks() {
		//This fetches all of the records in the book relation
		Iterable<BookEntity> bookEntity = libraryRepository.findAll();
		
		List<BookEntity> book = new ArrayList<>();
		
		for(BookEntity item: bookEntity) { 
			book.add(modelMapper.map(item,BookEntity.class)); 
		
		 }
		return book;
	}

}
