package com.student.ust.service;

import com.student.ust.entity.Book;
import com.student.ust.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService
{
    @Autowired
    BookRepository bookRepository;
    public Book getBookByID(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }
    public void saveBook(Book book){
        book.setDateBirth(LocalDateTime.now());
        book.setModifiedDate(book.getDateBirth());
        bookRepository.save(book);
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public  Book updateBook(Book book){
        Book updateBook=bookRepository.findById(book.getBookId()).orElseThrow(()->new NoSuchElementException());
        updateBook.setBookName(book.getBookName());
        updateBook.setAuthorName(book.getAuthorName());
        updateBook.setIsbn(book.getIsbn());
        updateBook.setModifiedDate(LocalDateTime.now());
        bookRepository.save(updateBook);
        return  updateBook;


    }

    public void deleteId(Integer id) {
        bookRepository.deleteById(id);
    }
}