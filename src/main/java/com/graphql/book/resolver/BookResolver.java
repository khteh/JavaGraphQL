package com.graphql.book.resolver;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.graphql.book.model.*;
import com.graphql.book.repository.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
public class BookResolver implements GraphQLResolver<Book> {
	@Autowired
	private AuthorRepository repository;
	public Optional<Author> getAuthor(Book book) {return repository.findById(book.getAuthor().getId());}
}