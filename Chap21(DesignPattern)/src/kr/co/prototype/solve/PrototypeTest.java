package kr.co.prototype.solve;

import java.util.ArrayList;

class Book {
	private String author;
	private String title;
	
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "[" + author + ", " + title + "]";
	}
}

class BookShelf implements Cloneable {
	private ArrayList<Book> shelf;
	
	public BookShelf() {
		shelf = new ArrayList<Book>();
	}

	public ArrayList<Book> getShelf() {
		return shelf;
	}
	public void setShelf(ArrayList<Book> shelf) {
		this.shelf = shelf;
	}
	
	public void addBook(Book book) {
		shelf.add(book);
	}

	@Override
	public String toString() {
		return shelf.toString();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		// 깊은 복사
		BookShelf another = new BookShelf();
		for(Book book : shelf) {
			another.addBook(new Book(book.getAuthor(), book.getTitle()));
		}
		return another;
	}
}

public class PrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		/*
		 * 1. BookShelf implements Cloneable
		 * 2. main(String[] args) throws CloneNotSupportedException
		 */
		
		BookShelf bookShelf = new BookShelf();
		bookShelf.addBook(new Book("작가1", "책1"));
		bookShelf.addBook(new Book("작가2", "책2"));
		bookShelf.addBook(new Book("작가3", "책3"));
		
		// bookShelf 를 복제해서 객체생성
		BookShelf another = (BookShelf)bookShelf.clone();
		System.out.println(bookShelf);
		System.out.println(another);
		System.out.println();
		/*
			[[작가1, 책1], [작가2, 책2], [작가3, 책3]]
			[[작가1, 책1], [작가2, 책2], [작가3, 책3]]
		 */
		
		bookShelf.getShelf().get(0).setAuthor("이순신");
		System.out.println(bookShelf);
		System.out.println(another);
		/*
			[[이순신, 책1], [작가2, 책2], [작가3, 책3]]
			[[작가1, 책1], [작가2, 책2], [작가3, 책3]]
		 */
	}
}
