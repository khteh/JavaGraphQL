package com.graphql.book.resolver;
import com.graphql.book.repository.*;
import com.graphql.book.model.*;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
public class Query implements GraphQLQueryResolver {
	/*
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	public Query(AuthorRepository author, BookRepository book) { authorRepository = author; bookRepository = book; }
	public Iterable<Book> findAllBooks() { return bookRepository.findAll(); }
	public Iterable<Author> findAllAuthors() { return authorRepository.findAll(); }
	public long countBooks() { return bookRepository.count(); }
	public long countAuthors() { return authorRepository.count(); }
	*/
}