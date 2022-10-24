/*
 * Author : Fatma Balcı
 * Student Number: 150119744
 * 
 * This class is designed to define Customers,
 * it stores the data required and operates accordingly
 * 
 */
package Hw1;

public class Customer extends Person {
	/* Attributes - Start */
	private String address;
	private Book borrowedBook;
	private boolean borrowABook;
	/* Attributes - End */
	
	// Constructor getting name, birth place, birth date and address
	public Customer(String name, String birthPlace, int birthDate, String address) {
		super(name, birthDate, birthPlace);
		try {
			setAddress(address);
			this.borrowABook = false;
		}
		catch (Exception exception) {
			this.address = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Constructor getting name, birth date, address
	Customer(String name, int birthDate, String address){
		super(name, birthDate);
		try {
			setAddress(address);
			this.borrowABook = false;
		}
		catch (Exception exception) {
			this.address = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Constructor getting only name and address
	public Customer(String name, String address) {
		super(name);
		try {
			setAddress(address);
			this.borrowABook = false;
		}
		catch (Exception exception) {
			this.address = null;
			System.out.println(exception.getMessage());
		}
	}
	// Constructor getting only name and birth date
	public Customer(String name, int birthDate) {
		super(name, birthDate);
		this.borrowABook = false;
	}
	
	// Return address
	public String getAddress() {
		if (this.address == null) {
			return "-";
		}
		return this.address;
	}
	// Set address
	public void setAddress(String address) throws Exception {
		if (address.length() < 3) {
			throw new Exception("Customer address should contain at least 3 characters!");
		}
		this.address = address;
	}
	// Return borrowed book
	public Book getBorrowedBook() {
		return this.borrowedBook;
	}
	// Set borrowed book
	public void setBorrowedBook(Book book) {
		this.borrowedBook = book;
	}
	// Return borrowed book status
	public boolean isBorrowedBook() {
		return this.borrowABook;
	}
	// Set borrowed book status true if customer didn't get any book before
	public boolean borrowBook() {
		if (this.borrowABook) {
			return false;
		}
		this.borrowABook = true;
		return true;
	}
	
	// Set borrowed book status false if customer borrowed a book before
	public boolean returnBook() {
		if (!this.borrowABook) {
			return false;
		}
		this.borrowABook = false;
		return true;
	}
	// Return explanation for customer objects
	public String toString() {
		return super.toString() + "\nAddress: " + this.getAddress();
	}
}
