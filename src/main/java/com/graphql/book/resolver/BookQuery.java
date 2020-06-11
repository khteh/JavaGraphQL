package com.graphql.book.resolver;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.graphql.book.model.AuthorInput;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;

import lombok.Builder;
/*
public class BookQuery extends Query {//implements GraphQLQueryResolver {
	private static final Log log = LogFactory.getLog(BookQuery.class);
	@Builder
	public BookQuery(AuthorRepository author, BookRepository book) 
	{
		super(book, author);
	}
	public Iterable<Book> findAllBooks() {
		log.info(BookQuery.class.getName() + ".findAllBooks()");
		return bookRepository.findAll(); 
	}
	public List<Book> findAllBooks(AuthorInput author) {
		return author != null ? bookRepository.findAll().stream().filter(b -> b.getAuthor().getId().equals(author.getId()) &&
				b.getAuthor().getFirstName().equals(author.getFirstName()) && b.getAuthor().getLastName().equals(author.getLastName())
				).collect(Collectors.toList())
				: Collections.emptyList();
	}
	public long countBooks() { return bookRepository.count(); }
}*/