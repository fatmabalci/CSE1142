/*
 * Author : Fatma Balcı
 * Student Number: 150119744
 * 
 * This class is designed to define Books,
 * it stores the data required and operates accordingly
 * 
 */

package Hw1;

public class Book {
	/* Attributes - Start */
	private int id;
	private String title;
	private Author author;
	private boolean borrowed;
	/* Attributes - End */
	
	// Constructor getting id, title and author
	public Book(int id, String title, Author author) {
		try {
			setId(id);
			setTitle(title);
			setAuthor(author);
		}
		catch(Exception exception) {
			this.title = null;
			this.author = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Constructor getting only id and title
	public Book(int id, String title) {
		try {
			setId(id);
			setTitle(title);
		}
		catch (Exception exception) {
			this.title = null;
			this.author = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Return borrowed status
	public boolean isBorrowed() {
		return this.borrowed;
	}
	
	// Set the borrowed status true if it is not borrowed
	public boolean borrowed() {
		if (this.borrowed) {
			return false;
		}
		this.borrowed = true;
		return true;
	}
	// Set the borrowed status false if it not borrowed
	public boolean returned() {
		if (!this.borrowed) {
			return false;
		}
		this.borrowed = false;
		return true;
	}
	// Return explanation for book objects
	public String toString() {
		String text = "Book name is " + this.getTitle() + ", ";
		if (this.getAuthor() != null) {
			text += this.author.toString();
		}
		else {
			text += "Author could not found";
		}
		return text;
	}
	// Returns id
	public int getId() {
		return this.id;
	}
	// Sets id
	public void setId(int id) throws Exception {
		if (!(id > 0)) {
			throw new Exception("Id should be positive only!");
		}
		this.id = id;
	}
	// Return title
	public String getTitle() {
		if (this.title == null) {
			return "-";
		}
		return this.title;
	}
	// Sets title
	public void setTitle(String name) throws Exception {
		if (name.length() < 3) {
			throw new Exception("Book title should contain at least 3 characters!");
		}
		this.title = name;
	}
	// Returns author of the book
	public Author getAuthor() {
		if (this.author == null) {
			return null;
		}
		return this.author;
	}
	// Sets author
	public void setAuthor(Author author) {
		this.author = author;
	}
}
