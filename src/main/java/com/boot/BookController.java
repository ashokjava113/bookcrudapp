package com.boot;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@PostMapping("/book")
	public Book saveBook(@Valid @RequestBody Book book) {
		System.out.println("from save book method");
		Book savedBook = service.saveBook(book);
		return savedBook;
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@Valid @PathVariable("id") int id) {
		System.out.println("from get book method");
		Book book = service.getBook(id);
		return book;
	}
	
//	@PutMapping("book/{id}")
//	public Book updateBook(@Valid @PathVariable("id") int id) {
//		System.out.println("from update book method");
//		Book booku = service.getBook(id);
//		return booku;
//	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@Valid @PathVariable("id") int id) {
		System.out.println("from delete book method");
		service.deleteBook(id);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		System.out.println("from get all book method");
		return service.getAllBooks();
	}
}
