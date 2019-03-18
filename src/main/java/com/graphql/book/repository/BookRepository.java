package com.graphql.book.repository;
import com.graphql.book.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends JpaRepository<Book, Long> {
}