package assignment4;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class stores attributes for Person obects
 * @author Rasa Ghaffarian
 * @since 2018-10-26
 */

public class Person {
	/**
	 * Main constructor that sets default values to the constants.
	 */
	public Person() {
		firstName = NOT_AVAIL;
		lastName = NOT_AVAIL;
		id = NO_ID;
		birthDate = NO_BDATE;
		address = NOT_AVAIL;
	}
	
	private String firstName;
	private String lastName;
	private int id;
	private String birthDate;
	private String address;
	
	// The following constants to have a reference to default values
	protected static final String NOT_AVAIL = "Not Available";
	protected static final int NO_ID = 99999;
	protected static final String NO_BDATE = "1800/01/01";
	
	/**
	 * Returns the first name of the person.
	 * @return String containing the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name of the person.
	 * @param firstName String containing the first name between 2 and 50 alphabetic characters, including apostrophes, spaces, and dashes
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setFirstName(String firstName) {
		// Null parameter
		if ( firstName == null )  return false;
		
		// Removing leading and trailing spaces
		firstName = firstName.trim();
		
		// Incorrect length
		if ( firstName.length() < 2 || firstName.length() > 50 ) return false;
		
		// Checking for the correct characters
		if ( !firstName.matches("[a-zA-Z\\'\\-\\ ]+") ) return false;
		
		this.firstName = firstName;
		return true;
	}
	
	/**
	 * Returns the last name of the person.
	 * @return String containing the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name of the person.
	 * @param lastName String containing the last name between 2 and 50 alphabetic characters, including apostrophes, spaces, and dashes
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setLastName(String lastName) {
		// Null parameter
		if ( lastName == null )  return false;
		
		// Removing leading and trailing spaces
		lastName = lastName.trim();
		
		// Incorrect length
		if ( lastName.length() < 2 || lastName.length() > 50 ) return false;
		
		// Checking for the correct characters
		if ( !lastName.matches("[a-zA-Z\\'\\-\\ ]+") ) return false;
		
		this.lastName = lastName;
		return true;
	}
	
	/**
	 * Returns the ID of the person.
	 * @return int containing the ID number
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the ID of the person.
	 * @param id int containing the ID number between 10000 and 99999
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setId(int id) {
		if ( id < 10000 || id > 99999 )
			return false;
		this.id = id;
		return true;
	}
	
	/**
	 * Returns the birth date of the person.
	 * @return String containing the birth date
	 */
	public String getBirthDate() {
		return birthDate;
	}
	
	/**
	 * Sets the birth date of the person.
	 * @param birthDate String containing the birth date in the format YYYY/MM/DD
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setBirthDate(String birthDate) {
		if ( birthDate == null ) return false;
		
		birthDate = birthDate.trim();
		
		// This is only checking for the format, not for a valid date (ex: February 31 2019 is accepted)
		if ( !birthDate.matches("((19|20)\\d\\d)/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])") ) return false;
		
		this.birthDate = birthDate;
		return true;
	}
	
	/**
	 * Returns the address of the person.
	 * @return String containing the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address of the person.
	 * @param address String containing the address
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setAddress(String address) {
		if ( address == null ) return false;
		
		address = address.trim();
		
		// Checking the length of the address
		if ( address.length() < 10 || address.length() > 300 ) return false;
		
		if ( !address.matches("[a-zA-Z0-9,.\\'\\-\\ ]+") ) return false;
		
		this.address = address;
		return true;
	}
	
	/**
	 * Gets the email address of the person in standard firstname.lastname@ubalt.edu format.
	 * @return String containing the email address of the person
	 */
	public String getEmailAddress() {
		// If there is either no first or last name
		if ( firstName.equalsIgnoreCase(NOT_AVAIL) || lastName.equalsIgnoreCase(NOT_AVAIL) ) return NOT_AVAIL;
		
		// The first name may contain spaces, dashes, and apostrophes, which need to be removed
		String sanitizedFirstName = firstName.replaceAll("[\\-\\'\\ ]", "");
		// Email addresses usually utilize lower-case letters only
		sanitizedFirstName = sanitizedFirstName.toLowerCase();
		
		// The same modifications need to be applied to the last name
		String sanitizedLastName = lastName.replaceAll("[\\-\\'\\ ]", "");
		sanitizedLastName = sanitizedLastName.toLowerCase();
		
		String emailAddress = sanitizedFirstName + "." + sanitizedLastName;
		
		emailAddress += "@ubalt.edu";
		
		return emailAddress;
	}
	
	/**
	 * Gets the age of the person, based on the birth date and the current date.
	 * @return int containing the age of the person
	 */
	public int getAge() {
		// If no birth date has been set
		if ( birthDate.equalsIgnoreCase(NO_BDATE) ) return -1;
		
		// Extracting the first four numbers, the year
		int birthYear = Integer.parseInt(birthDate.substring(0, 4));
		
		// Extracting the numbers associated with the month
		int birthMonth = Integer.parseInt(birthDate.substring(5, 7));
		
		// Extracting the numbers associated with the day
		int birthDay = Integer.parseInt(birthDate.substring(8));
		
		// Creates two LocalDate type objects, which we will use
		// to figure out the age of the record
		LocalDate bDate = LocalDate.of(birthYear, birthMonth, birthDay);
		LocalDate today = LocalDate.now();
		
		// We let the system figure out how many years are in between the two dates
		int age = Period.between(bDate, today).getYears();
		
		return age;
	}
	
	/**
	 * Method that returns in String format the information stored in the object.
	 * @return A string containing the information stored in the object
	 */
	public String toString() {
		// The following will let the system understand which newline character
		// should be used, since Windows and UNIX-based systems (Linux, Mac) have
		// different symbols representing the end of line
		String newline = System.getProperty("line.separator");
		
		// Building the string to return
		String toReturn = firstName + " " + lastName + " (ID: " + id + ", " + getEmailAddress() + ")" + newline;
		toReturn += "Birth date: " + birthDate + " (age: " + getAge() + ")" + newline;
		toReturn += "Address: " + address + newline;
		return toReturn;
	}
}
