package com.graphql.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.graphql.book.exception.GraphQLErrorAdapter;
import com.graphql.book.model.Author;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;
import com.graphql.book.resolver.AuthorMutation;
import com.graphql.book.resolver.AuthorQuery;
import com.graphql.book.resolver.BookMutation;
import com.graphql.book.resolver.BookQuery;
import com.graphql.book.resolver.BookResolver;
import com.graphql.book.resolver.Mutation;
import com.graphql.book.resolver.Query;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLErrorHandler;

@Configuration
public class AppConfig {
	private final Logger log = LoggerFactory.getLogger(AppConfig.class);
	/*
	 * @Bean ServletRegistrationBean graphQLServletRegistrationBean(GraphQLSchema
	 * schema, ExecutionStrategy executionStrategy, List<GraphQLOperationListener>
	 * operationListeners) { return new ServletRegistrationBean(new
	 * SimpleGraphQLServlet(schema, executionStrategy, operationListeners),
	 * "/graphql"); }
	 */	
	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream().filter(this::isClientError).collect(Collectors.toList());
				List<GraphQLError> serverErrors = errors.stream().filter(e -> !isClientError(e)).map(GraphQLErrorAdapter::new).collect(Collectors.toList());
				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}
			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}
	@Bean
	public AuthorQuery authorQuery() { return new AuthorQuery(); }
	@Bean
	public AuthorMutation authorMutation() { return new AuthorMutation(); }
	@Bean
	public BookQuery bookQuery() { return new BookQuery(); }
	@Bean
	public BookMutation bookMutation() { return new BookMutation(); }
	
	@Bean
	public BookResolver authorResolver() { return new BookResolver(); }

	// with a CommandLineRunner bean, we can insert some data into the database
	@Bean
	public CommandLineRunner repositoryInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
		log.info("repositoryInitializer()");
		return (args) -> {
			Author author = authorRepository.findAll().isEmpty() ? new Author("Kok How", 	"Teh") : authorRepository.findAll().get(0);
			if (authorRepository.findAll().isEmpty())
				authorRepository.save(author);
			if (bookRepository.findAll().isEmpty())
				bookRepository.save(new Book("My First GrapQL Book", "1234567890", 500, author));
			log.info(authorRepository.findAll().size()+" authors");
			log.info(bookRepository.findAll().size()+" books");
		};
	}
}