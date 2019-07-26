package assignment4;

/**
 * This class inherits from Faculty and stores additional attributes for Part-time faculty objects
 * @author Rasa Ghaffarian
 * @since 2018-10-26
 */

public class PartTime extends Faculty {
	/**
	 * Constructor that sets the default values.
	 */
	public PartTime() {
		super();
		coursesTaught = 0;
	}
	
	private int coursesTaught;

	/**
	 * Gets the number of courses taught.
	 * @return int containing the number of courses taught
	 */
	public int getCoursesTaught() {
		return coursesTaught;
	}

	/**
	 * Sets the number of courses taught.
	 * @param coursesTaught Number of courses taught (1-100)
	 * @return Boolean value reporting whether or not the attribute was successfully updated 
	 */
	public boolean setCoursesTaught(int coursesTaught) {
		if ( coursesTaught < 1 || coursesTaught > 100 )
			return false;
		
		this.coursesTaught = coursesTaught;
		return true;
	}
	
	/**
	 * Method that returns in String format the information stored in the object.
	 * @return A string containing the information stored in the object
	 */
	public String toString() {
		String newline = System.getProperty("line.separator");
		String toReturn = super.toString();
		toReturn += "Number of courses taught: " + coursesTaught + newline;
		return toReturn;
	}
}
