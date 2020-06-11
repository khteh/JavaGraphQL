package com.graphql.book.resolver;
import com.graphql.book.model.*;
import com.graphql.book.repository.*;
import com.graphql.book.exception.*;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.AllArgsConstructor;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {
	private static final Log log = LogFactory.getLog(Mutation.class);
	protected BookRepository bookRepository;
	protected AuthorRepository authorRepository;
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
	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author(firstName, lastName);
		authorRepository.save(author);
		return author;
	}	
}