package cmc.frontend;

import java.util.List;
import java.util.Scanner;

import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.backend.entities.UserSchool;

public class Driver {

	/**
	 * Get the selected menu option based on user entry.
	 * This reads one line from the provided Scanner.
	 * 
	 * @param s the Scanner from which to read the user's input
	 * @param minChoice the minimum allowed option (inclusive)
	 * @param maxChoice the maximum allowed option (inclusive)
	 * @return the selected integer, or -1 if invalid input is entered
	 */
	private static int getSingleMenuEntry(Scanner s, int minChoice, int maxChoice) {
		String choice = s.nextLine();
		try {
			int numChoice = Integer.parseInt(choice);
			if (numChoice < minChoice || numChoice > maxChoice)
				throw new NumberFormatException("Invalid selection");
			return numChoice;
		}
		catch (Exception e) {
			// here if either a non-integer is entered or it is outside
			// the legal range of values (per min/maxChoice)
			return -1;
		}
	}

	/**
	 * Get the selected menu option based on user entry.
	 * This reads lines from the provided Scanner until the user enters
	 * a menu option (number) that matches one of the options provided
	 * (i.e., is between 1 and the number of options).
	 * 
	 * @param s the Scanner from which to read the user's input
	 * @param options the menu options the user has
	 * @return the selected menu option, as an integer (1 more than the
	 * position in the options array)
	 */
	private static int getMenuOption(Scanner s, List<String> options) {		
		int choice = -1;
		while (choice == -1) {
			System.out.println("Choose an option:");
			for (int i = 0; i < options.size(); i++) {
				System.out.println((i+1) + ": " + options.get(i));
			}
			choice = getSingleMenuEntry(s, 1, options.size());
			if (choice == -1)
				System.out.println("Invalid option.");
		}

		return choice;
	}

	// print the header for the current menu
	// @param String title for what title the method will print 
	private static void printHeader(String title) {
		String dashes = "";
		for (int i = 0; i < title.length(); i++)
			dashes += "-";

		System.out.println(dashes);
		System.out.println(title);
		System.out.println(dashes);
	}
	
