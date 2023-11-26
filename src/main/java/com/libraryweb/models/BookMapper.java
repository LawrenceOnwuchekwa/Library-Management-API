package com.libraryweb.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapper implements RowMapper<Book> {
	

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		Book bulk = new Book(rs.getLong("IdBook"), rs.getString("Title"), rs.getString("Author"),
				rs.getString("Isbn"), rs.getString("Genre"));
		return bulk;
	}

}