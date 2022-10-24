/*
 * Author : Fatma Balcı
 * Student Number: 150119744
 * 
 * This class is designed to define a Person,
 * it stores the data required and operates accordingly
 * 
 */
package Hw1;

public class Person {
	/* Attributes - Start */
	private String name;
	private String birthDate;
	private String birthPlace;
	/* Attributes - End */
	
	// Constructor getting name, birthDate, birthPlace
	public Person(String name, int birthDate, String birthPlace) {
		try {
			this.setName(name);
			this.setBirthDate(birthDate);
			this.setBirthPlace(birthPlace);
		}
		catch (Exception exception) {
			this.name = null;
			this.birthDate = null;
			this.birthPlace = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Constructor getting only name and birthDate
	public Person(String name, int birthDate) {
		try {
			this.setName(name);
			this.setBirthDate(birthDate);
		}
		catch (Exception exception) {
			this.name = null;
			this.birthDate = null;
			this.birthPlace = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Constructor getting only name
	public Person(String name) {
		try {
			this.setName(name);
		}
		catch (Exception exception) {
			this.name = null;
			this.birthPlace = null;
			System.out.println(exception.getMessage());
		}
	}
	
	// Return name
	public String getName() {
		if (this.name == null) {
			return "-";
		}
		return this.name;
	}
	
	// Set name
	public void setName(String name) throws Exception {
		if (name.length() < 3) {
			throw new Exception("Person name should contain at least 3 characters!");
		}
		this.name = name;
	}
	
	// Return birth date
	public String getBirthDate() {
		if (this.birthDate == null) {
			return "-";
		}
		return this.birthDate;
	}
	// Set birth date
	public void setBirthDate(int birthDate) throws Exception{
		if (!(birthDate > 0)) {
			throw new Exception("Birth date should be positive only!");
		}
		this.birthDate = Integer.toString(birthDate);
	}
	
	// Return birth place
	public String getBirthPlace() {
		if (this.birthPlace == null) {
			return "-";
		}
		return this.birthPlace;
	}
	// Set birth place
	public void setBirthPlace(String birthPlace) throws Exception {
		if (birthPlace.length() < 3) {
			throw new Exception("Birth place should contain at least 3 characters!");
		}
		this.birthPlace = birthPlace;
	}
	// Return explanation for person objects
	public String toString() {
		return "Name: " + this.getName() 
				+ ", Birth Date: " + this.getBirthDate()
				+ ", Birth Place: " + this.getBirthPlace();
	}
}
