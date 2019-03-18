package com.graphql.book.model;
import javax.persistence.*;
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	public Author() {}
	public Author(Long id) { this.id = id; }
	public Author(String first, String last) { firstName = first; lastName = last; }
	public Author(Long id, String first, String last) { this.id = id; firstName = first; lastName = last; }
	public Long getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public void setId(Long id) { this.id = id; }
	public void setFirstName(String name) { firstName = name; }
	public void setLastName(String name) { lastName = name; }
	@Override
	public boolean equals(Object o) {
		return this == o || (o != null && getClass() == o.getClass() && id.equals(((Author)o).id) && firstName.equals(((Author)o).firstName) && lastName.equals(((Author)o).lastName));
	}
	@Override
	public int hashCode() { return id.hashCode(); }
	@Override
	public String toString() {
		return "Author { id = " + id + ", firstName = '" + firstName + "', lastName = '" + lastName + "'}";
	}
}