package advancejava5.service;

import org.springframework.stereotype.Service;

import advancejava5.model.Book;

@Service
public interface BookService {

	public Book[] getBook();

	public void addBook(Book book);

	public void updateBook(Book book, int id);

	public void deleteBook(int id);
}
