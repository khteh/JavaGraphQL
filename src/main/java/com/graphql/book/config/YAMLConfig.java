package com.graphql.book.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
	private String name;
	private Server server;
	public String getName() { return name; }
	public Server getServer() { return server;}
	public void setServer(Server server) { this.server = server;}
	public void setName(String name) { this.name = name; }
	public YAMLConfig() {}
	public YAMLConfig(String name, Server server) { 
		this.name = name; 
		this.server = server;
	}
}