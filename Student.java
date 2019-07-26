package assignment4;

/**
 * This class inherits from Person and extends additional attributes for Student objects
 * @author Rasa Ghaffarian
 * @since 2018-10-26
 */

public class Student extends Person {
	/**
	 * Constructor that sets the default values.
	 */
	public Student() {
		classStanding = Person.NOT_AVAIL;
		permanentAddress = Person.NOT_AVAIL;
		gpa = 0;
	}
	
	private String classStanding;
	private String permanentAddress;
	private double gpa;
	
	private final String[] classStandings = {"Freshmen", "Sophomore", "Junion", "Senior", "Graduate"};
	
	/**
	 * Gets the class standing of the student.
	 * @return String containing the class standing of the student
	 */
	public String getClassStanding() {
		return classStanding;
	}
	
	/**
	 * Sets the class standing of the student (Freshmen, Sophomore, Junior, Senior, Graduate)
	 * @param classStanding String containing the class standing of the student
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setClassStanding(String classStanding) {
		if ( classStanding == null )
			return false;
		
		classStanding = classStanding.trim();
		
		for ( String standing : classStandings ) {
			if ( standing.equalsIgnoreCase(classStanding) ) {
				this.classStanding = standing;
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Gets the permanent address of the student.
	 * @return String containing the permanent address of the student
	 */
	public String getPermanentAddress() {
		return permanentAddress;
	}
	
	/**
	 * Sets the permanent address of the student.
	 * @param permanentAddress String containing the permanent address of the student
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setPermanentAddress(String permanentAddress) {
		if ( permanentAddress == null )
			return false;
		
		permanentAddress = permanentAddress.trim();
		
		if ( permanentAddress.length() < 10 || permanentAddress.length() > 300 ) return false;
		
		if ( !permanentAddress.matches("[a-zA-Z0-9,.\\'\\-\\ ]+") ) return false;
		
		this.permanentAddress = permanentAddress;
		return true;
	}
	
	/**
	 * Gets the student's GPA
	 * @return double containing the student's GPA
	 */
	public double getGPA() {
		return gpa;
	}
	
	/**
	 * Sets the student's GPA (0.0-4.0).
	 * @param gpa double containing the student's GPA
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setGPA(double gpa) {
		if ( gpa < 0d || gpa > 4d )
			return false;
		
		this.gpa = gpa;
		return true;
	}
	
	/**
	 * Method that returns in String format the information stored in the object.
	 * @return A string containing the information stored in the object
	 */
	public String toString() {
		String newline = System.getProperty("line.separator");
		String toReturn = super.toString();
		toReturn += "Class standing: " + getClassStanding() + newline;
		toReturn += "Permanent address: " + getPermanentAddress() + newline;
		toReturn += "GPA: " + getGPA() + newline;
		return toReturn;
	}
}

