package com.graphql.book.model;

public class AuthorInput {
	private Long id;
	private String firstName;
	private String lastName;
	public AuthorInput() {}
	public AuthorInput(Long id) { this.id = id; }
	public AuthorInput(String first, String last) { firstName = first; lastName = last; }
	public AuthorInput(Long id, String first, String last) { this.id = id; firstName = first; lastName = last; }
	public AuthorInput(Author author) { this.id = author.getId(); firstName = author.getFirstName(); lastName = author.getLastName(); }
	public Long getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public void setId(Long id) { this.id = id; }
	public void setFirstName(String name) { firstName = name; }
	public void setLastName(String name) { lastName = name; }
	@Override
	public boolean equals(Object o) {
		return this == o || (o != null && getClass() == o.getClass() && id.equals(((AuthorInput)o).id) && firstName.equals(((AuthorInput)o).firstName) && lastName.equals(((AuthorInput)o).lastName));
	}
	@Override
	public int hashCode() { return id.hashCode(); }
	@Override
	public String toString() {
		return "Author { id = " + id + ", firstName = '" + firstName + "', lastName = '" + lastName + "'}";
	}
}