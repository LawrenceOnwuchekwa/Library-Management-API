package com.libraryweb.data;


import org.springframework.data.repository.CrudRepository;

import com.libraryweb.models.BookEntity;

public interface LibraryRepositoryInterface extends CrudRepository<BookEntity, Long> {

	


}
	