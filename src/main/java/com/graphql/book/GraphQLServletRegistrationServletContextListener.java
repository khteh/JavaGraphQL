package com.graphql.book;
import javax.inject.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import graphql.kickstart.servlet.SimpleGraphQLHttpServlet;
import graphql.schema.GraphQLSchema;
@WebListener
public class GraphQLServletRegistrationServletContextListener implements ServletContextListener {
    private GraphQLSchema schema;
    public GraphQLServletRegistrationServletContextListener() {}
    @Inject
    public GraphQLServletRegistrationServletContextListener(final GraphQLSchema schema) {
        this.schema = schema;
    }

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        final ServletRegistration.Dynamic dynamicGraphQLServlet
                = event.getServletContext().addServlet("GraphQLEndpoint", SimpleGraphQLHttpServlet.newBuilder(schema).build());
        dynamicGraphQLServlet.addMapping("/graphql-book");
    }

    @Override
    public void contextDestroyed(final ServletContextEvent event) {}

}