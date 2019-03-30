package dev.bobscott.spring5webapp.bootstrap;

import dev.bobscott.spring5webapp.model.Author;
import dev.bobscott.spring5webapp.model.Book;
import dev.bobscott.spring5webapp.model.Publisher;
import dev.bobscott.spring5webapp.repositories.AuthorRepository;
import dev.bobscott.spring5webapp.repositories.BookRepository;
import dev.bobscott.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher wrox = new Publisher("Wrox", "123 Street", "New York", "New York", "2334");
        Publisher harperc = new Publisher("Harper Collins", "77 Street", "Seattle", "Washington", "2543");

        publisherRepository.save(wrox);
        publisherRepository.save(harperc);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
