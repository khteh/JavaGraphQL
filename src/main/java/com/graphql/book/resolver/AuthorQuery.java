package com.graphql.book.resolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.book.model.Author;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
/*
public class AuthorQuery extends Query {//implements GraphQLQueryResolver {
	@Builder
	public AuthorQuery(AuthorRepository author, BookRepository book) {
		super(book, author);
	}
	public Iterable<Author> findAllAuthors() { return authorRepository.findAll(); }
	public long countAuthors() { return authorRepository.count(); }
}*/