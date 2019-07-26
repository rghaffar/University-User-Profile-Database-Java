package assignment4;

/**
 * This class inherits from Student, extends attributes for tutor objects, and implements attributes/methods from Employee
 * @author Rasa Ghaffarian
 * @since 2018-10-26
 */

public class Tutor extends Student {
	/**
	 * Constructor that sets the default values.
	 */
	public Tutor() {
		topics = Person.NOT_AVAIL;
		hours = 0;
	}
	
	private String topics;
	private int hours;
	
	/**
	 * Gets the list of topics that the tutor can teach.
	 * @return String containing the list of topics that the tutor can teach
	 */
	public String getTopics() {
		return topics;
	}
	
	/**
	 * Sets the topics that the tutor can teach
	 * @param topics List of topics in String format
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setTopics(String topics) {
		if ( topics == null )
			return false;
		
		topics = topics.trim();
		
		if ( !topics.matches("[a-zA-Z,\\ ]+") ) return false;
		
		this.topics = topics;
		return true;
	}
	
	/**
	 * Gets the number of hours that the tutor has completed.
	 * @return int containing the number of hours that the tutor has completed
	 */
	public int getHours() {
		return hours;
	}
	
	/**
	 * Sets the number of hours that a tutor has already completed.
	 * @param hours Number of hours that a tutor has already completed
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setHours(int hours) {
		if ( hours < 0 || hours > 1000 )
			return false;
		
		this.hours = hours;
		return true;
	}
	
	/**
	 * Method that returns in String format the information stored in the object.
	 * @return A string containing the information stored in the object
	 */
	public String toString() {
		String newline = System.getProperty("line.separator");
		String toReturn = super.toString();
		toReturn += "Topics: " + getTopics() + newline;
		toReturn += "Hours tutored: " + getHours() + newline;
		return toReturn;
	}
}
