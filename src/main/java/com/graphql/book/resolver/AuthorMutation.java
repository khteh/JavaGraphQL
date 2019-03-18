package com.graphql.book.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.book.exception.BookNotFoundException;
import com.graphql.book.model.Author;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;

//public class AuthorMutation extends Mutation {
public class AuthorMutation implements GraphQLMutationResolver {
	@Autowired
	private AuthorRepository authorRepository;
	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author(firstName, lastName);
		authorRepository.save(author);
		return author;
	}
}