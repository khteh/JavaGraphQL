package com.graphql.book.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.book.model.Author;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;

//public class AuthorQuery extends Query {
public class AuthorQuery implements GraphQLQueryResolver {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookQuery bookQuery;
	public List<Author> findAllAuthors() { return authorRepository.findAll(); }
	public long countAuthors() { return authorRepository.count(); }
}