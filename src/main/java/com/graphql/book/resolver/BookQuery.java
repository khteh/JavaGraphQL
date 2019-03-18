package com.graphql.book.resolver;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.book.model.Author;
import com.graphql.book.model.AuthorInput;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;

//public class BookQuery extends Query {
public class BookQuery implements GraphQLQueryResolver {
	@Autowired
	private BookRepository bookRepository;
	public List<Book> findAllBooks() { return bookRepository.findAll(); }
	public List<Book> findAllBooks(AuthorInput author) {
		return author != null ? bookRepository.findAll().stream().filter(b -> b.getAuthor().getId().equals(author.getId()) &&
				b.getAuthor().getFirstName().equals(author.getFirstName()) && b.getAuthor().getLastName().equals(author.getLastName())
				).collect(Collectors.toList())
				: Collections.emptyList();
	}
	public long countBooks() { return bookRepository.count(); }
}