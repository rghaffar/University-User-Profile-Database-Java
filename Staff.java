package assignment4;

/**
 * This class inherits from Person and stores additional attributes for Staff objects
 * @author Rasa Ghaffarian
 * @since 2018-10-26
 */

public class Staff extends Person {
	/**
	 * Constructor that sets the default values.
	 */
	public Staff() {
		super();
		department = Person.NOT_AVAIL;
		supervisor = Person.NOT_AVAIL;
	}
	private String department;
	private String supervisor;
	
	/**
	 * Gets the Department where the staff member works
	 * @return String containing the name of the Department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * Sets the name of the Department where the staff member works
	 * @param department String containing the name of the department
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setDepartment(String department) {
		if ( department == null )
			return false;
		
		department = department.trim();// Incorrect length
		
		if ( department.length() < 3 || department.length() > 50 ) return false;
		
		// Checking for the correct characters
		if ( !department.matches("[a-zA-Z\\'\\-\\ ]+") ) return false;
		
		this.department = department;
		return true;
	}
	
	/**
	 * Gets the name of the staff member's supervisor.
	 * @return String containing the name of the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}
	
	/**
	 * Sets the name of the staff member's supervisor
	 * @param supervisor String containing the name of the supervisor
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setSupervisor(String supervisor) {
		if ( supervisor == null )
			return false;
		
		supervisor = supervisor.trim();// Incorrect length
		
		if ( supervisor.length() < 2 || supervisor.length() > 50 ) return false;
		
		// Checking for the correct characters
		if ( !supervisor.matches("[a-zA-Z\\'\\-\\ ]+") ) return false;
		
		this.supervisor = supervisor;
		return true;
	}
	
	/**
	 * Gets the email address of the staff member in the appropriate format.
	 * return String containing the email address of the staff member
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
		toReturn += "Department: " + getDepartment() + newline;
		toReturn += "Supervisor: " + getSupervisor() + newline;
		return toReturn;
	}
}

