package com.airhacks.services;

import com.airhacks.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookById(final int id );

    Optional<Book> addNewBook( final Book book );

    Boolean removeBookById( final int id );

    Optional<Book> updateBookById( final int id, final Book book );

}
