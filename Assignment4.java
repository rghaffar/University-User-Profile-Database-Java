/**
 * 
 */
package assignment4;

import java.util.Scanner;

//import simplearrays.SimpleArrayList;

/**
 * @author Rasa Ghaffarian
 * The main class allows users to create a new item, edit information, or display information about the item stored
 * Up to 5 items/objects within the Person class are stored in an array
 */

public class Assignment4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("PeopleSoft");
		Scanner userInput = new Scanner(System.in);
		
		//Main loop
		boolean keepLooping = true; //Controls the main loop
		
		//Declaration of the array
		SimpleArrayList people = new SimpleArrayList();
		
		//Initialize counter that keeps track of
		//how many objects have been stored in array
		int elementsCount = 0;
		
		while (keepLooping = true) {
			//Create item
			System.out.print("\n");
			System.out.println("1) Create item");
			//Display item
			System.out.println("2) Display item");
			//Edit item
			System.out.println("3) Edit item");
			//Exit
			System.out.println("0) Exit\n");
			
			//Collect the user's input
			System.out.print("Selection: ");
			int input;
			
			//Ensure that user enters number 
			try {
				input = Integer.parseInt(userInput.nextLine());			
			}
			catch (NumberFormatException nfe) {
				System.out.println("Please enter a number"); 
				input = -1;
			}
			
			switch(input) {
			case 1: //Create
				boolean success = createEntry(people, userInput);
				if (success)
					elementsCount++;
				break;
			case 2: //Display
				int i;
				for (i = 0; i < elementsCount; i++)
					System.out.println((i+1) + ") " + people.get(i));
				System.out.println("\n");
				break;
			case 3: //Edit
				editEntry(people, userInput);
				break;
			case 0: //Exit
				System.out.println("Thank you for using PeopleSoft!");
				keepLooping = false;
				break;
			default: //Invalid input
				System.out.println("Invalid input. Try again.");
				input = -1;
			}		
		}
		userInput.close();
	}
	
	/**
	 * Method that creates objects of type Staff, Part-Time Faculty, Full-Time Faculty, Student, or Tutor
	 * @param people - Person object stored in array
	 * @param elementsCount - current number of elements stored in array
	 * @param userInput A Scanner used to collect information from the user
	 * @return boolean to validate whether object was created successfully
	 */
	public static boolean createEntry(SimpleArrayList people, Scanner userInput) {
		//Give user list of options
		System.out.print("\n");
		System.out.println("Select which type of object you would like to create:");
		System.out.println("1) Staff");
		System.out.println("2) Part-Time Faculty");
		System.out.println("3) Full-Time Faculty");
		System.out.println("4) Student");
		System.out.println("5) Tutor (Student)");
		System.out.print("\n");
		System.out.print("Selection: ");
		
		//Collect input and verify that input is a number
		int input;
		try {
			input = Integer.parseInt(userInput.nextLine());
		}
		catch (NumberFormatException nfe) {
			System.out.println("Please enter a number");
			input = -1;
		}
		
		//Create new object based on selection 
		switch (input) {
		case 1: //Staff
			Staff s = new Staff();
			people.add(s);
			getStaffInfo(s, userInput);
			return true;
		case 2: //Part-Time Faculty
			PartTime part = new PartTime();
			people.add(part);
			getPartTimeFacultyInfo(part, userInput);
			return true;
		case 3: //Full-Time Faculty
			FullTime full = new FullTime();
			people.add(full);
			getFullTimeFacultyInfo(full, userInput);
			return true;
		case 4: //Student
			Student student = new Student();
			people.add(student);
			getStudentInfo(student, userInput);
			return true;
		case 5: //Tutor
			Tutor tutor = new Tutor();
			people.add(tutor);
			getTutorInfo(tutor, userInput);
			return true;
		default: //Neither
			System.out.println("Invalid selection");
			return false;
		}	
	}
	
	public static void editEntry(SimpleArrayList people, Scanner userInput) {
		//Give user a list of items they have created
		System.out.println("Select a person to edit:");
		for (int i = 0; i < people.size(); i++) {
			System.out.println((i + 1) + ") " + people.get(i).getFirstName() + " " + people.get(i).getLastName());
		}
		System.out.print("\n");
		System.out.print("Selection: ");
	
		//Collect object selection and verify that it is a number
		int objectSelection;
		try {
			objectSelection = Integer.parseInt(userInput.nextLine()) - 1;
		}
		catch (NumberFormatException nfe) {
			System.out.println("Please enter a number");
			objectSelection = -1;
		}
		
		//Give user list of Person attributes to edit
		System.out.println("Select an item to edit:");
		System.out.println("1) First name");
		System.out.println("2) Last name");
		System.out.println("3) ID");
		System.out.println("4) Birthdate");
		System.out.println("5) Address");
		
		//If Staff, give user list of Staff attributes to edit
		if (people.get(objectSelection) instanceof Staff) {
			//Give user list of Staff attributes to edit
			System.out.println("6) Department");
			System.out.println("7) Supervisor");
		}
		//If Faculty, give user list of Faculty attributes to edit
		else if (people.get(objectSelection) instanceof Faculty) {
			System.out.println("6) Division");
			System.out.println("7) Degree");
			System.out.println("8) Year of Graduation");
			//Check if Full-Time
			if (people.get(objectSelection) instanceof FullTime) 
				System.out.println("9) Rank"); 
			//Else Part-Time
			else System.out.println("9) Number of Courses Taught");
		}
		//Check if Student
		else if (people.get(objectSelection) instanceof Student) {
			System.out.println("6) Class Standing");
			System.out.println("7) Permanent Address");
			System.out.println("8) GPA");
			//Check if Tutor
			if (people.get(objectSelection) instanceof Tutor) {
				//Tutor tempTutor = (Tutor)people[0];
				System.out.println("9) Topics");
				System.out.println("10) Hours");
			}
		}
		
		//Collect attribute selection and verify that input is a number
		System.out.print("\n");
		System.out.print("Selection: ");
		int attribute;
		try {
			attribute = Integer.parseInt(userInput.nextLine());
		}
		catch (NumberFormatException nfe) {
			System.out.println("Please enter a number");
			attribute = -1;
		}
		
		//Edit attribute based on selection
		switch (attribute) {
		case 1: //Edit first name
			do { 
				System.out.print("Please enter the first name (2-50 characters): ");
			} while(!people.get(objectSelection).setFirstName(userInput.nextLine()));
		case 2: //Edit last name
			do { 
				System.out.print("Please enter the last name (2-50 characters): ");
			} while(!people.get(objectSelection).setLastName(userInput.nextLine()));
			break;
		case 3: //Edit ID
			boolean flag = true;
	        do { 
	            try {
	                System.out.print("Enter your 5-digit ID number: ");
	                    //Ensure that ID is 5 digits 
	                    if(!(people.get(objectSelection).setId(Integer.parseInt(userInput.nextLine())))) {
	                        System.out.println("ID number not within valid range.");
	                        flag = false;
	                    }
	                    else flag = true;
	                }
	            //Ensure that ID is the correct data type, does not contain characters
	            catch (NumberFormatException e){
	                System.out.println("Error: Invalid number. Try again.\n");
	                flag = false;
	            }  
	        } 
	        while (flag == false);
	        break;
		case 4: //Edit Birth date
			do { 
				System.out.print("Please enter the birth date (YYYY/MM/DD): ");
			} while(!people.get(objectSelection).setBirthDate(userInput.nextLine()));
			break;
		case 5: //Edit Address	
			do { 
				System.out.print("Please enter the address (10-300 characters): ");
			} while(!people.get(objectSelection).setAddress(userInput.nextLine()));
			break;
		case 6: //Edit Department (Staff), Division (Faculty), Class Standing (Student)
			if (people.get(objectSelection) instanceof Staff) {
				Staff tempStaff = (Staff)people.get(objectSelection);	
				do {
					System.out.print("Please enter the Department's name (3-50 characters): ");
				} while(!(tempStaff.setDepartment(userInput.nextLine())));
			}
			else if (people.get(objectSelection) instanceof Faculty) {
				Faculty tempFaculty = (Faculty)people.get(objectSelection);
				do {
					System.out.print("Please enter the Division's name (3-50 characters): ");
				} while(!tempFaculty.setDivision(userInput.nextLine()));
			}
			else if (people.get(objectSelection) instanceof Student) {
				Student tempStudent = (Student)people.get(objectSelection);
				do {
					System.out.print("Please enter the class standing (Freshmen, Sophomore, Junior, Senior, Graduate): ");
				} while(!tempStudent.setClassStanding(userInput.nextLine()));
			}
			break;
		case 7: //Edit Supervisor (Staff), Degree (Faculty), or Permanent Address (Student)
			if (people.get(objectSelection) instanceof Staff) {
				Staff tempStaff = (Staff)people.get(objectSelection);
				do {
					System.out.print("Please enter the Supervisor's name (2-50 characters): ");
				} while(!tempStaff.setSupervisor(userInput.nextLine()));
			}
			else if (people.get(objectSelection) instanceof Faculty) {
				Faculty tempFaculty = (Faculty)people.get(objectSelection);
				do {
					System.out.print("Please enter the highest degree earned (Bachelor's, Master's, Doctorate): ");
				} while(!tempFaculty.setDegree(userInput.nextLine()));
			}
			else if (people.get(objectSelection) instanceof Student) {
				Student tempStudent = (Student)people.get(objectSelection);
				do {
					System.out.print("Please enter the permanent address (10-300 characters): ");
				} while(!tempStudent.setPermanentAddress(userInput.nextLine()));
			}
			break;
		case 8: //Edit Year of Graduation (Faculty) or GPA (Student)
			if (people.get(objectSelection) instanceof Faculty) {
				Faculty tempFaculty = (Faculty)people.get(objectSelection);
				do {
					try {
					System.out.print("Please enter the year of graduation: ");
						if (!tempFaculty.setYearOfGraduation(Integer.parseInt(userInput.nextLine()))) flag = false;
						else flag = true;
					}
					catch (NumberFormatException nfe) {
						System.out.println("Error: Invalid number. Try again.\n");
						flag = false;
					}
				}
				while(flag == false);
			}
			else if (people.get(objectSelection) instanceof Student) {
				Student tempStudent = (Student)people.get(objectSelection);
		        do { 
		            try {
		            	System.out.print("Please enter the GPA (0.0-4.0): ");
		                    if(!tempStudent.setGPA(Double.parseDouble(userInput.nextLine()))) {
		                        System.out.println("GPA not within valid range.");
		                        flag = false;
		                    }
		                    else flag = true;
		                }
		            catch (NumberFormatException e){
		                System.out.println("Error: Invalid number. Try again.\n");
		                flag = false;
		            }  
		        } 
		        while (flag == false);
			}
			break;
		case 9: //Edit Rank (Full-Time Faculty), Number of Courses Taught (Part-Time Faculty), or Topics (Tutor)
			if (people.get(objectSelection) instanceof FullTime) {
				FullTime tempFT = (FullTime)people.get(objectSelection);
				do {
					System.out.print("Enter the rank (Lecturer, Assistant Professor, Associate Professor, Full Professor): ");
				} while(!tempFT.setRank(userInput.nextLine()));
			}
			else if (people.get(objectSelection) instanceof PartTime) {
				PartTime tempPT = (PartTime)people.get(objectSelection);
				// Number of courses taught
				do {
					try {
						System.out.print("Please enter the number of courses taught (1-100): ");
						if (!(tempPT.setCoursesTaught(Integer.parseInt(userInput.nextLine())))) {
							System.out.println("Number not within valid range");
							flag = false;
						}
						else flag = true;
					}
					catch (NumberFormatException nfe) {
						System.out.println("Error: Invalid Number. Try again");
						flag = false;
					}
				}
				while (flag == true);
			}
			else if (people.get(objectSelection) instanceof Tutor) {
				Tutor tempTutor = (Tutor)people.get(objectSelection);
				do {
					System.out.print("Enter the topics of expertise (separated by commas): ");
				} while(!tempTutor.setTopics(userInput.nextLine()));
			}
		case 10: //Edit Hours(Tutor)
			Tutor tempTutor = (Tutor)people.get(objectSelection);
			do {
				try {
					System.out.print("Enter the number of hours tutored so far: ");
					if (!tempTutor.setHours(Integer.parseInt(userInput.nextLine())))
						flag = false;
					else flag = true;
				}
				catch (NumberFormatException nfe) {
					System.out.println("Error: Invalid Number. Try again");
					flag = false;
				}
			}
			while (flag == true);
		}
	} 
	
	/**
	 * Method that collects information relevant to objects of type Staff
	 * @param s An object of type Staff
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void getStaffInfo(Staff s, Scanner userInput) {
		// Since Staff inherits from Person, we can utilize the method
		// that collects information about a Person first, then we
		// will collect information related to the Staff class
		getPersonInfo(s, userInput);
		
		// Now we can collect information that belongs solely to Staff
		
		// Department
		do {
			System.out.print("Please enter the Department's name (3-50 characters): ");
		} while(!s.setDepartment(userInput.nextLine()));
		
		// Supervisor
		do {
			System.out.print("Please enter the Supervisor's name (2-50 characters): ");
		} while(!s.setSupervisor(userInput.nextLine()));
		
		
	}
	 
	 /*
	 * Method that edits information relevant to objects of type Staff
	 * @param p An object of type Person previously created by user
	 * @param userInput A Scanner used to collect information from the user
	 
	public static void editStaffInfo(Staff s, Scanner userInput) {
		//Give user list of Person attributes to edit
		System.out.println("Select an item to edit:");
		System.out.println("1) First name");
		System.out.println("2) Last name");
		System.out.println("3) ID");
		System.out.println("4) Birthdate");
		System.out.println("5) Address");
		System.out.println("6) Department");
		System.out.println("7) Supervisor");
		System.out.print("\n");
		System.out.println("Selection: ");
		
		//Verify that input is a number
		int input;
		try {
			input = Integer.parseInt(userInput.nextLine());
		}
		catch (NumberFormatException nfe) {
			System.out.println("Please enter a number");
			input = -1;
		}
		
		switch (input) {
		case 1: //Edit first name
			do { 
				System.out.print("Please enter the first name (2-50 characters): ");
			} while(!s.setFirstName(userInput.nextLine()));
		case 2: //Edit last name
			do { 
				System.out.print("Please enter the last name (2-50 characters): ");
			} while(!s.setLastName(userInput.nextLine()));
			break;
		case 3: //Edit ID
			boolean flag = true;
	        do { 
	            try {
	                System.out.print("Enter your 5-digit ID number: ");
	                    //Ensure that ID is 5 digits 
	                    if(!(s.setId(Integer.parseInt(userInput.nextLine())))) {
	                        System.out.println("ID number not within valid range.");
	                        flag = false;
	                    }
	                    else flag = true;
	                }
	            //Ensure that ID is the correct data type, does not contain characters
	            catch (NumberFormatException e){
	                System.out.println("Error: Invalid number. Try again.\n");
	                flag = false;
	            }  
	        } 
	        while (flag == false);
	        break;
		case 4: //Edit Birth date
			do { 
				System.out.print("Please enter the birth date (YYYY/MM/DD): ");
			} while(!s.setBirthDate(userInput.nextLine()));
			break;
		case 5: //Edit Address	
			do { 
				System.out.print("Please enter the address (10-300 characters): ");
			} while(!s.setAddress(userInput.nextLine()));
			break;
		case 6: //Edit Department
			do {
				System.out.print("Please enter the Department's name (3-50 characters): ");
			} while(!(s.setDepartment(userInput.nextLine())));
			break;
		case 7:
			do {
				System.out.print("Please enter the Supervisor's name (2-50 characters): ");
			} while(!(s.setSupervisor(userInput.nextLine())));
			break;
		default: //Neither
			System.out.println("Invalid Selection");
		}
	} */
	
	/**
	 * Method that collects information relevant to objects of type Faculty
	 * @param f An object of type Faculty
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void getFacultyInfo(Faculty f, Scanner userInput) {
		getPersonInfo(f, userInput);
		
		// Division
		do {
			System.out.print("Please enter the Division's name (3-50 characters): ");
		} while(!f.setDivision(userInput.nextLine()));
		
		// Degree
		do {
			System.out.print("Please enter the highest degree earned (Bachelor's, Master's, Doctorate): ");
		} while(!f.setDegree(userInput.nextLine()));
		
		// Year of graduation
		boolean flag = true;
		do {
			try {
			System.out.print("Please enter the year of graduation: ");
				if (!f.setYearOfGraduation(Integer.parseInt(userInput.nextLine()))) {
					flag = false;
				}
				else flag = true;
			}
			catch (NumberFormatException nfe) {
				System.out.println("Error: Invalid number. Try again.\n");
				flag = false;
			}
		}
		while(flag == false);
	}
	
	/**
	 * Method that collects information relevant to objects of type FullTime
	 * @param ft An object of type FullTime
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void getFullTimeFacultyInfo(FullTime ft, Scanner userInput) {
		getFacultyInfo(ft, userInput);
		
		// Rank
		do {
			System.out.print("Enter the rank (Lecturer, Assistant Professor, Associate Professor, Full Professor): ");
		} while(!ft.setRank(userInput.nextLine()));
	}
	
	/**
	 * Method that collects information relevant to objects of type PartTime
	 * @param pt An object of type PartTime
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void getPartTimeFacultyInfo(PartTime pt, Scanner userInput) {
		getFacultyInfo(pt, userInput);
		
		// Number of courses taught
		boolean flag = true;
		do {
			try {
				System.out.print("Please enter the number of courses taught (1-100): ");
				if (!(pt.setCoursesTaught(Integer.parseInt(userInput.nextLine())))) {
					System.out.println("Number not within valid range");
					flag = false;
				}
				else flag = true;
			}
			catch (NumberFormatException nfe) {
				System.out.println("Error: Invalid Number. Try again");
				flag = false;
			}
		}
		while (flag == true);
	}
	
	 /**
	 * Method that edits information relevant to objects of PartTime
	 * @param part An object of type PartTime previously created by user
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void editPartTimeInfo(PartTime part, Scanner userInput) {
		//Give user list of Person attributes to edit
		System.out.println("Select an item to edit:");
		System.out.println("1) First name");
		System.out.println("2) Last name");
		System.out.println("3) ID");
		System.out.println("4) Birthdate");
		System.out.println("5) Address");
		System.out.println("6) Division");
		System.out.println("7) Degree");
		System.out.println("8) Year of Graduation");
		System.out.println("9) Number of Courses Taught");
		System.out.print("\n");
		System.out.println("Selection: ");
		
		//Verify that input is a number
		int input;
		try {
			input = Integer.parseInt(userInput.nextLine());
		}
		catch (NumberFormatException nfe) {
			System.out.println("Please enter a number");
			input = -1;
		}
		
		switch (input) {
		case 1: //Edit first name
			do { 
				System.out.print("Please enter the first name (2-50 characters): ");
			} while(!part.setFirstName(userInput.nextLine()));
		case 2: //Edit last name
			do { 
				System.out.print("Please enter the last name (2-50 characters): ");
			} while(!part.setLastName(userInput.nextLine()));
			break;
		case 3: //Edit ID
			boolean flag = true;
	        do { 
	            try {
	                System.out.print("Enter your 5-digit ID number: ");
	                    //Ensure that ID is 5 digits 
	                    if(!(part.setId(Integer.parseInt(userInput.nextLine())))) {
	                        System.out.println("ID number not within valid range.");
	                        flag = false;
	                    }
	                    else flag = true;
	                }
	            //Ensure that ID is the correct data type, does not contain characters
	            catch (NumberFormatException e){
	                System.out.println("Error: Invalid number. Try again.\n");
	                flag = false;
	            }  
	        } 
	        while (flag == false);
	        break;
		case 4: //Edit Birth date
			do { 
				System.out.print("Please enter the birth date (YYYY/MM/DD): ");
			} while(!part.setBirthDate(userInput.nextLine()));
			break;
		case 5: //Edit Address	
			do { 
				System.out.print("Please enter the address (10-300 characters): ");
			} while(!part.setAddress(userInput.nextLine()));
			break;
		case 6: //Edit Division
			do {
				System.out.print("Please enter the Division's name (3-50 characters): ");
			} while(!part.setDivision(userInput.nextLine()));
			break;
		case 7: //Edit Degree
			do {
				System.out.print("Please enter the highest degree earned (Bachelor's, Master's, Doctorate): ");
			} while(!part.setDegree(userInput.nextLine()));
			break;
		case 8: // Edit Year of graduation
			do {
				System.out.print("Please enter the year of graduation: ");
			} while(!part.setYearOfGraduation(Integer.parseInt(userInput.nextLine())));
			break;
		case 9: //Edit number of courses taught
			
		default: //Neither
			System.out.println("Invalid Selection");
		}
	}
	/**
	 * Method that collects information relevant to objects of type Student
	 * @param s An object of type Student
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void getStudentInfo(Student s, Scanner userInput) {
		getPersonInfo(s, userInput);
		
		//Class standing
		do {
			System.out.print("Please enter the class standing (Freshmen, Sophomore, Junior, Senior, Graduate): ");
		} while(!s.setClassStanding(userInput.nextLine()));
		
		//Permanent address
		do {
			System.out.print("Please enter the permanent address (10-300 characters): ");
		} while(!s.setPermanentAddress(userInput.nextLine()));
		
		//GPA
		boolean flag = true;
        do { 
            try {
            	System.out.print("Please enter the GPA (0.0-4.0): ");
                    //Verify that GPA is in correct range 
                    if(!s.setGPA(Double.parseDouble(userInput.nextLine()))) {
                        System.out.println("GPA not within valid range.");
                        flag = false;
                    }
                    else flag = true;
                }
            //Ensure that GPA is the correct data type, does not contain characters
            catch (NumberFormatException e){
                System.out.println("Error: Invalid number. Try again.\n");
                flag = false;
            }  
        } 
        while (flag == false);
	}
	
	/**
	 * Method that collects information relevant to objects of type Tutor
	 * @param t An object of type Tutor
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void getTutorInfo(Tutor t, Scanner userInput) {
		getStudentInfo(t, userInput);
		
		// Topics
		do {
			System.out.print("Enter the topics of expertise (separated by commas): ");
		} while(!t.setTopics(userInput.nextLine()));
		
		// Hours
		boolean flag = true;
		do {
			try {
				System.out.print("Enter the number of hours tutored so far: ");
				if (!t.setHours(Integer.parseInt(userInput.nextLine())))
					flag = false;
				else flag = true;
			}
			catch (NumberFormatException nfe) {
				System.out.println("Error: Invalid Number. Try again");
				flag = false;
			}
		}
		while (flag == false);
	}
	
	/**
	 * Method that collects information relevant to objects of type Person 
	 * @param p An object of type Person
	 * @param userInput A Scanner used to collect information from the user
	 */
	public static void getPersonInfo(Person p, Scanner userInput) {
		boolean flag = true;
		do { // First name
			System.out.print("Please enter the first name (2-50 characters): ");
		} while(!p.setFirstName(userInput.nextLine()));
		
		do { // Last name
			System.out.print("Please enter the last name (2-50 characters): ");
		} while(!p.setLastName(userInput.nextLine()));
		
        do { //ID
            try {
                System.out.print("Enter your 5-digit ID number: ");
                    //Ensure that ID is 5 digits 
                    if(!(p.setId(Integer.parseInt(userInput.nextLine())))) {
                        System.out.println("ID number not within valid range.");
                        flag = false;
                    }
                    else flag = true;
                }
            //Ensure that ID is the correct data type, does not contain characters
            catch (NumberFormatException e){
                System.out.println("Error: Invalid number. Try again.\n");
                flag = false;
            }  
        } 
        while (flag == false);
		
		do { // Birth date
			System.out.print("Please enter the birth date (YYYY/MM/DD): ");
		} while(!p.setBirthDate(userInput.nextLine()));
		
		do { // Address
			System.out.print("Please enter the address (10-300 characters): ");
		} while(!p.setAddress(userInput.nextLine()));
	}
}
	
