package dev.bobscott.spring5webapp.repositories;

import dev.bobscott.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
