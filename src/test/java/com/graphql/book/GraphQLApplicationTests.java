package com.graphql.book;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.book.model.Book;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.graphql.spring.boot.test.GraphQLTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//import com.graphql.book.resolver.Query;
//@RunWith(SpringRunner.class)
//@SpringBootTest
// org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'serverEndpointExporter' defined in class path resource [com/oembedler/moon/graphql/boot/GraphQLWebAutoConfiguration.class]:
// https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/113
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@GraphQLTest
public class GraphQLApplicationTests {
	@Autowired
    private GraphQLTestTemplate graphQLTestTemplate;	
	@Test
    public void GetAllBooks_Succeed() throws IOException {
		assertNotNull(graphQLTestTemplate);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/get-all-books.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        // bookRepository.save(new Book("My First GrapQL Book", "1234567890", 500, author));
        assertEquals("My First GrapQL Book", response.get("$.data.book.title"));
        assertEquals("1234567890", response.get("$.data.book.isbn"));
        assertEquals(500, response.get("$.data.book.pageCount"));
        assertNotNull("$.data.book.author");
    }
}