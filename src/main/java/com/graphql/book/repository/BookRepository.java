package com.graphql.book.repository;
import com.graphql.book.model.*;
import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository<Book, Long> {
}