package com.graphql.book.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.graphql.book.config.*;

public class Server {
	private int port;
	private Servlet servlet;
	public int getPort() { return port; }
	public void setPort(int port) { this.port = port; }
	public Servlet getServlet() { return servlet; }
	public void setServlet(Servlet servlet) { this.servlet = servlet; }
}