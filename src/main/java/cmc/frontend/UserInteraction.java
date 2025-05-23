package cmc.frontend;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import cmc.CMCException;
import cmc.backend.AccountController;
import cmc.backend.DatabaseController;
import cmc.backend.SearchController;
import cmc.backend.UniversityController;
import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.backend.entities.UserSchool;

/**
 * 
 */
public class UserInteraction {
	
	private static User loggedInUser = null;

	// other classes should *not* instantiate this class.  It is "pure static".
	private UserInteraction() throws CMCException {
		throw new CMCException("Attempt to instantiate a UserInteraction");
	}

	// attempt to login, print message, and return success or failure
	/**
	 * 
	 * @param username is the username being used to sign in
	 * @param password is the password being used to password
	 * @return true if successful
	 */
	public static boolean login(String username, String password) {
		User result = AccountController.login(username, password);
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
	/**
	 * 
	 * @return true if successful
	 */
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
	/**
	 * 
	 * @return list of all users
	 */
	public static List<User> getAllUsers() {
		return SearchController.getAllUsers();
	}
	
	// ask the admin for details and then attempt to add a user to the
	// database
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
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
		
		return AccountController.addUser(username, password, firstName, lastName, isAdmin);
	}
	
	// ask the admin for a username and then remove that user from the
	// database
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean removeUser(Scanner s) {
		System.out.print("Enter index of Username: ");
		int userIndex = 0;
		if(s.hasNextInt()){
			userIndex = s.nextInt();
		}
		else {
			System.out.println("Invalid index");
			return false;
		}
		s.nextLine();
		List<User> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex>userAmount || userIndex<1) {
			return false;
		}
		User user = allUsers.get(userIndex-1);
		String username = user.getUsername();
		
