package dev.bobscott.spring5webapp.repositories;

import dev.bobscott.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
