package com.graphql.book.repository;
import com.graphql.book.model.*;
import org.springframework.data.repository.CrudRepository;
public interface AuthorRepository extends CrudRepository<Author, Long> {
}