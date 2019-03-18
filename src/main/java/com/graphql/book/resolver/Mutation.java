package com.graphql.book.resolver;
import com.graphql.book.model.*;
import com.graphql.book.repository.*;
import com.graphql.book.exception.*;
import java.util.Optional;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
public class Mutation implements GraphQLMutationResolver {
	/*
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	public Mutation(AuthorRepository author, BookRepository book ) { authorRepository = author; bookRepository = book; }
	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author(firstName, lastName);
		authorRepository.save(author);
		return author;
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
	*/
}