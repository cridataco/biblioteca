package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LibraryManager {
	
	private Stack<Book> booksAvalibles;
	private Queue<Book> returnedBooks;
	private ArrayList<Book> borrowedBooks;
	
	public LibraryManager(){
		booksAvalibles = new Stack();
		returnedBooks = new LinkedList<Book>();
	}
	
	public void addBook(String name, String author) {
		booksAvalibles.add(new Book(name, author));
	}
	
	public void returnBook(String name) {
		for (Book book : borrowedBooks) {
			if(book.getName().equals(name)) {
				booksAvalibles.add(book);
				returnedBooks.add(book);
				removeborrowedBook(book);
			}
		}
	}
	
	public void lendBook(String name) {
		for (Book book : booksAvalibles) {
			if(book.getName().equals(name)) {
				borrowedBooks.add(book);
				removebookAvalible(book);
			}
		}
	}
	
	private void removeborrowedBook(Book book) {
		for (Book tmpBook : borrowedBooks) {
			if(tmpBook == book) {
				borrowedBooks.remove(book);
			}
		}
	}
	
	private void removebookAvalible(Book book) {
		for (Book tmpBook : booksAvalibles) {
			if(tmpBook == book) {
				booksAvalibles.remove(book);
			}
		}
	}
	
	public String showbooksAvalibles() {
		String result = "";
		for (Book book : booksAvalibles) {
			result += book.toString();
		}
		return result;
	}
	
	public String showreturnedBooks() {
		String result = "";
		for (Book book : returnedBooks) {
			result += book.toString();
		}
		return result;
	}
	
	public String showborrowedBooks() {
		String result = "";
		for (Book book : borrowedBooks) {
			result += book.toString();
		}
		return result;
	}
}
