package com.libraryweb.data;

import java.util.List;

import com.libraryweb.models.Book;

public interface DataLibraryInterface<T,U,X> {
	List<T> searchbookTitle(X title);
	T searchbookId(U id);
	boolean updatebook(U id, T book);
	long addbook(T book);
	boolean deletebookId(U id);
	boolean deletebookTitle(X title);
	List<T> showallbooks();
}
