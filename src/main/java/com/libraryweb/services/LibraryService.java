package com.libraryweb.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.libraryweb.data.DataLibraryInterface;
import com.libraryweb.models.Book;
import com.libraryweb.models.BookMapper;

@Repository
public class LibraryService implements DataLibraryInterface<Book,Long,String>{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	BookMapper bookMapper;

	@Override
	public List<Book> searchbookTitle(String title) {
		// TODO Auto-generated method stub
		List<Book> result = jdbcTemplate.query("SELECT * FROM BOOK WHERE Title LIKE ? ", bookMapper, "%" + title + "%");
		return result;
		
	}

	@Override
	public Book searchbookId(Long id) {
		
		List<Book> result = jdbcTemplate.query("SELECT * FROM BOOK WHERE IdBook = ?", bookMapper, id);
		
		// TODO Auto-generated method stub
		if(result.size()>0) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public boolean updatebook(Long id, Book book) {
		long result = jdbcTemplate.update("UPDATE BOOK SET IdB ook = ?, Title = ?, Author = ?, Isbn = ?, Genre = ? WHERE Idbook = ?",
				book.getId(),
				book.getTitle(),
				book.getAuthor(),
				book.getIsbn(),
				book.getGenre(),
				(long)id
				);
		if(result>0) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long addbook(Book book) {
		// TODO Auto-generated method stub
		long result = jdbcTemplate.update("INSERT INTO BOOK (IdBook,Title,Author,Isbn,Genre) VALUES (?,?,?,?,?)",
				book.getId(),
				book.getTitle(),
				book.getAuthor(),
				book.getIsbn(),
				book.getGenre()
				);
		return result;
	}

	@Override
	public boolean deletebookId(Long id) {
		
		long result = jdbcTemplate.update("DELETE FROM BOOK WHERE IdBook = ? ", id);
		// TODO Auto-generated method stub
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deletebookTitle(String title) {
		// TODO Auto-generated method stub
		long result = jdbcTemplate.update("DELETE FROM BOOK WHERE Title = ? ",title);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Book> showallbooks() {
		// TODO Auto-generated method stub
		List<Book> results = jdbcTemplate.query("SELECT * FROM BOOK", bookMapper);
		
		return results;
	}

}
