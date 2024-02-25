package cmc.frontend;

import java.util.List;
import java.util.Scanner;

import cmc.CMCException;
import cmc.backend.DatabaseController;
import cmc.backend.SystemController;
import cmc.backend.User;

public class UserInteraction {
	
	private static User loggedInUser = null;

	// other classes should *not* instantiate this class.  It is "pure static".
	private UserInteraction() throws CMCException {
		throw new CMCException("Attempt to instantiate a UserInteraction");
	}

	// attempt to login, print message, and return success or failure
	public static boolean login(String username, String password) {
		User result = SystemController.login(username, password);
		if (result != null) {
			System.out.println("Login successful!");
			loggedInUser = result;
			return true;
		}
		else {
			System.out.println("Login failed!  Incorrect username or password.");
			loggedInUser = null;
			return false;
		}
	}
	
	// returns true if there is a user to log out, otherwise false
	public static boolean logout() {
		if (loggedInUser == null) {
			return false;
		}
		else {
			loggedInUser = null;
			return true;
		}
	}
	
	// for admins, this gets the list of all users in the system
	public static List<String[]> getAllUsers() {
		return SystemController.getAllUsers();
	}
	
	// ask the admin for details and then attempt to add a user to the
	// database
	public static boolean addUser(Scanner s) {
		System.out.print("Username: ");
		String username = s.nextLine();
		System.out.print("Password: ");
		String password = s.nextLine();
		System.out.print("First Name: ");
		String firstName = s.nextLine();
		System.out.print("Last Name: ");
		String lastName = s.nextLine();
		System.out.print("Admin? (Y or N): ");
		boolean isAdmin = false;
		if (s.nextLine().trim().equalsIgnoreCase("y"))
			isAdmin = true;
		
		return SystemController.addUser(username, password, firstName, lastName, isAdmin);
	}
	
	// ask the admin for a username and then remove that user from the
	// database
	public static boolean removeUser(Scanner s) {
		System.out.print("Enter index of Username: ");
		int userIndex = s.nextInt();
		s.nextLine();
		List<String[]> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex>userAmount || userIndex<1) {
			return false;
		}
		String[] user = allUsers.get(userIndex-1);
		String username = user[2];
		
