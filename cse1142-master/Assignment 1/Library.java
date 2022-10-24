/*
 * Author : Fatma Balcı
 * Student Number: 150119744
 * 
 * This class is designed to define a Library,
 * it stores the data required and operates accordingly
 * 
 */

package Hw1;

import java.util.ArrayList;

public class Library {
	/* Attributes - Start */
	private String address;
	private ArrayList<Book> books;
	private ArrayList<Customer> customers;
	/* Attributes - End */
	
	// Constructor getting address
	public Library(String address) {
		try {
			this.setAddress(address);
		}
		catch (Exception exception) {
			this.address = null;
			System.out.println(exception.getMessage());
		}
		finally  {
			this.books = new ArrayList<Book>();
			this.customers = new ArrayList<Customer>();
		}		
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
			throw new Exception("Library address should contain at least 3 characters!");
		}
		this.address = address;
	}
	
	// Print opening hours, shared by all instances
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9 am to 5 pm.");
	}
	
	// Print address
	public void printAddress() {
		System.out.println(this.address);
	}
	// Add given book to the book list and return if it is success
	public boolean addBook(Book book) {
		this.books.add(book);
		return true;
	}
	// Add given customer to the customer list
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	// Assign the given book to the given customer if requirements satisfy
	public void borrowBook(String bookName, String personName) {
		boolean isExistingBook = false;
		boolean isExistingCustomer = false;
		int availableBookIndex = -1;
		int availableCustomerIndex = -1;
		for (int i = 0; i < this.books.size(); i++) {
			if (this.books.get(i).getTitle() == bookName) {
				isExistingBook = true;
				if (!this.books.get(i).isBorrowed()) {
					availableBookIndex = i;
					break;
				}
			}
		}
		
		for (int i = 0; i < this.customers.size(); i++) {
			if (this.customers.get(i).getName() == personName) {
				isExistingCustomer = true;
				if (!this.customers.get(i).isBorrowedBook()) {
					availableCustomerIndex = i;
					break;
				}
			}
		}
		if (!isExistingBook) {
			System.out.println("Sorry, this book is not in our catalog");
		}
		else if (!isExistingCustomer) {
			System.out.println("Sorry, " + personName + " is not a customer");
		}
		else if (availableBookIndex == -1) {
			System.out.println("Sorry, this book is already borrowed");
		}
		else if (availableCustomerIndex == -1) {
			System.out.println("Sorry, " + personName + " already borrowed a book");
		}
		else {
			this.books.get(availableBookIndex).borrowed();
			this.customers.get(availableCustomerIndex).borrowBook();
			this.customers.get(availableCustomerIndex).setBorrowedBook(this.books.get(availableBookIndex));
			System.out.println(personName + " successfully borrowed " + this.books.get(availableBookIndex).getTitle() + ".");
		}
	}
	
	// Return the book given by the customer if requirements satisfy
	public void returnBook(String personName) {
		boolean isCustomerExisting = false;
		int customerIndex = -1;
		for (int i = 0; i < this.customers.size(); i++) {
			if (this.customers.get(i).getName() == personName) {
				isCustomerExisting = true;
				customerIndex = i;
			}
		}
		if (!isCustomerExisting) {
			System.out.println("Sorry, " + personName + " is not a customer.");
		}
		else if (!this.customers.get(customerIndex).isBorrowedBook()) {
			System.out.println("Sorry, " + personName + " did not barrow a book");
		}
		else {
			String bookTitle = this.getCustomers().get(customerIndex).getBorrowedBook().getTitle();
			
			for (int i = 0; i < this.books.size(); i++) {
				if (this.books.get(i).getTitle() == bookTitle && this.books.get(i).isBorrowed()) {
					this.books.get(i).returned();
					this.customers.get(customerIndex).returnBook();
					System.out.println(personName + " successfully returned " + this.books.get(i).getTitle());
					break;
				}
			}	
		}
	}
	
	// Print available books
	public void printAvailableBooks() {
		boolean isAnyAvailable = false;
		for (Book book: this.books) {
			if (!book.isBorrowed()) {
				isAnyAvailable = true;
				System.out.println(book.toString());
			}
		}
		if (!isAnyAvailable) {
			System.out.println("No book in catalog.");
		}
	}
	
	// Return book list
	public ArrayList<Book> getBooks() {
		return this.books;
	}
	// Return customer list
	public ArrayList<Customer> getCustomers() {
		return this.customers;
	}
	
	public String toString() {
		return "Library address is " + this.getAddress();
	}
}
