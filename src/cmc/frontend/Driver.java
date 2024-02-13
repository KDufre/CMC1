package cmc.frontend;

import java.util.List;
import java.util.Scanner;

import cmc.CMCException;

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
	private static void printHeader(String title) {
		String dashes = "";
		for (int i = 0; i < title.length(); i++)
			dashes += "-";

		System.out.println(dashes);
		System.out.println(title);
		System.out.println(dashes);
	}
	
	private static void adminEditUser(Scanner s) {
		printHeader("Edit User");
		List<String[]> allUsers = UserInteraction.getAllUsers();
		for (int i=0; i<allUsers.size(); i++) {
			String[] user = allUsers.get(i);
			System.out.println(i+1 + " | " + user[2] + " | " + user[0] + " | " + user[1]);
		}
		System.out.println();
		int choice = getMenuOption(s, List.of("Change a Password", "Change a first name", "Change a last name", "Deactivate User"));
		
		switch(choice) {
		case 1:
			if(!UserInteraction.adminChangePassword(s)) {
				System.out.println("Error in changing Password");
			}
			break;
		case 2:
			if(!UserInteraction.adminChangeFirstName(s)) {
				System.out.println("Error in changing First Name");
			}
		case 3:
			if(!UserInteraction.adminChangeLastName(s)) {
				System.out.println("Erro in changing Last Name");
			}
		}
	}

	private static void adminUserListMenu(Scanner s) {
		printHeader("Admin User List");

		// TODO: it would be nice if this was refactored into a list of User objects...
		
		List<String[]> allUsers = UserInteraction.getAllUsers();
		//prints username, first name, last name
		for (int i=0; i<allUsers.size(); i++) {
			String[] user = allUsers.get(i);
			System.out.println(i+1 + " | " + user[2] + " | " + user[0] + " | " + user[1]);
		}
		System.out.println();

		int choice = getMenuOption(s, List.of("Add User", "Remove User", "Edit User", "Go Back"));

		switch(choice) {
		case 1:
			if (!UserInteraction.addUser(s))
				System.out.println("Failed to add new user.  (Username already exists?)");
			break;
		case 2:
			if (!UserInteraction.removeUser(s))
				System.out.println("Failed to remove user.  (Out of range)");
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

	private static void adminMenu(Scanner s) {
		printHeader("Admin Menu");

		int choice = getMenuOption(s, List.of("View List of Users", "Add University", "Remove University", "Logout"));

		switch(choice) {
		case 1:
			adminUserListMenu(s);
			break;
		case 2:
			if(!UserInteraction.addUniversity(s))
				System.out.println("Error in adding university");
			break;
		case 3: 
			if(!UserInteraction.deleteUniversity(s))
				System.out.println("Error in removing university");
			break;
		case 4:
			UserInteraction.logout();
			break;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}

	private static void searchResultsMenu(Scanner s, List<String[]> results) {
		printHeader("Search Results");

		for (String[] school : results) {
			System.out.println(school[0] + " | " + school[1]);
		}
		System.out.println();

		int choice = getMenuOption(s, List.of("Save School", "Go Back"));

		switch(choice) {
		case 1:
			if (!UserInteraction.saveSchool(s))
				System.out.println("Failed to save school.  (Already in saved list?)");
			break;
		case 2:
			return;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}

	private static void userSavedSchoolListMenu(Scanner s) {
		printHeader("User Saved School List");

		// TODO: it would be nice if this was refactored into a list of objects
		//       so we can display some data about the school...
		List<String> schools = UserInteraction.getSavedSchools();
		if(schools==null) {
			System.out.println("NO saved schools.");
			return;
		}
		for (String school : schools) {
			System.out.println(school);
		}
		System.out.println();

		int choice = getMenuOption(s, List.of("Go Back", "Remove school"));

		switch(choice) {
		case 1:
			return;
		case 2:
			if(!UserInteraction.removeSchool(s))
				System.out.println("Failed to remove school");
			break;
		default:
			System.err.println("Internal error: Unsupported option.");
			System.exit(1);
		}
	}
	
	private static void editUser(Scanner s) {
		printHeader("Edit User");
		int choice = getMenuOption(s, List.of("Go Back", "Edit First Name", "Edit Last Name", "Edit Password"));
		switch(choice) {
		
		case 1:
			return;
		case 2:
			if(!UserInteraction.editFirstName(s)) 
				System.out.println("Error in changing first name");
			break;
		case 3:
			if(!UserInteraction.editLastName(s))
				System.out.println("Error in changing last name");
			break;
		case 4:
			if(!UserInteraction.editPassword(s)) 
				System.out.println("Error in changing password");
			break;
		}
			
	}

	private static void regularUserMenu(Scanner s) {
		printHeader("User Menu");

		int choice = getMenuOption(s, List.of("Search", "View Saved Schools", "Edit User","Logout"));

		switch(choice) {
		case 1:
			// TODO: it would be cleaner to use objects here (rather than
			//       arrays of strings)
			List<String[]> searchResult = UserInteraction.search(s);
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

	// main just forever prints the relevant menu
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