		return AccountController.removeUser(username);
	}
	
	/**
	 * search for universities that fit criteria
	 * @param s Scanner is for getting user input
	 * @return List of universitys based off the user input criteria
	 */
	public static List<University> search(Scanner s) {
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
		int maxNumberOfStudents = Integer.MAX_VALUE;
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
		int maxPercentFemale = Integer.MAX_VALUE;
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
		int maxSATVerbal = Integer.MAX_VALUE;
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
		int maxSATMath = Integer.MAX_VALUE;
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
		int maxExpenses = Integer.MAX_VALUE;
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
		int maxPercentAid = Integer.MAX_VALUE;
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
		int maxNumOfApplicants = Integer.MAX_VALUE;
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
		int maxPercentAdmitted = Integer.MAX_VALUE;
		if(maxPercentAdmittedInput!="") {
			maxPercentAdmitted = Integer.parseInt(maxPercentAdmittedInput);
		}
		System.out.print("Minimum Percent Enrolled ( blank to not search by this criterion): ");
		String minPercentEnrolledInput = s.nextLine();
		int minPercentEnrolled = 0;
		if(minPercentEnrolledInput!="") {
			minPercentEnrolled = Integer.parseInt(minPercentEnrolledInput);
		}
		System.out.print("Maximum Percent Enrolled (leave blank to not search by this criterion): ");
		String maxPercentEnrolledInput = s.nextLine();
		int maxPercentEnrolled = Integer.MAX_VALUE;
		if(maxPercentEnrolledInput!="") {
			maxPercentEnrolled = Integer.parseInt(maxPercentEnrolledInput);
		}
		System.out.print("Minimum Academic Scale ( blank to not search by this criterion): ");
		String minAcademicScaleInput = s.nextLine();
		int minAcademicScale = 0;
		if(minAcademicScaleInput!="") {
			minAcademicScale = Integer.parseInt(minAcademicScaleInput);
		}
		System.out.print("Maximum Academic Scale Enrolled (leave blank to not search by this criterion): ");
		String maxAcademicScaleInput = s.nextLine();
		int maxAcademicScale = Integer.MAX_VALUE;
		if(maxAcademicScaleInput!="") {
			maxAcademicScale = Integer.parseInt(maxAcademicScaleInput);
		}
		System.out.print("Minimum Social Scale ( blank to not search by this criterion): ");
		String minSocialScaleInput = s.nextLine();
		int minSocialScale = 0;
		if(minSocialScaleInput!="") {
			minSocialScale = Integer.parseInt(minSocialScaleInput);
		}
		System.out.print("Maximum Social Scale Enrolled (leave blank to not search by this criterion): ");
		String maxSocialScaleInput = s.nextLine();
		int maxSocialScale = Integer.MAX_VALUE;
		if(maxSocialScaleInput!="") {
			maxSocialScale = Integer.parseInt(maxSocialScaleInput);
		}
		System.out.print("Minimum Quality of Life Scale ( blank to not search by this criterion): ");
		String minQualityLifeScaleInput = s.nextLine();
		int minQualityLifeScale = 0;
		if(minQualityLifeScaleInput!="") {
			minQualityLifeScale = Integer.parseInt(minQualityLifeScaleInput);
		}
		System.out.print("Maximum Quality of Life Scale Enrolled (leave blank to not search by this criterion): ");
		String maxQualityLifeScaleInput = s.nextLine();
		int maxQualityLifeScale = Integer.MAX_VALUE;
		if(maxQualityLifeScaleInput!="") {
			maxQualityLifeScale = Integer.parseInt(maxQualityLifeScaleInput);
		}
		System.out.print("School Emphasis 1 (leave blank to not search by this criterion): ");
		String emphasis1 = s.nextLine();
		
		System.out.print("School Emphasis 2 (leave blank to not search by this criterion): ");
		String emphasis2 = s.nextLine();
		
		System.out.print("School Emphasis 3 (leave blank to not search by this criterion): ");
		String emphasis3 = s.nextLine();
		
		System.out.print("School Emphasis 4 (leave blank to not search by this criterion): ");
		String emphasis4 = s.nextLine();
		
		System.out.print("School Emphasis 5 (leave blank to not search by this criterion): ");
		String emphasis5 = s.nextLine();
		
		
		return SearchController.search(school, state, location, control, minNumberOfStudents, maxNumberOfStudents, 
				minPercentFemale, maxPercentFemale, minSATVerbal, maxSATVerbal, minSATMath, maxSATMath, 
				minExpenses, maxExpenses, minPercentAid, maxPercentAid, minNumOfApplicants, maxNumOfApplicants, 
				minPercentAdmitted, maxPercentAdmitted, minPercentEnrolled, maxPercentEnrolled, minAcademicScale, 
				maxAcademicScale, minSocialScale, maxSocialScale, minQualityLifeScale, maxQualityLifeScale, emphasis1, emphasis2, emphasis3, emphasis4, emphasis5);
	}
	
	// ask for a school name to save, and attempt to save that school
	// to the list for the currently-logged-in user
	/**
	 * save school attemps to save a school for the logged in user
	 * @param s gets user input
	 * @param schoolName
	 * @return true if successful
	 */
	
	public static boolean saveSchool(Scanner s, String schoolName) {
		//System.out.print("School Name: ");
		//String schoolName = s.nextLine();
		
		if (loggedInUser == null)
			return false;
		else
			return UniversityController.saveSchool(loggedInUser.username, schoolName);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean removeSchool(Scanner s) {
		System.out.print("School Name: ");
		String schoolName = s.nextLine();
		List<UserSchool> schools = getSavedSchools(); 
		if (loggedInUser == null)
			return false;
		for(UserSchool school : schools) {
			if(schoolName.equalsIgnoreCase(school.getUniversity())) {
				return UniversityController.removeSchool(loggedInUser.username, schoolName);
			}
		}
		return false;
	}
	
	// get the list of saved school names for the currently-logged-in user
	/**
	 * 
	 * @return the list of saved schools with time stamps for a user
	 */
	public static List<UserSchool> getSavedSchools() {
		return SearchController.getSavedSchools(loggedInUser.username);
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
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean editPassword(Scanner s){
		System.out.print("New Password: ");
		String newPassword = s.nextLine();
		if(loggedInUser==null) {
			return false;
		}
		return AccountController.editPassword(loggedInUser.username, newPassword);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean editFirstName(Scanner s){
		System.out.print("New First Name: ");
		String newFirstName = s.nextLine();
		if(loggedInUser==null) {
			return false;
		}
		return AccountController.editFirstName(loggedInUser.username, newFirstName);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean editLastName(Scanner s){
		System.out.print("New Last Name: ");
		String newLastName = s.nextLine();
		if(loggedInUser==null) {
			return false;
		}
		return AccountController.editLastName(loggedInUser.username, newLastName);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
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
		int SATVerbal = s.nextInt();
		System.out.println("SAT Math: ");
		int SATMath = s.nextInt();
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
		System.out.println("Graduation Rate: ");
		int gradRate = s.nextInt();
		System.out.println("Web Link: ");
		s.nextLine();
		String link = s.nextLine();
		
		University uni = new University(school, state, location, control, numbersOfStudents, 
				percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, 
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, gradRate, link);
		
		return UniversityController.addUniversity(uni);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean deleteUniversity(Scanner s) {
		if(loggedInUser==null) {
			return false;
		}
		System.out.print("School name: ");
		String school = s.nextLine();
		return UniversityController.deleteUniversity(school.toUpperCase());
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @param school
	 * @return true if successful
	 */
	public static boolean adminEditUniversity(Scanner s, University school) {
		System.out.println("School Name: " + school.getSchool());
		System.out.println("State: " + school.getState());
		System.out.println("Location: " + school.getLocation());
		System.out.println("Control: " + school.getControl());
		System.out.println("Number of Students: " + school.getNumStudents());
		System.out.println("Percent Female: " + school.getPercentFemale());
		System.out.println("SAT Verbal: " + school.getSATVerbal());
		System.out.println("SAT Math: " + school.getSATMath());
		System.out.println("Expenses: " + school.getExpenses());
		System.out.println("Percent Financial Aid: " + school.getPercentFA());
		System.out.println("Number of Applicants: " + school.getNumApplicants());
		System.out.println("Percent Admitted: " + school.getPercentAdmitted());
		System.out.println("Percent Enrolled: " + school.getPercentEnrolled());
		System.out.println("Academic Scale: " + school.getAcademicScale());
		System.out.println("Social Scale: " + school.getSocialScale());
		System.out.println("Quality of Life Scale: " + school.getQualLife());
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
		int SATVerbal = s.nextInt();
		System.out.println("SAT Math: ");
		int SATMath = s.nextInt();
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
		System.out.println("Graduation Rate: ");
		int gradRate = s.nextInt();
		System.out.println("Web Link: ");
		s.nextLine();
		String link = s.nextLine();
		
		University uni = new University(school.getSchool(), state, location, control, numbersOfStudents, 
				percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, 
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, gradRate, link);
		
		return UniversityController.editUniversity(uni);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean adminChangePassword(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the password you want to switch: ");
		int userIndex = s.nextInt();
		s.nextLine();
		List<User> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<0 || userIndex>userAmount) {
			return false;
		}
		User user = allUsers.get(userIndex-1);
		String username = user.getUsername();
		
		System.out.println("Enter the new password");
		String newPassword = s.nextLine();
		return AccountController.editPassword(username, newPassword);
	}
	
	/*
	 * For the admin to enter the user to change then enter the new first name for that user
	 * @param s is the scanner for the admin to enter user and new first name
	 * @return true if successful
	 */
	public static boolean adminChangeFirstName(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the First Name you want to switch: ");
		int userIndex = s.nextInt();
		s.nextLine();
		List<User> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		User user = allUsers.get(userIndex-1);
		String username = user.getUsername();
		
		System.out.println("Enter the new First Name");
		s.nextLine();
		String newFirstName = s.nextLine();
		return AccountController.editFirstName(username, newFirstName);
	}
	
	/*
	 * For the admin to enter the user to change then enter the new first name for that user
	 * @param s is the scanner for the admin to enter user and new first name
	 * @return true if successful
	 */
	public static boolean adminChangeLastName(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the Last Name you want to switch: ");
		int userIndex = s.nextInt();
		s.nextLine();
		List<User> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		User user = allUsers.get(userIndex-1);
		String username = user.getUsername();
		
		System.out.println("Enter the new Last Name");
		String newLastName = s.nextLine();
		return AccountController.editLastName(username, newLastName);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean adminDeactivateUser(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the user you want to deactivate: ");
		int userIndex = s.nextInt();
		List<User> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		User user = allUsers.get(userIndex-1);
		String username = user.getUsername();

		
		return AccountController.deactivateUser(username);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return true if successful
	 */
	public static boolean adminActivateUser(Scanner s){
		if(loggedInUser==null) {
			return false;
		}
		System.out.println("Enter the index for the user you want to activate: ");
		int userIndex = s.nextInt();
		List<User> allUsers = UserInteraction.getAllUsers();
		int userAmount = allUsers.size();
		if(userIndex<1 || userIndex>userAmount) {
			return false;
		}
		User user = allUsers.get(userIndex-1);
		String username = user.getUsername();
		
		return AccountController.activateUser(username);
	}
	
	/**
	 * 
	 * @param s gets user input
	 * @return the university selected or null
	 */
	public static University selectSchool(Scanner s) {
		System.out.println("Enter the school name: ");
		String schoolName = s.nextLine();
		List<University> schoolList = DatabaseController.getAllSchools();
		University school = null;
		for(University sch : schoolList) {
			if(sch.getSchool().equalsIgnoreCase(schoolName)) {
				school = sch;
			}
		}
		return school;
	}
	
	/**
	 * 
	 * @param school is the school that is being used to find 5 similar schools
	 * @return true if successful
	 */
	public static List<University> getFiveSimilarSchools(University school){
		return SearchController.getFiveSimilarSchools(school);
		
	}
	
}
