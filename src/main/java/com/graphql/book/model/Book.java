package com.graphql.book.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int pageCount;
	private String title;
	private String isbn;
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;
	public Book() {}
	public Book(String title, String isbn, int count, Author author) { this.title = title; this.isbn = isbn; pageCount = count; this.author = author;}
	public Long getId() { return id; }
	public int getPageCount() { return pageCount; }
	public String getTitle() { return title; }
	public String getIsbn() { return isbn; }
	public Author getAuthor() { return author; }
	public void setId(Long id) { this.id = id; }
	public void setPageCount(int count) { pageCount = count; }
	public void setTitle(String name) { title = name; }
	public void setIsbn(String name) { isbn = name; }
	public void setAuthor(Author authoer) { this.author = author; }
	@Override
	public boolean equals(Object o) {
		return this == o || (o != null && getClass() == o.getClass() && id.equals(((Book)o).id));
	}
	@Override
	public int hashCode() { return id.hashCode(); }
	@Override
	public String toString() {
		return "Book { id = " + id + ", title = '" + title + "', isbn = '" + isbn + "', pageCount = " + pageCount + ", author = " + author + "}";
	}
}