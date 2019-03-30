package dev.bobscott.spring5webapp.repositories;

import dev.bobscott.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
