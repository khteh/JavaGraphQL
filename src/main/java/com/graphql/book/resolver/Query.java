package com.graphql.book.resolver;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.book.model.Author;
import com.graphql.book.model.AuthorInput;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {
	private static final Log log = LogFactory.getLog(Query.class);
	protected BookRepository bookRepository;
	protected AuthorRepository authorRepository;
	public Iterable<Book> findAllBooks() {
		log.info(Query.class.getName() + ".findAllBooks()");
		return bookRepository.findAll(); 
	}
	public List<Book> findAllBooks(AuthorInput author) {
		return author != null ?  StreamSupport.stream(bookRepository.findAll().spliterator(), false).filter(b -> b.getAuthor().getId().equals(author.getId()) &&
				b.getAuthor().getFirstName().equals(author.getFirstName()) && b.getAuthor().getLastName().equals(author.getLastName())
				).collect(Collectors.toList())
				: Collections.emptyList();
	}
	public long countBooks() { return bookRepository.count(); }
	public Iterable<Author> findAllAuthors() { return authorRepository.findAll(); }
	public long countAuthors() { return authorRepository.count(); }	
}