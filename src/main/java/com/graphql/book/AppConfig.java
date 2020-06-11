package com.graphql.book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Iterables;
import com.graphql.book.config.YAMLConfig;
import com.graphql.book.exception.GraphQLErrorAdapter;
import com.graphql.book.model.Author;
import com.graphql.book.model.Book;
import com.graphql.book.repository.AuthorRepository;
import com.graphql.book.repository.BookRepository;
import com.graphql.book.resolver.BookResolver;
import com.graphql.book.resolver.Mutation;
import com.graphql.book.resolver.Query;

//import com.graphql.book.resolver.Mutation;
//import com.graphql.book.resolver.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
@Configuration
public class AppConfig {
	public static final Log log = LogFactory.getLog(AppConfig.class);
	@Autowired
	YAMLConfig config_;

	@Autowired
	AuthorRepository authorRepository_;

	@Autowired
	BookRepository bookRepository_;
/*	
	@Bean 
	//ServletRegistrationBean graphQLServletRegistrationBean(GraphQLSchema schema, ExecutionStrategy executionStrategy, List<GraphQLOperationListener> operationListeners)
	ServletRegistrationBean servletRegistrationBean()
	{
		try {
		GraphQLSchema schema  = SchemaParser.newParser()
				.resolvers(bookResolver(authorRepository_), mutation(bookRepository_, authorRepository_), query(bookRepository_, authorRepository_))
				.file("graphql/author.graphqls")
				.file("graphql/book.graphqls")
				.file("graphql/empty.graphqls")
				.build().makeExecutableSchema();
		ExecutionStrategy executionStrategy = new AsyncExecutionStrategy();
		//GraphQLHttpServlet servlet = new SimpleGraphQLHttpServlet(schema, executionStrategy);
		final SimpleGraphQLHttpServlet  servlet = SimpleGraphQLHttpServlet.newBuilder(schema)
		//            .withInstrumentation(factory.getInstrumentations())
		            .build();
        Server svr = config_.getServer();
        Servlet srvlet = svr.getServlet();       
        System.out.println(AppConfig.class.getName() + ".servletRegistrationBean() port: "+svr.getPort() + ", contextPath: " + srvlet.getContextPath());
		ServletRegistrationBean bean = new ServletRegistrationBean(servlet, srvlet.getContextPath());
		return bean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
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

	// with a CommandLineRunner bean, we can insert some data into the database
	@Bean
	public CommandLineRunner repositoryInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
		log.info("repositoryInitializer()");
		return (args) -> {
			Author author = Iterables.isEmpty(authorRepository.findAll()) ? new Author("Kok How", 	"Teh") : Iterables.get(authorRepository.findAll(), 0);
			if (Iterables.isEmpty(authorRepository.findAll()))
				authorRepository.save(author);
			if (Iterables.isEmpty(bookRepository.findAll()))
				bookRepository.save(new Book("My First GrapQL Book", "1234567890", 500, author));
			log.info(StreamSupport.stream(authorRepository.findAll().spliterator(), false).count()+" authors");
			log.info(StreamSupport.stream(bookRepository.findAll().spliterator(), false).count()+" books");
		};
	}
	@Bean	
	public Query query(BookRepository bookRepository, AuthorRepository authorRepository) {
		return new Query(bookRepository, authorRepository);
	}
	@Bean
	public Mutation mutation(BookRepository bookRepository, AuthorRepository authorRepository) {
		return new Mutation(bookRepository, authorRepository);
	}
	@Bean
	public BookResolver bookResolver(AuthorRepository repo) {
		return new BookResolver(repo);
	}
/*
	@Bean
	public BookQuery bookQuery(BookRepository bookRepository, AuthorRepository authorRepository) {
		return new BookQuery(authorRepository, bookRepository);
	}

	@Bean
	public AuthorQuery authorQuery(BookRepository bookRepository, AuthorRepository authorRepository) {
		return new AuthorQuery(authorRepository, bookRepository);
	}

	@Bean
	public BookMutation bookMutation(BookRepository bookRepository, AuthorRepository authorRepository) {
		return new BookMutation(authorRepository, bookRepository);
	}

	@Bean
	public AuthorMutation authorMutation(BookRepository bookRepository, AuthorRepository authorRepository) {
		return new AuthorMutation(authorRepository, bookRepository);
	}
*/
}