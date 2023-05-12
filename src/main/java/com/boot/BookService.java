package com.boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookRepository repo;
	
	public Book getBook(int id) {
		Optional<Book> book = repo.findById(id);
		return book.get();
	}
	
	public void deleteBook(int id) {
		repo.deleteById(id);
	}
	
//	public Book updateBook(int id) {
//		return this.getBook(id);
//	}
	
	public Book saveBook(Book book) {
		Book savedBook = repo.save(book);
		return savedBook;
	}
	
	public List<Book> getAllBooks(){
		List<Book> book = new ArrayList<Book>();
		repo.findAll().forEach(books1 -> book.add(books1));
		return book;
	}
}
