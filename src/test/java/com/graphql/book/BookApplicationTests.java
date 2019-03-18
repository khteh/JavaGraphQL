package com.graphql.book;
import static org.junit.Assert.assertNotNull;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.graphql.book.model.Author;
import com.graphql.book.model.AuthorInput;
import com.graphql.book.model.Book;
import com.graphql.book.resolver.AuthorMutation;
import com.graphql.book.resolver.AuthorQuery;
import com.graphql.book.resolver.BookMutation;
import com.graphql.book.resolver.BookQuery;

@RunWith(SpringRunner.class)
//@SpringBootTest
// org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'serverEndpointExporter' defined in class path resource [com/oembedler/moon/graphql/boot/GraphQLWebAutoConfiguration.class]:
// https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/113
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookApplicationTests {
	@Autowired
	AuthorQuery authorQuery;
	@Autowired
	BookQuery bookQuery;
	@Test
	public void contextLoads() {
		/*
		AuthorQuery authorQuery = new AuthorQuery();
		AuthorMutation authorMutation = new AuthorMutation();
		assertNotNull("", authorMutation);
		BookQuery bookQuery = new BookQuery();
		BookMutation bookMutation = new BookMutation();
		assertNotNull("", bookMutation);
		*/
		assertNotNull("authorQuery is null!", authorQuery);
		assertNotNull("bookQuery is null!", bookQuery);
		
		List<Author> authors = authorQuery.findAllAuthors();
		assertNotNull("authors is null!", authors);
		assertTrue("", authors.size() >= 1);
		assertNotNull("authors[0] is null!", authors.get(0));
		
		List<Book> books = bookQuery.findAllBooks();
		assertNotNull("books is null!", books);
		assertTrue("", books.size() >= 1);
		assertNotNull("books[0] is null!", books.get(0));
		
		AuthorInput authorInput = new AuthorInput(authors.get(0));
		books = bookQuery.findAllBooks(authorInput);
		assertEqual()
		assertTrue("", books.size() == 1);
		assertNotNull("books[0] is null!", books.get(0));
	}
}