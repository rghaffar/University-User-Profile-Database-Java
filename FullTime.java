package assignment4;

/**
 * This class inherits from Faculty and stores additional attributes for Full-time faculty objects
 * @author Rasa Ghaffarian
 * @since 2018-10-26
 */

public class FullTime extends Faculty {
	/**
	 * Constructor that sets the default values.
	 */
	public FullTime() {
		super();
		rank = Person.NOT_AVAIL;
	}

	private String rank;
	
	// List of possible values for the rank
	private final String[] ranks = {"Lecturer", "Assistant Professor", "Associate Professor", "Full Professor"};

	/**
	 * Gets the rank of the faculty member.
	 * @return String containing the rank of the faculty member
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Sets the rank of the faculty member (Lecturer, Assistant Professor, Associate Professor, Full Professor).
	 * @param rank String containing the rank of the faculty member
	 * @return Boolean reporting whether or not the attribute was successfully updated
	 */
	public boolean setRank(String rank) {
		if ( rank == null )
			return false;
		
		rank = rank.trim();
		
		for ( String r : ranks ) {
			if ( r.equalsIgnoreCase(rank) ) {
				// If there is a match, I will store the rank that is
				// contained in the array. In this way I do not have to
				// worry about the casing of the user's input.
				this.rank = r;
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Method that returns in String format the information stored in the object.
	 * @return A string containing the information stored in the object
	 */
	public String toString() {
		String newline = System.getProperty("line.separator");
		String toReturn = super.toString();
		toReturn += "Rank: " + getRank() + newline;
		return toReturn;
	}
}
