package com.libraryweb.data;

import java.util.List;

import com.libraryweb.models.Book;

public interface DataLibraryInterface<T> {
	List<Book> searchbookTitle(T title);
	Book searchbookId(T id);
	boolean updatebook(T id, T book);
	long addbook(Book book);
	boolean deletebookId(T id);
	boolean deletebookTitle(T title);
	List<Book> showallbooks();

}
