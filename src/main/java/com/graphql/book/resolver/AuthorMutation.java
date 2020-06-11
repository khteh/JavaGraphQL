package com.graphql.book.resolver;

import java.util.Optional;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.book.exception.BookNotFoundException;
import com.graphql.book.model.Author;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;
import lombok.Builder;
/*
public class AuthorMutation extends Mutation {//implements GraphQLMutationResolver {
	@Builder
	public AuthorMutation(AuthorRepository author, BookRepository book) {
		super(book, author);
	}	
	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author(firstName, lastName);
		authorRepository.save(author);
		return author;
	}
}*/