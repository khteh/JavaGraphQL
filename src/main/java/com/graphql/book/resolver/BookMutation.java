package com.graphql.book.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.book.exception.BookNotFoundException;
import com.graphql.book.model.Author;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
/*
public class BookMutation extends Mutation {//implements GraphQLMutationResolver {
	@Builder
	public BookMutation(AuthorRepository author, BookRepository book) {
		super(book, author);
	}	
	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
		Book book = new Book(title, isbn, pageCount != null? pageCount : 0, new Author(authorId));
		bookRepository.save(book);
		return book;
	}
	public boolean deleteBook(Long id) { bookRepository.deleteById(id); return true; }
	public Book updateBookPageCount(Long id, Integer count) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isEmpty())
			throw new BookNotFoundException("The book to be updated was not found!", id);
		book.get().setPageCount(count);
		bookRepository.save(book.get());
		return book.get();
	}
}*/