	/*
	 * This is the admin edit user menu. 
	 * It allows the admin to change a user's password, first name or last name
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void adminEditUser(Scanner s) {
		printHeader("Edit User");
		List<User> allUsers = UserInteraction.getAllUsers();
		for (int i=0; i<allUsers.size(); i++) {
			User user = allUsers.get(i);
			System.out.println(i+1 + " | " + user.username + " | " + user.getFirstName() + " | " + user.getLastName());
		}
		System.out.println();
		int choice = getMenuOption(s, List.of("Change a Password", "Change a first name", "Change a last name",  "Activate User", "Deactivate User"));
		
		switch(choice) {
		case 1:
			if(!UserInteraction.adminChangePassword(s)) {
				System.out.println("Error in changing Password");
			}
			s.nextLine();
			break;
		case 2:
			if(!UserInteraction.adminChangeFirstName(s)) {
				System.out.println("Error in changing First Name");
			}
			s.nextLine();
			break;
		case 3:
			if(!UserInteraction.adminChangeLastName(s)) {
				System.out.println("Error in changing Last Name");
			}
			s.nextLine();
			break;
		case 4:
			if(!UserInteraction.adminActivateUser(s)) {
				System.out.println("Error in activating user");
			}
			s.nextLine();
			break;
		case 5:
			if(!UserInteraction.adminDeactivateUser(s)) {
				System.out.println("Error in deactivating user");
			}
			s.nextLine();
			break;
		}
	}

	/*
	 * Admin User List menu. 
	 * This menu let's the admin choose whether they would like to add a user, remove user, edit user, or go back.
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void adminUserListMenu(Scanner s) {
		printHeader("Admin User List");
		
		List<User> allUsers = UserInteraction.getAllUsers();
		//prints username, first name, last name
		for (int i=0; i<allUsers.size(); i++) {
			User user = allUsers.get(i);
			System.out.printf("| %-3d | %-10s | %-10s | %-20s |%n", i+1, user.getUsername(), user.getFirstName(), user.getLastName());
		}
		System.out.println();

		int choice = getMenuOption(s, List.of("Add User", "Remove User", "Edit User", "Go Back"));

		switch(choice) {
		case 1:
			if (!UserInteraction.addUser(s))
				System.out.println("Failed to add new user.  (Username already exists?)");
			s.nextLine();
			break;
		case 2:
			if (!UserInteraction.removeUser(s))
				System.out.println("Failed to remove user.");
			s.nextLine();
			break;
		case 3:
			adminEditUser(s);
			break;
		case 4:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}

	/*
	 * ADMIN MANAGING MENU.
	 * Let's admin add uni, remove uni, edit university, or go back.
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void adminManageUniversity(Scanner s) {
		printHeader("Admin Manage Universities");

		int choice = getMenuOption(s, List.of( "Add University", "Remove University", "Edit University", "Go back"));

		switch(choice) {
		case 1:
			if(!UserInteraction.addUniversity(s))
				System.out.println("Error in adding university");
			break;
		case 2: 
			if(!UserInteraction.deleteUniversity(s))
				System.out.println("Error in removing university");
			break;
		case 3:
			University school = UserInteraction.selectSchool(s);
			if(school==null) {
				System.out.println("Unavailable");
				break;
			}
			if(!UserInteraction.adminEditUniversity(s, school)){
				System.out.println("Error in editing university");
			}
			break;
		case 4:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}
	
	/*
	 * the admin menu is the main menu that is shown when logging in as an admin.
	 * Allows admin to view list of users or manage universities.
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void adminMenu(Scanner s) {
		printHeader("Admin Menu");

		int choice = getMenuOption(s, List.of("View List of Users", "Manage Universities", "Logout"));

		switch(choice) {
		case 1:
			adminUserListMenu(s);
			break;
		case 2:
			adminManageUniversity(s);
			break;
		case 3:
			UserInteraction.logout();
			break;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}
	
	/*
	 * This menu shows five similar schools and gives option to select or go back.
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void showFiveSimilarSchools(Scanner s, List<University> unis) {
		printHeader("Five Similar Schools");
		
		System.out.println("School Name: " + unis.get(0).getSchool());
		System.out.println("State: " + unis.get(0).getState());
		System.out.println("Location: " + unis.get(0).getLocation());
		System.out.println("Control: " + unis.get(0).getControl());
		System.out.println("Number of Students: " + unis.get(0).getNumStudents());
		System.out.println();
		System.out.println("School Name: " + unis.get(1).getSchool());
		System.out.println("State: " + unis.get(1).getState());
		System.out.println("Location: " + unis.get(1).getLocation());
		System.out.println("Control: " + unis.get(1).getControl());
		System.out.println("Number of Students: " + unis.get(1).getNumStudents());
		System.out.println();
		System.out.println("School Name: " + unis.get(2).getSchool());
		System.out.println("State: " + unis.get(2).getState());
		System.out.println("Location: " + unis.get(2).getLocation());
		System.out.println("Control: " + unis.get(2).getControl());
		System.out.println("Number of Students: " + unis.get(2).getNumStudents());
		System.out.println();
		System.out.println("School Name: " + unis.get(3).getSchool());
		System.out.println("State: " + unis.get(3).getState());
		System.out.println("Location: " + unis.get(3).getLocation());
		System.out.println("Control: " + unis.get(3).getControl());
		System.out.println("Number of Students: " + unis.get(3).getNumStudents());
		System.out.println();
		System.out.println("School Name: " + unis.get(4).getSchool());
		System.out.println("State: " + unis.get(4).getState());
		System.out.println("Location: " + unis.get(4).getLocation());
		System.out.println("Control: " + unis.get(4).getControl());
		System.out.println("Number of Students: " + unis.get(4).getNumStudents());
		System.out.println();
		
		int choice = getMenuOption(s, List.of("Select School", "Go Back"));
		
		switch(choice) {
		case 1:
			University selectedSchool = UserInteraction.selectSchool(s);
			if(selectedSchool == null) {
				System.out.println("Failed to select school (entered wrong)");
				break;
			}
			userSelectedSchoolResults(s, selectedSchool);
			break;
		case 2:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}
	
	/*
	 * This menu shows the user selected school results of the the school selected.
	 * Options: save school, view 5 similar schools, or go back.
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void userSelectedSchoolResults(Scanner s, University school) {
		printHeader("Selected School Information");
		
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
		System.out.println("Graduation Rate: " + school.getGradRate());
		System.out.println("Link to college page: " + school.getLink());
		System.out.println();
		
		int choice = getMenuOption(s, List.of("Save School", "View 5 similar schools", "Go Back"));
		
		switch(choice) {
		case 1:
			if (!UserInteraction.saveSchool(s, school.getSchool()))
				System.out.println("Failed to save school.  (Already in saved list?)");
			break;
		case 2:
			List<University> unis = UserInteraction.getFiveSimilarSchools(school);
			showFiveSimilarSchools(s, unis);
			break;
		case 3:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}
	
	/*
	 * This menu is the user selected saved school results menu.
	 * Options: go back.
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void userSelectedSavedSchoolResults(Scanner s, University school) {
		printHeader("Selected School Information");
		if(school==null) {
			System.out.println("Not a school that is saved");
			return;
		}
		
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
		System.out.println("Graduation Rate: " + school.getGradRate());
		System.out.println("Link to college page: " + school.getLink());
		System.out.println();
		
		int choice = getMenuOption(s, List.of("Go Back"));
		
		switch(choice) {
		case 1:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}

	/*
	 * This menu is the search results menu for when a user searches for unis.
	 * Options: select school or go back.
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void searchResultsMenu(Scanner s, List<University> results) {
		printHeader("Search Results");

		for (University school : results) {
			System.out.printf("| %-60s | %-20s | %-10s |%n", school.getSchool(), school.getState(), school.getLocation());
		}
		System.out.println();

		int choice = getMenuOption(s, List.of("Select School", "Go Back"));

		switch(choice) {
		case 1:
			University selectedSchool = UserInteraction.selectSchool(s);
			if(selectedSchool == null) {
				System.out.println("Failed to select school (entered wrong)");
				break;
			}
			userSelectedSchoolResults(s, selectedSchool);
			break;
		case 2:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}

	/*
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void userSavedSchoolListMenu(Scanner s) {
		printHeader("User Saved School List");

		List<UserSchool> schools = UserInteraction.getSavedSchools();
		if(schools==null) {
			System.out.println("No saved schools.");
			return;
		}
		for (UserSchool school : schools) {
			System.out.printf("| %-60s | %-25s | %n", school.getUniversity(), school.getTimestamp());
		}
		System.out.println();
		
		int choice = getMenuOption(s, List.of("Remove school", "Select Saved School to View Stats", "Go back"));

		switch(choice) {
		case 1:
			if(!UserInteraction.removeSchool(s))
				System.out.println("Failed to remove school");
			break;
		case 2:
			University selectedSchool = UserInteraction.selectSchool(s);
			userSelectedSavedSchoolResults(s,selectedSchool);
			break;
		case 3:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}
	
	/*
	 * This is the edit user menu
	 * Options: edit password, edit first name, edit last name, or go back.s
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void editUser(Scanner s) {
		printHeader("Edit User");
		int choice = getMenuOption(s, List.of("Edit Password", "Edit First Name", "Edit Last Name", "Go Back" ));
		switch(choice) {
		
		case 1:
			if(!UserInteraction.editPassword(s)) 
				System.out.println("Error in changing password");
			break;
		case 2:
			if(!UserInteraction.editFirstName(s)) 
				System.out.println("Error in changing first name");
			break;
		case 3:
			if(!UserInteraction.editLastName(s))
				System.out.println("Error in changing last name");
			break;
		case 4:
			return;
		}
			
	}

	/*
	 * This is the regular user menu shown when logging in to a user profile.
	 * Options: Search, view saved schools, edit user, logout
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void regularUserMenu(Scanner s) {
		printHeader("User Menu");

		int choice = getMenuOption(s, List.of("Search", "View Saved Schools", "Edit User", "Logout"));

		switch(choice) {
		case 1:
			List<University> searchResult = UserInteraction.search(s);
			searchResultsMenu(s, searchResult);
			break;
		case 2:
			userSavedSchoolListMenu(s);
			break;
		case 3:
			editUser(s);
			break;
		case 4:
			UserInteraction.logout();
			break;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}

	/*
	 * This menu asks for username and password and attempts to log in
	 * @param Scanner s is to pass to UserInteraction to get user input
	 */
	private static void topMenu(Scanner s) {
		printHeader("Welcome to Choose My College (CMC)!");
		System.out.println("Please log in.");

		String username = "";
		while (username.isBlank()) {
			System.out.print("Username: ");
			username = s.nextLine();
		}

		System.out.print("Password: ");
		String password = s.nextLine();

		boolean success = UserInteraction.login(username, password);
		if (success)
			System.out.println("Redirecting to main menu.");
	}

	/*
	 * main just forever prints the relevant menu
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			if (UserInteraction.getLoggedInUser() == null)
				topMenu(s);
			else if (UserInteraction.getLoggedInUser().isAdmin())
				adminMenu(s);
			else
				regularUserMenu(s);
		}
	}
}
