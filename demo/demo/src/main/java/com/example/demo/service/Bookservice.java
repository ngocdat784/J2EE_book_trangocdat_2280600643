package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.book;



@Service
public class Bookservice {
    private List<book> books = new ArrayList<>();

    public List<book> getAllBooks() {
        return books;
    }

    public book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(book book) {
        books.add(book);
    }
    public void updateBook(int id, book updatedBook) {
    books.stream()
        .filter(book -> book.getId() == id)
        .findFirst()
        .ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
}

public void deleteBook(int id) {
    books.removeIf(book -> book.getId() == id);
}

}
