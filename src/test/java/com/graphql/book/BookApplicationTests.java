package com.graphql.book;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.graphql.book.model.Author;
import com.graphql.book.model.AuthorInput;
import com.graphql.book.model.Book;
import com.graphql.book.resolver.Query;

@RunWith(SpringRunner.class)
//@SpringBootTest
// org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'serverEndpointExporter' defined in class path resource [com/oembedler/moon/graphql/boot/GraphQLWebAutoConfiguration.class]:
// https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/113
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookApplicationTests {
	//@Autowired
	//AuthorQuery authorQuery;
	//@Autowired
	//BookQuery bookQuery;
	@Autowired
	Query query;
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
		assertNotNull("Query is null!", query);
		
		List<Author> authors = StreamSupport.stream(query.findAllAuthors().spliterator(), false).collect(Collectors.toList());
		assertNotNull("authors is null!", authors);
		assertTrue("", authors.size() >= 1);
		assertNotNull("authors[0] is null!", authors.get(0));
		
		List<Book> books = StreamSupport.stream(query.findAllBooks().spliterator(), false).collect(Collectors.toList());
		assertNotNull("books is null!", books);
		assertTrue("", books.size() >= 1);
		assertNotNull("books[0] is null!", books.get(0));
		
		AuthorInput authorInput = new AuthorInput(authors.get(0));
		books = query.findAllBooks(authorInput);
		assertTrue("", books.size() == 1);
		assertNotNull("books[0] is null!", books.get(0));
	}
}