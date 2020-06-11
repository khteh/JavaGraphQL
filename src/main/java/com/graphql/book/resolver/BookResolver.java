package com.graphql.book.resolver;
import org.springframework.stereotype.Component;
import java.util.Optional;
import com.graphql.book.model.*;
import com.graphql.book.repository.*;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class BookResolver implements GraphQLResolver<Book> {
	private AuthorRepository repository;
	public BookResolver(AuthorRepository repo) { repository = repo; }
	public Optional<Author> getAuthor(Book book) {return repository.findById(book.getAuthor().getId());}
}