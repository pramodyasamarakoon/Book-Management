package com.airhacks.services;

import com.airhacks.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceIml implements BookService {

    private static List<Book> BooksDb = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return BooksDb;
    }

    @Override
    public Optional<Book> getBookById(int id) {
        for( Book b: BooksDb ){
            if ( b.getId() == id ){
                Optional.of(b);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> addNewBook(Book book) {
        for ( Book b: BooksDb ){
            if ( b.getName() == book.getName() ){
                return Optional.empty();
            }
        }
        BooksDb.add(book);
        return Optional.of(book);
    }

    @Override
    public Boolean removeBookById(int id) {
        for ( Book b: BooksDb ){
            if ( b.getId() == id ){
                BooksDb.remove(b);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Book> updateBookById(int id, Book book) {
        for ( Book b: BooksDb ){
            if ( b.getId() == id ){
                b.setName( book.getName() );
                b.setAuthor( book.getAuthor() );
                b.setCategory( book.getCategory() );
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }
}
