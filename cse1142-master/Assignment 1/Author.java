/*
 * Author : Fatma Balcı
 * Student Number: 150119744
 * 
 * This class is designed to define Authors,
 * it stores the data required and operates accordingly
 * 
 */

package Hw1;

public class Author extends Person {
	/* Attributes - Start */
	private String publisher;
	/* Attributes - End */
	
	// Constructor getting name, publisher, birth date
	public Author(String name, String publisher, int birthDate){
		super(name, birthDate);
		try {
			setPublisher(publisher);
		}
		catch (Exception exception) {
			this.publisher = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Return publisher
	public String getPublisher() {
		if (publisher == null) {
			return "-";
		}
		return this.publisher;
	}
	// Set publisher
	public void setPublisher(String publisher) throws Exception {
		if (publisher.length() < 3) {
			throw new Exception("Publisher name should contain at least 3 characters!");
		}
		this.publisher = publisher;
	}
	// Return explanation for Authors
	public String toString() {
		return "Author is " + this.getName();
	}
}
