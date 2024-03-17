package cmc.backend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dblibrary.project.csci230.*;

/**
 * The DatabaseController class is the primary interaction class with the
 * database library.  It currently just calls the lower-level methods and
 * forwards the result (possibly throwing some exceptions along the way).
 * 
 * @author Sally Sparrow
 */
public class DatabaseController {
	private static UniversityDBLibrary database = new UniversityDBLibrary("william", "csci230");

	// add a user to the db
	public static boolean addUser(User user){
		int result = database.user_addUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getType());
		
		if (result == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// remove a user from the db
	public static boolean removeUser(String username){
		removeUserSavedSchools(username);
		int result = database.user_deleteUser(username);
		if (result != 1) {
			System.out.println("Error in removing User");
			return false;
		}
		else {
			return true;
		}
	}
	
	// get a user; null if not in DB
	public static User getUser(String username) {
		String[][] databaseUserStrings = database.user_getUsers();
		
		for (String[] userData : databaseUserStrings) {
			String thisUsername = userData[2];
			if (thisUsername.equals(username)) {
				User theUser = new User(userData[2], userData[3], userData[4].charAt(0), userData[0],
						userData[1], userData[5].charAt(0));
				return theUser;
			}
		}
		
		return null;
	}
	
	// get the list of all the users in the DB
	public static List<User> getAllUsers() {
		String[][] dbUserList = database.user_getUsers();
		
		ArrayList<User> result = new ArrayList<User>();
		for (String[] userData : dbUserList) {
			User user = new User(userData[2], userData[3], userData[4].charAt(0), userData[0],
					userData[1], userData[5].charAt(0));
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
			System.out.println("Error in saving school");
			return false;
		}
		else {
			return true;
		}
	}
	
	//Removes saved school for particular username entered
	public static boolean removeSchool(String username, String schoolName) {
		int result = database.user_removeSchool(username, schoolName);
		if (result == -1) {
			System.out.println("Error in removing School!!!");
			return false;
		}
		else {
			return true;
		}
	}
	
	//removes all the saved schools that a username has saved
	public static boolean removeUserSavedSchools(String username) {
		Map<String, List<String>> result = getUserSavedSchoolMap();
		List<String> userList = result.get(username);
		if(userList==null) {
			return false;
		}
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
		if(dbMapping==null) {
			return result;
		}
		for (String[] entry : dbMapping) {
			String user = entry[0];
			String school = entry[1];
			
			if (!result.containsKey(user))
				result.put(user, new ArrayList<String>());
			
			result.get(user).add(school);
		}

		return result;
	}
	
	public static boolean editUser(User userData) {
		
		int result = database.user_editUser(userData.getUsername(), userData.getFirstName(), userData.getLastName(), userData.getPassword(), userData.type, userData.activated);
		if (result == -1) {
			System.out.println("Error in editing user");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean deactivateUser(String username) {
		User userData = DatabaseController.getUser(username);
		
		int result = database.user_editUser(username, userData.getFirstName(), userData.getLastName(), userData.getPassword(), userData.type, 'N');
		if (result == -1) {
			System.out.println("Error in deactivating user");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean activateUser(String username) {
		User userData = DatabaseController.getUser(username);
		
		int result = database.user_editUser(username, userData.getFirstName(), userData.getLastName(), userData.getPassword(), userData.type, 'Y');
		if (result == -1) {
			System.out.println("Error in activating user");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean addUniversity(String school, String state, String location, String control, int numbersOfStudents, 
			double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, 
			double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		int result = database.university_addUniversity(school, state, location, control, numbersOfStudents, percentAdmitted, 
								SATVerbal, SATMath, expenses, percentFinancialAid, 
				                numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		if(result==-1) {
			System.out.println("Error in adding school");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean deleteUniversity(String school) {
		Map<String, List<String>> map = getUserSavedSchoolMap();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
	        // Get the username from the entry key
	        String username = entry.getKey();
	        List<String> savedSchools = entry.getValue();

	        for (String school1 : savedSchools) {
	            //System.out.println("User: " + username + " has saved the school: " + school1); //test
	            if(school1.equalsIgnoreCase(school)) {
		            //System.out.println("User: " + username + " has removed the school: " + school1);
	            	removeSchool(username,school1);
	            }
	        }
	    }
		removeUniversityEmphases(school);
		
		int result = database.university_deleteUniversity(school);
		if(result==-1) {
			System.out.println("Error in removing university");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean removeUniversityEmphases(String school) {
		String[][] list = database.university_getNamesWithEmphases();
		int result = 0;
		for(String[] array : list) {
			if(array[0].equalsIgnoreCase(school)) {
				for(String e : array) {
					result = database.university_removeUniversityEmphasis(school, e);
				}
			}
		}
		if(result==-1) {
			System.out.println("Error in removing school");
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean editUniversity(String school, String state, String location, String control, int numbersOfStudents, 
			double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, 
			double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		int result = database.university_editUniversity(school, state, location, control, numbersOfStudents, percentAdmitted, 
								SATVerbal, SATMath, expenses, percentFinancialAid, 
				                numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		if(result==-1) {
			System.out.println("Error in adding school");
			return false;
		}
		else {
			return true;
		}
	}
}