package assignment3;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class Assignment3test {

	// Testing the first name ---------------------------------------------
	
	@Test
	public void testCorrectFirstName() {
		String input = "John";
		Person p = new Person();
		p.setFirstName(input);
		assertEquals(input, p.getFirstName());
	}
	
	@Test
	public void testShortFirstName() {
		String input = "X";
		Person p = new Person();
		p.setFirstName(input);
		assertNotEquals(input, p.getFirstName());
	}
	
	@Test
	public void testLongFirstName() {
		String input = "mcfzsjeullikctwpydcorzbyhzcpnvjsinqzvxrmymzuylhzmugdxstfrklpuhspbesyxkmzpeopgl";
		Person p = new Person();
		p.setFirstName(input);
		assertNotEquals(input, p.getFirstName());
	}
	
	@Test
	public void testNullFirstName() {
		Person p = new Person();
		p.setFirstName(null);
		assertNotNull(p.getFirstName());
	}
	
	@Test
	public void testInvalidCharacterFirstName() {
		String input = "\"$teve\"";
		Person p = new Person();
		p.setFirstName(input);
		assertNotEquals(input, p.getFirstName());
	}
	
	// Testing the last name ---------------------------------------------
	
	@Test
	public void testCorrectLastName() {
		String input = "Doe";
		Person p = new Person();
		p.setLastName(input);
		assertEquals(input, p.getLastName());
	}
	
	@Test
	public void testShortLastName() {
		String input = "X";
		Person p = new Person();
		p.setLastName(input);
		assertNotEquals(input, p.getLastName());
	}
	
	@Test
	public void testLongLastName() {
		String input = "mcfzsjeullikctwpydcorzbyhzcpnvjsinqzvxrmymzuylhzmugdxstfrklpuhspbesyxkmzpeopgl";
		Person p = new Person();
		p.setLastName(input);
		assertNotEquals(input, p.getLastName());
	}
	
	@Test
	public void testNullLastName() {
		Person p = new Person();
		p.setLastName(null);
		assertNotNull(p.getLastName());
	}
	
	@Test
	public void testInvalidCharacterLastName() {
		String input = "\"$tevens\"";
		Person p = new Person();
		p.setLastName(input);
		assertNotEquals(input, p.getLastName());
	}
	
	// Testing the ID ---------------------------------------------

	@Test
	public void testShortId() {
		int input = 1000;
		Person p = new Person();
		p.setID(input);
		assertNotEquals(input, p.getID());
	}

	@Test
	public void testValidId() {
		int input = 10000;
		Person p = new Person();
		p.setID(input);
		assertEquals(input, p.getID());
	}

	@Test
	public void testLongtId() {
		int input = 100000;
		Person p = new Person();
		p.setID(input);
		assertNotEquals(input, p.getID());
	}
	
	// Testing the birth date ---------------------------------------------
	
	@Test
	public void testCorrectBirthDate() {
		String input = "2000/01/01";
		Person p = new Person();
		p.setBirthDate(input);
		assertEquals(input, p.getBirthDate());
	}
	
	@Test
	public void testIncorrectFormatBirthDate() {
		String input = "2000-01-01";
		Person p = new Person();
		p.setBirthDate(input);
		assertNotEquals(input, p.getBirthDate());
	}
	
	@Test
	public void testNullBirthDate() {
		String input = null;
		Person p = new Person();
		p.setBirthDate(input);
		assertNotEquals(input, p.getBirthDate());
	}
	
	@Test
	public void testExtraCharactersBirthDate() {
		String input = "200O-01-01";
		Person p = new Person();
		p.setBirthDate(input);
		assertNotEquals(input, p.getBirthDate());
	}
	
	// Testing the address ---------------------------------------------
	
	@Test
	public void testCorrectAddress() {
		String input = "1420 N. Charles Street, Baltimore, MD 21201";
		Person p = new Person();
		p.setAddress(input);
		assertEquals(input, p.getAddress());
	}
	
	@Test
	public void testShortAddress() {
		String input = "Baltimore";
		Person p = new Person();
		p.setAddress(input);
		assertNotEquals(input, p.getAddress());
	}
	
	@Test
	public void testLongAddress() {
		String input = "HIhC386VXsXrBEtG2HPmjvDLyFUFlaKwRXQMg3MpfaByyiKO2EBTiv5PobuqjZDmCZnGajfHCzrWFoY4sHmWcOipXNCwh8DIyWVkchDXqbZYyEllps9LXnQVBVyCQ6rhEbw8YUINYh0jEqvtvaAcjTsZ2M5yyhUNGnkgZr0Bq7Ohpeg17fwwLXY6aoaLlY950s6S5WhTOlFZruNuNyRzxYqjPmuUe7ayuDsecOWWYCOb9e8mWPvMeDP7pMqkKmZo0KEXV4M7tQMdcbp5sVaIndCX3Z7nR8dgRrafCg0JRhoqA";
		Person p = new Person();
		p.setAddress(input);
		assertNotEquals(input, p.getAddress());
	}
	
	@Test
	public void testInvalidCharacterAddress() {
		String input = "1420 N. Charles $treet, Baltimore, MD 21201";
		Person p = new Person();
		p.setAddress(input);
		assertNotEquals(input, p.getAddress());
	}
	
	@Test
	public void testNullAddress() {
		String input = null;
		Person p = new Person();
		p.setAddress(input);
		assertNotEquals(input, p.getAddress());
	}
	
	// Testing the age ---------------------------------------------
	
	@Test
	public void testCorrectAge() {
		String input = "2000/01/01";
		Person p = new Person();
		p.setBirthDate(input);
		assertEquals(18, p.getAge(p.BirthDate));
	}
	
	@Test
	public void testIncorrectAge() {
		String input = "2000/01/01";
		Person p = new Person();
		p.setBirthDate(input);
		assertNotEquals(20, p.getAge(p.BirthDate));
	}
	
	// Testing the email address ---------------------------------------------
	
	@Test public void testCorrectEmailAddress() {
		Person p = new Person();
		p.setFirstName("Mary Jane");
		p.setLastName("Watson");
		assertEquals("maryjane.watson@ubalt.edu", p.getEmail(p.getFirstName(), p.getLastName()));
	}
	
	// Testing the Department ---------------------------------------------
	
	@Test
	public void testCorrectDepartmentName() {
		String input = "Accounting";
		Staff s = new Staff();
		s.setDepartment(input);
		assertEquals(input, s.getDepartment());
	}
	
	@Test
	public void testShortDepartmentName() {
		String input = "IT";
		Staff s = new Staff();
		s.setDepartment(input);
		assertNotEquals(input, s.getDepartment());
	}
	
	@Test
	public void testLongDepartmentName() {
		String input = "mcfzsjeullikctwpydcorzbyhzcpnvjsinqzvxrmymzuylhzmugdxstfrklpuhspbesyxkmzpeopgl";
		Staff s = new Staff();
		s.setDepartment(input);
		assertNotEquals(input, s.getDepartment());
	}
	
	@Test
	public void testNullDepartmentName() {
		Staff s = new Staff();
		s.setDepartment(null);
		assertNotNull(s.getDepartment());
	}
	
	@Test
	public void testInvalidCharacterDepartmentName() {
		String input = "Public Relation$";
		Staff s = new Staff();
		s.setDepartment(input);
		assertNotEquals(input, s.getDepartment());
	}
	
	// Testing the Supervisor ---------------------------------------------
	
	@Test
	public void testCorrectSupervisor() {
		String input = "Molly";
		Staff s = new Staff();
		s.setSupervisor(input);
		assertEquals(input, s.getSupervisor());
	}
	
	@Test
	public void testShortSupervisor() {
		String input = "J";
		Staff s = new Staff();
		s.setSupervisor(input);
		assertNotEquals(input, s.getSupervisor());
	}
	
	@Test
	public void testLongSupervisor() {
		String input = "mcfzsjeullikctwpydcorzbyhzcpnvjsinqzvxrmymzuylhzmugdxstfrklpuhspbesyxkmzpeopgl";
		Staff s = new Staff();
		s.setSupervisor(input);
		assertNotEquals(input, s.getSupervisor());
	}
	
	@Test
	public void testNullSupervisor() {
		Staff s = new Staff();
		s.setSupervisor(null);
		assertNotNull(s.getSupervisor());
	}
	
	@Test
	public void testInvalidCharacterSupervisor() {
		String input = "$teve";
		Staff s = new Staff();
		s.setSupervisor(input);
		assertNotEquals(input, s.getSupervisor());
	}
	
	// Testing the division ---------------------------------------------
	
	@Test
	public void testCorrectDivisionName() {
		String input = "SIAT";
		Faculty f = new Faculty();
		f.setDivision(input);
		assertEquals(input, f.getDivision());
	}
	
	@Test
	public void testShortDivisionName() {
		String input = "IT";
		Faculty f = new Faculty();
		f.setDivision(input);
		assertNotEquals(input, f.getDivision());
	}
	
	@Test
	public void testLongDivisionName() {
		String input = "mcfzsjeullikctwpydcorzbyhzcpnvjsinqzvxrmymzuylhzmugdxstfrklpuhspbesyxkmzpeopgl";
		Faculty f = new Faculty();
		f.setDivision(input);
		assertNotEquals(input, f.getDivision());
	}
	
	@Test
	public void testNullDivisionName() {
		Faculty f = new Faculty();
		f.setDivision(null);
		assertNotNull(f.getDivision());
	}
	
	@Test
	public void testInvalidCharacterDivisionName() {
		String input = "$IAT";
		Faculty f = new Faculty();
		f.setDivision(input);
		assertNotEquals(input, f.getDivision());
	}
	
	// Testing the degree ---------------------------------------------
	
	@Test
	public void testCorrectDegree() {
		String input = "Bachelor's";
		Faculty f = new Faculty();
		f.setDegree(input);
		assertEquals(input, f.getDegree());
	}
	
	@Test
	public void testIncorrectDegree() {
		String input = "Bachelors";
		Faculty f = new Faculty();
		f.setDegree(input);
		assertNotEquals(input, f.getDegree());
	}
	
	@Test
	public void testNullDegree() {
		Faculty f = new Faculty();
		f.setDegree(null);
		assertNotNull(f.getDegree());
	}
	
	// Testing the year of graduation ---------------------------------------------
	
	@Test
	public void testCorrectYearOfGraduation() {
		int input = 2010;
		Faculty f = new Faculty();
		f.setGradYear(input);
		assertEquals(input, f.getGradYear());
	}
	
	@Test
	public void testEarlyYearOfGraduation() {
		int input = 1949;
		Faculty f = new Faculty();
		f.setGradYear(input);
		assertNotEquals(input, f.getGradYear());
	}
	
	@Test
	public void testLateYearOfGraduation() {
		int input = Calendar.getInstance().get(Calendar.YEAR) + 1;
		Faculty f = new Faculty();
		f.setGradYear(input);
		assertNotEquals(input, f.getGradYear());
	}
	
	// Testing rank ---------------------------------------------
	
	@Test
	public void testCorrectRank() {
		String input = "Associate Professor";
		FullTime ft = new FullTime();
		ft.setRank(input);
		assertEquals(input, ft.getRank());
	}
	
	@Test
	public void testIncorrectRank() {
		String input = "Assoc. Professor";
		FullTime ft = new FullTime();
		ft.setRank(input);
		assertNotEquals(input, ft.getRank());
	}
	
	@Test
	public void testNullRank() {
		FullTime ft = new FullTime();
		ft.setRank(null);
		assertNotNull(ft.getRank());
	}
	
	// Testing courses taught ---------------------------------------------
	
	@Test
	public void testCorrectCoursesTaught() {
		int input = 15;
		PartTime pt = new PartTime();
		pt.setCourse(input);
		assertEquals(input, pt.getCourse());
	}
	
	@Test
	public void testLowCoursesTaught() {
		int input = -1;
		PartTime pt = new PartTime();
		pt.setCourse(input);
		assertNotEquals(input, pt.getCourse());
	}
	
	@Test
	public void testHighCoursesTaught() {
		int input = 101;
		PartTime pt = new PartTime();
		pt.setCourse(input);
		assertNotEquals(input, pt.getCourse());
	}
	
	// Testing class standing taught ---------------------------------------------
	/*
	@Test
	public void testCorrectClassStanding() {
		String input = "Sophomore";
		Student s = new Student();
		s.setClassStanding(input);
		assertEquals(input, s.getClassStanding());
	}
	
	@Test
	public void testIncorrectClassStanding() {
		String input = "Jr";
		Student s = new Student();
		s.setClassStanding(input);
		assertNotEquals(input, s.getClassStanding());
	}
	
	@Test
	public void testNullClassStanding() {
		Student s = new Student();
		s.setClassStanding(null);
		assertNotNull(s.getClassStanding());
	}
	
	// Testing the permanent address ---------------------------------------------
	
	@Test
	public void testCorrectPermanentAddress() {
		String input = "1420 N. Charles Street, Baltimore, MD 21201";
		Student s = new Student();
		s.setPermanentAddress(input);
		assertEquals(input, s.getPermanentAddress());
	}
	
	@Test
	public void testShortPermanentAddress() {
		String input = "Baltimore";
		Student s = new Student();
		s.setPermanentAddress(input);
		assertNotEquals(input, s.getPermanentAddress());
	}
	
	@Test
	public void testLongPermanentAddress() {
		String input = "HIhC386VXsXrBEtG2HPmjvDLyFUFlaKwRXQMg3MpfaByyiKO2EBTiv5PobuqjZDmCZnGajfHCzrWFoY4sHmWcOipXNCwh8DIyWVkchDXqbZYyEllps9LXnQVBVyCQ6rhEbw8YUINYh0jEqvtvaAcjTsZ2M5yyhUNGnkgZr0Bq7Ohpeg17fwwLXY6aoaLlY950s6S5WhTOlFZruNuNyRzxYqjPmuUe7ayuDsecOWWYCOb9e8mWPvMeDP7pMqkKmZo0KEXV4M7tQMdcbp5sVaIndCX3Z7nR8dgRrafCg0JRhoqA";
		Student s = new Student();
		s.setPermanentAddress(input);
		assertNotEquals(input, s.getPermanentAddress());
	}
	
	@Test
	public void testInvalidCharacterPermanentAddress() {
		String input = "1420 N. Charles $treet, Baltimore, MD 21201";
		Student s = new Student();
		s.setPermanentAddress(input);
		assertNotEquals(input, s.getPermanentAddress());
	}
	
	@Test
	public void testNullPermanentAddress() {
		Student s = new Student();
		s.setPermanentAddress(null);
		assertNotNull(s.getPermanentAddress());
	}
	
	// Testing the GPA ---------------------------------------------
	
	@Test
	public void testCorrectGPA() {
		double input = 3.1d;
		Student s = new Student();
		s.setGPA(input);
		assertEquals(input, s.getGPA(), 0.01); // Includes a precision loss of +/-0.01
	}
	
	@Test
	public void testLowGPA() {
		double input = -0.5d;
		Student s = new Student();
		s.setGPA(input);
		assertNotEquals(input, s.getGPA(), 0.01); // Includes a precision loss of +/-0.01
	}

	@Test
	public void testHighGPA() {
		double input = 4.5d;
		Student s = new Student();
		s.setGPA(input);
		assertNotEquals(input, s.getGPA(), 0.01); // Includes a precision loss of +/-0.01
	}
	
	// Testing the tutoring topics ---------------------------------------------
	
	@Test
	public void testCorrectTopics() {
		String input = "Programming, Math, Networking";
		Tutor t = new Tutor();
		t.setTopics(input);
		assertEquals(input, t.getTopics());
	}
	
	@Test
	public void testInvalidCharactersTopics() {
		String input = "O$, Math, Networking";
		Tutor t = new Tutor();
		t.setTopics(input);
		assertNotEquals(input, t.getTopics());
	}
	
	@Test
	public void testNullTopics() {
		Tutor t = new Tutor();
		t.setTopics(null);
		assertNotNull(t.getTopics());
	}
	
	// Testing the tutoring hours ---------------------------------------------
	
	@Test
	public void testCorrectHours() {
		int input = 10;
		Tutor t = new Tutor();
		t.setHours(input);
		assertEquals(input, t.getHours());
	}
	
	@Test
	public void testLowHours() {
		int input = -1;
		Tutor t = new Tutor();
		t.setHours(input);
		assertNotEquals(input, t.getHours());
	}

	@Test
	public void testHighHours() {
		int input = 1001;
		Tutor t = new Tutor();
		t.setHours(input);
		assertNotEquals(input, t.getHours());
	}
	*/
	// Testing the email address for faculty and staff ---------------------------------------------
	
	@Test
	public void testStaffEmail() {
		Staff s = new Staff();
		s.setFirstName("Peter");
		s.setLastName("Parker");
		assertEquals("pparker@ubalt.edu", s.getEmail(s.getFirstName(),s.getLastName()));
	}
	
	@Test
	public void testFacultyEmail() {
		Faculty s = new Faculty();
		s.setFirstName("Otto Gunther");
		s.setLastName("Octavius");
		assertEquals("ooctavius@ubalt.edu", s.getEmail(s.getFirstName(),s.getLastName()));
	}

	// Testing the salary ---------------------------------------------
	
	//Tests correctly entered salary (non-zero integer) for Faculty object
	//setSalary method in Faculty class returns salary value if entry is a positive integer
	@Test
	public void testValidFacultySalary() {
		int input = 40000;
		Faculty f = new Faculty();
		f.setSalary(input);
		assertEquals(input, f.getSalary());
	}
	
	//Tests correctly entered salary (non-zero integer) for Staff object
	//setSalary method in Staff class returns salary value if entry is a positive integer
	@Test
	public void testValidStaffSalary() {
		int input = 40000;
		Staff s = new Staff();
		s.setSalary(input);
		assertEquals(input, s.getSalary());
	}
	
	//Tests for invalid entry for salary
	//setSalary method returns false if salary entered has a negative value
	@Test
	public void testInvalidSalary() {
		int input = 0;
		Faculty f = new Faculty();
		f.setSalary(input);
		assertNotEquals(input, f.getSalary());
	}
	
	
	// Testing the start date ---------------------------------------------
	
	//Tests that start date is correct format (YYYY/MM/DD) in Faculty class
	//setStartDate returns start date value if format is correct
	@Test
	public void testCorrectFacultyStartDate() {
		String input = "2015/01/01";
		Faculty f = new Faculty();
		f.setStartDate(input);
		assertEquals(input, f.getStartDate());
	}
	
	//Tests whether start date is correct format (YYYY/MM/DD) in Staff class
	//setStartDate returns start date value if format is correct
	@Test
	public void testCorrectStaffStartDate() {
		String input = "2015/01/01";
		Staff s = new Staff();
		s.setStartDate(input);
		assertEquals(input, s.getStartDate());
	}
	
	//Tests whether start date is incorrect format 
	//setStartDate returns false if format is incorrect
	@Test
	public void testIncorrectFormatStartDate() {
		String input = "2015-01-01";
		Faculty f = new Faculty();
		f.setStartDate(input);
		assertNotEquals(input, f.getStartDate());
	}
	
	//Tests whether start date is null 
	//setStartDate returns false if String entry is null
	@Test
	public void testNullStartDate() {
		String input = null;
		Faculty f = new Faculty();
		f.setStartDate(input);
		assertNotEquals(input, f.getStartDate());
	}
	
	//Tests whether start date has no extra characters 
	//setStartDate returns false if year, month, or date contains non-integers 
	@Test
	public void testExtraCharactersStartDate() {
		String input = "200O/01/01";
		Faculty f = new Faculty();
		f.setStartDate(input);
		assertNotEquals(input, f.getStartDate());
	}
	
	
	}


