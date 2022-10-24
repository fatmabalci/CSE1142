/*
 * Author : Fatma Balcı
 * Student Number: 150119744
 * 
 * This class is designed to define a Dictionary,
 * it stores the data required and operates accordingly
 * it inherits from Book class
 * 
 */
package Hw1;

public class Dictionary extends Book {
	/* Attributes - Start */
	private int definitions;
	/* Attributes - End */
	
	// Constructor getting id, title, author and definitions
	public Dictionary(int id, String title, Author author, int definitions) {
		super(id, title, author);
		try {
			setDefinitions(definitions);
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	// Constructor getting id, title and definitions
	public Dictionary(int id, String title, int definitions) {
		super(id, title);
		try {
			setDefinitions(definitions);
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	// Return definitions
	public int getDefinitions() {
		return this.definitions;
	}
	// Set definitions
	public void setDefinitions(int definitions) throws Exception {
		if (!(definitions > 0)) {
			throw new Exception("Dictionary definitions should be positive only!");
		}
		this.definitions = definitions;
	}
	
	// Return explanation for dictionaries
	public String toString() {
		return "Dictionary Name is " 
				+ this.getTitle() + ", definitions: " 
				+ Integer.toString(this.getDefinitions());
	}
}
