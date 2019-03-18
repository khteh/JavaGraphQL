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

//public class BookMutation extends Mutation {
public class BookMutation implements GraphQLMutationResolver {
	@Autowired
	private BookRepository bookRepository;
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
}