package assignment4;

import java.util.Calendar;

/**
 * This class inherits from Person and stores additional attributes for Faculty objects
 * @author Rasa Ghaffarian
 * @since 2018-10-26
 */

public class Faculty extends Person {
	/**
	 * Constructor that sets the default values.
	 */
	public Faculty() {
		division = Person.NOT_AVAIL;
		degree = Person.NOT_AVAIL;
		yearOfGraduation = -1;
	}
	
	private String division;
	private String degree;
	private int yearOfGraduation;
	
	private final String[] degrees = {"Bachelor's", "Master's", "Doctorate"};
	
	/**
	 * Gets the Division where the faculty member works.
	 * @return String containing the name of the Division
	 */
	public String getDivision() {
		return division;
	}
	
	/**
	 * Sets the name of the Division in which the faculty member works.
	 * @param division String containing the name of the Division
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setDivision(String division) {
		if ( division == null ) return false;
		
		division = division.trim();
		
		// Incorrect length
		if ( division.length() < 3 || division.length() > 50 ) return false;
		
		// Checking for the correct characters
		if ( !division.matches("[a-zA-Z\\'\\-\\ ]+") ) return false;
		
		this.division = division;
		return true;
	}
	
	/**
	 * Gets the highest level of the degree obtained by the faculty member
	 * @return String containing the highest lever of the degree obtained by the faculty member
	 */
	public String getDegree() {
		return degree;
	}
	
	/**
	 * Sets the highest level of the degree obtained by the faculty member (Bachelor's, Master's, Doctorate)
	 * @param degree String containing the highest level of the degree obtained by the faculty member
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setDegree(String degree) {
		if ( degree == null ) return false;
		
		degree = degree.trim();
		
		// Checking if the degree is among acceptable ones
		for ( String d : degrees ) { // Example of a 'for each' loop
			if ( d.equalsIgnoreCase(degree) ) {
				this.degree = d; // We set the degree type from the array to make sure the casing is correct
				return true;
			}
		}

		// If we reach the end of the loop without any matches
		// that means that we cannot set the degree
		return false;
	}
	
	/**
	 * Gets the year of graduation of the faculty member.
	 * @return int containing the year of graduation of the faculty member
	 */
	public int getYearOfGraduation() {
		return yearOfGraduation;
	}
	
	/**
	 * Sets the year of graduation of the faculty member.
	 * @param yearOfGraduation int containing the year of graduation of the faculty member
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setYearOfGraduation(int yearOfGraduation) {
		if ( yearOfGraduation < 1950 || yearOfGraduation > Calendar.getInstance().get(Calendar.YEAR) )
			return false;
		
		this.yearOfGraduation = yearOfGraduation;
		return true;
	}
	
	/**
	 * Gets the email address of the faculty member in the appropriate format.
	 * return String containing the email address of the faculty member
	 */
	public String getEmailAddress() { // Staff and Faculty have a different way to create the email address
		// If there is either no first or last name
		if ( getFirstName().equalsIgnoreCase(NOT_AVAIL) || getLastName().equalsIgnoreCase(NOT_AVAIL) ) return NOT_AVAIL;
		
		// The first name may contain spaces, dashes, and apostrophes, which need to be removed
		String sanitizedFirstName = getFirstName().replaceAll("[\\-\\'\\ ]", "");
		// Email addresses usually utilize lower-case letters only
		sanitizedFirstName = sanitizedFirstName.toLowerCase();
		
		// The same modifications need to be applied to the last name
		String sanitizedLastName = getLastName().replaceAll("[\\-\\'\\ ]", "");
		sanitizedLastName = sanitizedLastName.toLowerCase();
		
		String emailAddress = sanitizedFirstName.charAt(0) + sanitizedLastName;
		
		emailAddress += "@ubalt.edu";
		
		return emailAddress;
	}
	
	/**
	 * Method that returns in String format the information stored in the object.
	 * @return A string containing the information stored in the object
	 */
	public String toString() {
		String newline = System.getProperty("line.separator");
		String toReturn = super.toString();
		toReturn += "Division: " + getDivision() + newline;
		toReturn += "Degree: " + getDegree() + newline;
		toReturn += "Year of Graduation: " + getYearOfGraduation() + newline;
		return toReturn;
	}
}