		return SystemController.removeUser(username);
	}
	
	public static List<String[]> search(Scanner s) {
		// TODO: in the future, we would like to support searching by various
		//       criteria, but we'll settle for just state for now
		System.out.print("School Name (leave blank to not search by this criterion): ");
		String school = s.nextLine();
		System.out.print("State (leave blank to not search by this criterion): ");
		String state = s.nextLine();
		System.out.print("Location (leave blank to not search by this criterion): ");
		String location = s.nextLine();
		System.out.print("Control (leave blank to not search by this criterion): ");
		String control = s.nextLine();
		System.out.print("Minimum Number of Students (leave blank to not search by this criterion): ");
		String minNumberOfStudentsInput = s.nextLine();
		int minNumberOfStudents = 0;
		if(minNumberOfStudentsInput!="") {
			minNumberOfStudents = Integer.parseInt(minNumberOfStudentsInput);
		}
		System.out.print("Maximum Number of Students (leave blank to not search by this criterion): ");
		String maxNumberOfStudentsInput = s.nextLine();
		int maxNumberOfStudents = 0;
		if(maxNumberOfStudentsInput!="") {
			maxNumberOfStudents = Integer.parseInt(maxNumberOfStudentsInput);
		}
		System.out.print("Minimum Percent Female (leave blank to not search by this criterion): ");
		String minPercentFemaleInput = s.nextLine();
		int minPercentFemale = 0;
		if(minPercentFemaleInput!="") {
			minPercentFemale = Integer.parseInt(minPercentFemaleInput);
		}
		System.out.print("Maximum Percent Female (leave blank to not search by this criterion): ");
		String maxPercentFemaleInput = s.nextLine();
		int maxPercentFemale = 0;
		if(maxPercentFemaleInput!="") {
			maxPercentFemale = Integer.parseInt(maxPercentFemaleInput);
		}
		System.out.print("Minimum SAT Verbal (leave blank to not search by this criterion): ");
		String minSATVerbalInput = s.nextLine();
		int minSATVerbal = 0;
		if(minSATVerbalInput!="") {
			minSATVerbal = Integer.parseInt(minSATVerbalInput);
		}
		System.out.print("Maximum SAT Verbal (leave blank to not search by this criterion): ");
		String maxSATVerbalInput = s.nextLine();
		int maxSATVerbal = 0;
		if(maxSATVerbalInput!="") {
			maxSATVerbal = Integer.parseInt(maxSATVerbalInput);
		}
		System.out.print("Minimum SAT Math (leave blank to not search by this criterion): ");
		String minSATMathInput = s.nextLine();
		int minSATMath = 0;
		if(minSATMathInput!="") {
			minSATMath = Integer.parseInt(minSATMathInput);
		}
		System.out.print("Maximum SAT Math (leave blank to not search by this criterion): ");
		String maxSATMathInput = s.nextLine();
		int maxSATMath = 0;
		if(maxSATMathInput!="") {
			maxSATMath = Integer.parseInt(maxSATMathInput);
		}
		System.out.print("Minimum Expenses ( blank to not search by this criterion): ");
		String minExpensesInput = s.nextLine();
		int minExpenses = 0;
		if(minExpensesInput!="") {
			minExpenses = Integer.parseInt(minExpensesInput);
		}
		System.out.print("Maximum Expenses (leave blank to not search by this criterion): ");
		String maxExpensesInput = s.nextLine();
		int maxExpenses = 0;
		if(maxExpensesInput!="") {
			maxExpenses = Integer.parseInt(maxExpensesInput);
		}
		System.out.print("Minimum Percent Financial Aid ( blank to not search by this criterion): ");
		String minPercentAidInput = s.nextLine();
		int minPercentAid = 0;
		if(minPercentAidInput!="") {
			minPercentAid = Integer.parseInt(minPercentAidInput);
		}
		System.out.print("Maximum Percent Financial Aid (leave blank to not search by this criterion): ");
		String maxPercentAidInput = s.nextLine();
		int maxPercentAid = 0;
		if(maxPercentAidInput!="") {
			maxPercentAid = Integer.parseInt(maxPercentAidInput);
		}
		System.out.print("Minimum Number Of Applicants ( blank to not search by this criterion): ");
		String minNumOfApplicantsInput = s.nextLine();
		int minNumOfApplicants = 0;
		if(minNumOfApplicantsInput!="") {
			minNumOfApplicants = Integer.parseInt(minNumOfApplicantsInput);
		}
		System.out.print("Maximum Number Of Applicants (leave blank to not search by this criterion): ");
		String maxNumOfApplicantsInput = s.nextLine();
		int maxNumOfApplicants = 0;
		if(maxNumOfApplicantsInput!="") {
			maxNumOfApplicants = Integer.parseInt(maxNumOfApplicantsInput);
		}
		System.out.print("Minimum Percent Admitted ( blank to not search by this criterion): ");
		String minPercentAdmittedInput = s.nextLine();
		int minPercentAdmitted = 0;
		if(minPercentAdmittedInput!="") {
			minPercentAdmitted = Integer.parseInt(minPercentAdmittedInput);
		}
		System.out.print("Maximum Percent Admintted (leave blank to not search by this criterion): ");
		String maxPercentAdmittedInput = s.nextLine();
		int maxPercentAdmitted = 0;
		if(maxPercentAdmittedInput!="") {
			maxPercentAdmitted = Integer.parseInt(maxPercentAdmittedInput);
		}
		
		
		return SystemController.search(school, state, location, control, minNumberOfStudents, maxNumberOfStudents, 
				minPercentFemale, maxPercentFemale, minSATVerbal, maxSATVerbal, minSATMath, maxSATMath, 
				minExpenses, maxExpenses, minPercentAid, maxPercentAid, minNumOfApplicants, maxNumOfApplicants, 
				minPercentAdmitted, maxPercentAdmitted);
	}
	
	// ask for a school name to save, and attempt to save that school
	// to the list for the currently-logged-in user
	public static boolean saveSchool(Scanner s, String schoolName) {
		//System.out.print("School Name: ");
		//String schoolName = s.nextLine();
		
		if (loggedInUser == null)
			return false;
		else
			return SystemController.saveSchool(loggedInUser.username, schoolName);
	}
	
	public static boolean removeSchool(Scanner s) {
		System.out.print("School Name: ");
		String schoolName = s.nextLine();
		List<String> schools = getSavedSchools(); 
		if (loggedInUser == null)
			return false;
		for(String school : schools) {
			if(schoolName.equalsIgnoreCase(school)) {
				return SystemController.removeSchool(loggedInUser.username, schoolName);
			}
		}
		return false;
	}
	
	// get the list of saved school names for the currently-logged-in user
	public static List<String> getSavedSchools() {
		return SystemController.getSavedSchools(loggedInUser.username);
	}

	/**
	 * Get the current username for the current user logged in via
	 * this UserInteraction class.
	 * 
	 * @return the username for the logged in user
	 */
	public static User getLoggedInUser() {
		return loggedInUser;
	}
	
	public static boolean editPassword(Scanner s){
		System.out.print("New Password: ");
		String newPassword = s.nextLine();
		if(loggedInUser==null) {
			return false;
		}
		return SystemController.editPassword(loggedInUser.username, newPassword);
	}
	public static boolean editFirstName(Scanner s){
		System.out.print("New First Name: ");
		String newFirstName = s.nextLine();
		if(loggedInUser==null) {
			return false;
		}
		return SystemController.editFirstName(loggedInUser.username, newFirstName);
	}
	public static boolean editLastName(Scanner s){
		System.out.print("New Last Name: ");
		String newLastName = s.nextLine();
		if(loggedInUser==null) {
			return false;
		}
		return SystemController.editLastName(loggedInUser.username, newLastName);
	}
	
	public static boolean addUniversity(Scanner s) {
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("School: ");
		String school = s.nextLine();
		System.out.println("State: ");
		String state = s.nextLine();
		System.out.println("Location: ");
		String location = s.nextLine();
		System.out.println("Control : ");
		String control = s.nextLine();
		System.out.println("Number of Students: ");
		int numbersOfStudents = s.nextInt();
		System.out.println("Percent Female: ");
		double percentFemales = s.nextDouble();
		System.out.println("SAT Verbal: ");
		double SATVerbal = s.nextDouble();
		System.out.println("SAT Math: ");
		double SATMath = s.nextDouble();
		System.out.println("Expenses: ");
		double expenses = s.nextDouble();
		System.out.println("Percent Financial Aid: ");
		double percentFinancialAid = s.nextDouble();
		System.out.println("Number Of Applicants: ");
		int numberOfApplicants = s.nextInt();
		System.out.println("Percent Admitted: ");
		double percentAdmitted = s.nextDouble();
		System.out.println("Percent Enrolled: ");
		double percentEnrolled = s.nextDouble();
		System.out.println("Academics Scale: ");
		int academicsScale = s.nextInt();
		System.out.println("Social Scale: ");
		int socialScale = s.nextInt();
		System.out.println("Quality Of Life Scale: ");
		int qualityOfLifeScale = s.nextInt();
		s.nextLine();
		
		return SystemController.addUniversity(school.toUpperCase(), state, location, control, numbersOfStudents, 
				percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, 
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
	
	public static boolean deleteUniversity(Scanner s) {
		if(loggedInUser==null) {
			return false;
		}
		System.out.print("School name: ");
		String school = s.nextLine();
		return SystemController.deleteUniversity(school.toUpperCase());
	}
	
	public static boolean adminEditUniversity(Scanner s, String[] school) {
		System.out.println("School Name: " + school[0]);
		System.out.println("State: " + school[1]);
		System.out.println("Location: " + school[2]);
		System.out.println("Control: " + school[3]);
		System.out.println("Number of Students: " + school[4]);
		System.out.println("Percent Female: " + school[5]);
		System.out.println("SAT Verbal: " + school[6]);
		System.out.println("SAT Math: " + school[7]);
		System.out.println("Expenses: " + school[8]);
		System.out.println("Percent Financial Aid: " + school[9]);
		System.out.println("Number of Applicants: " + school[10]);
		System.out.println("Percent Admitted: " + school[11]);
		System.out.println("Percent Enrolled: " + school[12]);
		System.out.println("Academic Scale: " + school[13]);
		System.out.println("Social Scale: " + school[14]);
		System.out.println("Quality of Life Scale: " + school[15]);
		System.out.println();
		
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("State: ");
		String state = s.nextLine();
		System.out.println("Location: ");
		String location = s.nextLine();
		System.out.println("Control : ");
		String control = s.nextLine();
		System.out.println("Number of Students: ");
		int numbersOfStudents = s.nextInt();
		System.out.println("Percent Female: ");
		double percentFemales = s.nextDouble();
		System.out.println("SAT Verbal: ");
		double SATVerbal = s.nextDouble();
		System.out.println("SAT Math: ");
		double SATMath = s.nextDouble();
		System.out.println("Expenses: ");
		double expenses = s.nextDouble();
		System.out.println("Percent Financial Aid: ");
		double percentFinancialAid = s.nextDouble();
		System.out.println("Number Of Applicants: ");
		int numberOfApplicants = s.nextInt();
		System.out.println("Percent Admitted: ");
		double percentAdmitted = s.nextDouble();
		System.out.println("Percent Enrolled: ");
		double percentEnrolled = s.nextDouble();
		System.out.println("Academics Scale: ");
		int academicsScale = s.nextInt();
		System.out.println("Social Scale: ");
		int socialScale = s.nextInt();
		System.out.println("Quality Of Life Scale: ");
		int qualityOfLifeScale = s.nextInt();
		s.nextLine();
		
		return SystemController.editUniversity(school[0], state, location, control, numbersOfStudents, 
				percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, 
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
	
	public static boolean adminChangePassword(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the password you want to switch: ");
		int userIndex = s.nextInt();
		s.nextLine();
		List<String[]> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<0 || userIndex>userAmount) {
			return false;
		}
		String[] user = allUsers.get(userIndex-1);
		String username = user[2];
		
		System.out.println("Enter the new password");
		String newPassword = s.nextLine();
		return SystemController.editPassword(username, newPassword);
	}
	
	/*
	 * For the admin to enter the user to change then enter the new first name for that user
	 * @param s is the scanner for the admin to enter user and new first name
	 */
	public static boolean adminChangeFirstName(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the First Name you want to switch: ");
		int userIndex = s.nextInt();
		s.nextLine();
		List<String[]> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		String[] user = allUsers.get(userIndex-1);
		String username = user[2];
		
		System.out.println("Enter the new First Name");
		s.nextLine();
		String newFirstName = s.nextLine();
		return SystemController.editFirstName(username, newFirstName);
	}
	
	/*
	 * For the admin to enter the user to change then enter the new first name for that user
	 * @param s is the scanner for the admin to enter user and new first name
	 */
	public static boolean adminChangeLastName(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the Last Name you want to switch: ");
		int userIndex = s.nextInt();
		s.nextLine();
		List<String[]> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		String[] user = allUsers.get(userIndex-1);
		String username = user[2];
		
		System.out.println("Enter the new Last Name");
		String newLastName = s.nextLine();
		return SystemController.editLastName(username, newLastName);
	}
	
	public static boolean adminDeactivateUser(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the user you want to deactivate: ");
		int userIndex = s.nextInt();
		List<String[]> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		String[] user = allUsers.get(userIndex-1);
		String username = user[2];

		
		return SystemController.deactivateUser(username);
	}
	
	public static boolean adminActivateUser(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the user you want to activate: ");
		int userIndex = s.nextInt();
		List<String[]> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		String[] user = allUsers.get(userIndex-1);
		String username = user[2];
		
		return SystemController.activateUser(username);
	}
	public static String[] selectSchool(Scanner s) {
		System.out.println("Enter the school name: ");
		String schoolName = s.nextLine();
		List<String[]> schoolList = DatabaseController.getAllSchools();
		String[] school = null;
		for(String[] sch : schoolList) {
			if(sch[0].equalsIgnoreCase(schoolName)) {
				school = sch;
			}
		}
		return school;
	}
	
}
