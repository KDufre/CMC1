package cmc.backend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cmc.CMCException;
import dblibrary.project.csci230.*;

/**
 * The DatabaseController class is the primary interaction class with the
 * database library.  It currently just calls the lower-level methods and
 * forwards the result (possibly throwing some exceptions along the way).
 * 
 * @author Sally Sparrow
 */
public class DatabaseController {
	// TODO: we'll need to update this to our team's actual database someday!
	private static UniversityDBLibrary database = new UniversityDBLibrary("csci230", "csci230");

	// add a user to the db
	// TODO: it would be nice if this could take a User object instead
	// (so "higher-abstraction" classes don't have to worry about the order
	//  of properties)
	public static boolean addUser(String username, String password, char type,
			String firstName, String lastName) throws CMCException {
		int result = database.user_addUser(firstName, lastName, username, password, type);
		
		if (result == -1) {
			throw new CMCException("Error adding user to the DB");
		}
		else {
			return true;
		}
	}
	
	// remove a user from the db
	public static boolean removeUser(String username) throws CMCException {
		int result = database.user_deleteUser(username);
		if (result != 1) {
			// TODO: How can we tell the difference?
			throw new CMCException("Error removing user from the DB.  Not present?  DB error?");
		}
		else {
			return true;
		}
	}
	
	// get a user; null if not in DB
	public static String[] getUser(String username) {
		String[][] databaseUserStrings = database.user_getUsers();
		
		for (String[] singleUser : databaseUserStrings) {
			String thisUsername = singleUser[2];
			if (thisUsername.equals(username)) {
				return singleUser;
			}
		}
		
		return null;
	}
	
	// get the list of all the users in the DB
	public static List<String[]> getAllUsers() {
		String[][] dbUserList = database.user_getUsers();
		
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (String[] user : dbUserList) {
			result.add(user);
		}
		
		return result;
	}
	
	// get the list of all the universities in the DB
	public static List<String[]> getAllSchools() {
		String[][] dbUniversityList = database.university_getUniversities();

		ArrayList<String[]> result = new ArrayList<String[]>();
		for (String[] school : dbUniversityList) {
			result.add(school);
		}

		return result;
	}
	
	// save a school to a particular user's list
	// TODO: It feels like we should be able to do this as part of
	//       "updating" a user in the DB.
	public static boolean saveSchool(String username, String schoolName) {
		int result = database.user_saveSchool(username, schoolName);
		if (result != 1) {
			// TODO: How can we tell the difference?
			throw new Error("Error saving school to user in the DB.  Already present?  DB error?");
		}
		else {
			return true;
		}
	}
	
	public static boolean removeSchool(String username, String schoolName) {
		int result = database.user_removeSchool(username, schoolName);
		if (result != 1) {
			throw new Error("Error in removing school");
		}
		else {
			return true;
		}
	}
	
	public static boolean removeUserSavedSchools(String username) {
		Map<String, List<String>> result = getUserSavedSchoolMap();
		List<String> userList = result.get(username);
		for(String school : userList) {
			removeSchool(username, school);
		}
		
		return true;
	}
	
	// get the mapping from users to their saved universities in the DB
	// e.g., peter -> {CSBSJU, HARVARD}
	//       juser -> {YALE, AUGSBURG, STANFORD}
	public static Map<String, List<String>> getUserSavedSchoolMap() {
		String[][] dbMapping = database.user_getUsernamesWithSavedSchools();

		HashMap<String, List<String>> result = new HashMap<String, List<String>>();
		
		for (String[] entry : dbMapping) {
			String user = entry[0];
			String school = entry[1];
			
			if (!result.containsKey(user))
				result.put(user, new ArrayList<String>());
			
			result.get(user).add(school);
		}

		return result;
	}
	
	public static boolean editPassword(String username, String newPassword) {
		String[] userData = DatabaseController.getUser(username);
		
		int result = database.user_editUser(username, userData[0], userData[1], newPassword, userData[4].charAt(0), userData[5].charAt(0));
		if (result == -1) {
			System.out.println("Error in changing password");
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean editFirstName(String username, String newFirstName) {
		String[] userData = DatabaseController.getUser(username);
		
		int result = database.user_editUser(username, newFirstName, userData[1], userData[3], userData[4].charAt(0), userData[5].charAt(0));
		if (result == -1) {
			System.out.println("Error in changing password");
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean editLastName(String username, String newLastName) {
		String[] userData = DatabaseController.getUser(username);
		
		int result = database.user_editUser(username, userData[0], newLastName, userData[3], userData[4].charAt(0), userData[5].charAt(0));
		if (result == -1) {
			System.out.println("Error in changing password");
			return false;
		}
		else {
			return true;
		}
	}
}