package cmc.frontend;

import java.util.List;
import java.util.Scanner;

import cmc.CMCException;
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
		System.out.print("Username: ");
		String username = s.nextLine();

		return SystemController.removeUser(username);
	}
	
	public static List<String[]> search(Scanner s) {
		// TODO: in the future, we would like to support searching by various
		//       criteria, but we'll settle for just state for now
		System.out.print("State (leave blank to not search by this criterion): ");
		String state = s.nextLine();
		
		return SystemController.search(state);
	}
	
	// ask for a school name to save, and attempt to save that school
	// to the list for the currently-logged-in user
	public static boolean saveSchool(Scanner s) {
		System.out.print("School Name: ");
		String schoolName = s.nextLine();
		List<String> schools = getSavedSchools(); 
		for(String school : schools) {
			if(schoolName.equalsIgnoreCase(school)) {
				System.out.println("Already saved");
				return false;
			}
		}

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
}
