  package cmc.backend;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.backend.entities.UserSchool;
import dblibrary.project.csci230.*;
import java.util.Date;

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
	/**
	 * 
	 * @param user User is the user being added to the database
	 * @return true if successful
	 */
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
	/**
	 * 
	 * @param username String is the user being removed from the database
	 * @return true if successful
	 */
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
	/**
	 * 
	 * @param username String is the username being found in the database
	 * @return the user object if username is in the database, else null
	 */
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
	/**
	 * 
	 * @return List of user objects for all users in database
	 */
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
	/**
	 * 
	 * @return list of Universities containing all the schools in the database
	 */
	public static List<University> getAllSchools() {
		String[][] dbUniversityList = database.university_getUniversities();

		ArrayList<University> result = new ArrayList<University>();
		for (String[] school : dbUniversityList) {
			University Uni = new University(school[0], school[1], school[2], school[3], Integer.parseInt(school[4]), Double.parseDouble(school[5]), Integer.parseInt(school[6]),
					Integer.parseInt(school[7]), Double.parseDouble(school[8]), 
					Double.parseDouble(school[9]), Integer.parseInt(school[10]), 
					Double.parseDouble(school[11]), Double.parseDouble(school[12]), 
					Integer.parseInt(school[13]), Integer.parseInt(school[14]), 
					Integer.parseInt(school[15]), Double.parseDouble(school[16]), school[17]);
			result.add(Uni);
		}

		return result;
	}
	
	/**
	 * 
	 * @return HashMap with University and a list of all of their emphases
	 */
	public static HashMap<String, List<String>> getEmphasis() {
		String[][] dbEmphasisList = database.university_getNamesWithEmphases();
		
		HashMap<String, List<String>> result = new HashMap<String, List<String>>();
		
		if(dbEmphasisList==null) {
			return result;
		}
		for (String[] entry : dbEmphasisList) {
			String school = entry[0];
			String emphasis = entry[1];
			
			if (!result.containsKey(school))
				result.put(school, new ArrayList<String>());

			result.get(school).add(emphasis);
		}

		return result;
	}

	// save a school to a particular user's list
	// TODO: It feels like we should be able to do this as part of
	//       "updating" a user in the DB.
	/**
	 * 
	 * @param username is the user saving the school
	 * @param schoolName is the school being saved
	 * @return true if successful
	 */
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
	/**
	 * 
	 * @param username is the user removing a school from their saved schools
	 * @param schoolName is the school being unsaved
	 * @return true if successful
	 */
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
	/**
	 * 
	 * @param username is the user that is having all of their saved schools removed
	 * @return true if successful
	 */
	public static boolean removeUserSavedSchools(String username) {
		Map<String, List<UserSchool>> result = getUserSavedSchoolMap();
		List<UserSchool> userList = result.get(username);
		boolean r = true;
		if(userList==null) {
			return r;
		}
		for(UserSchool school : userList) {
			r = removeSchool(username, school.getUniversity());
		}

		return true;
	}

	// get the mapping from users to their saved universities in the DB
	// e.g., peter -> {CSBSJU, HARVARD}
	//       juser -> {YALE, AUGSBURG, STANFORD}
	/**
	 * 
	 * @return Map with Users with their list of saved schools (university, timestamp)
	 */
	public static Map<String, List<UserSchool>> getUserSavedSchoolMap() {
		String[][] dbMapping = database.user_getUsernamesWithSavedSchools();

		HashMap<String, List<UserSchool>> result = new HashMap<String, List<UserSchool>>();
		if(dbMapping==null) {
			return result;
		}
		for (String[] entry : dbMapping) {
			String user = entry[0];
			String school = entry[1];
			String dateStr = entry[2];
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date = null;
			try {
				date = formatter.parse(dateStr);
			} catch (ParseException e) {
				System.out.println("Error");
			}
            
            UserSchool userSchool = new UserSchool(school, date);

			if (!result.containsKey(user))
				result.put(user, new ArrayList<UserSchool>());

			result.get(user).add(userSchool);
		}

		return result;
	}

	/**
	 * 
	 * @param userData is the user being edited
	 * @return true if successful
	 */
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

	/**
	 * 
	 * @param username is the user being deactivated
	 * @return true if successful
	 */
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

	/**
	 * 
	 * @param username is the user being activated
	 * @return true if successful
	 */
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

	/**
	 * 
	 * @param uni is the university being added to database
	 * @return true if successful
	 */
	public static boolean addUniversity(University uni) {
		int result = database.university_addUniversity(uni.getSchool(), uni.getState(), uni.getLocation(), uni.getControl(), uni.getNumStudents(), uni.getPercentAdmitted(), 
				uni.getSATVerbal(), uni.getSATMath(), uni.getExpenses(), uni.getPercentFA(), 
				uni.getNumApplicants(), uni.getPercentAdmitted(), uni.getPercentEnrolled(), 
				uni.getAcademicScale(), uni.getSocialScale(), uni.getQualLife(), 
				(int) uni.getGradRate(), uni.getLink());
		if(result==-1) {
			System.out.println("Error in adding school");
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * 
	 * @param school is the school being deleted from the database
	 * @return true if successful
	 */
	public static boolean deleteUniversity(String school) {
		Map<String, List<UserSchool>> map = getUserSavedSchoolMap();
		if(!(map==null)) {
			for (Map.Entry<String, List<UserSchool>> entry : map.entrySet()) {
				// Get the username from the entry key
				String username = entry.getKey();
				List<UserSchool> savedSchools = entry.getValue();

				for (UserSchool school1 : savedSchools) {
					//System.out.println("User: " + username + " has saved the school: " + school1); //test
					if(school1.getUniversity().equalsIgnoreCase(school)) {
						//System.out.println("User: " + username + " has removed the school: " + school1);
						removeSchool(username,school1.getUniversity());
					}
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

	/**
	 * 
	 * @param school is the school having it's emphases removed
	 * @return true if successful
	 */
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
	/**
	 * 
	 * @param uni is the university being edited
	 * @return true if successful
	 */
	public static boolean editUniversity(University uni) {
		
		int result = database.university_editUniversity(uni.getSchool(), uni.getState(), uni.getLocation(), uni.getControl(), uni.getNumStudents(), uni.getPercentAdmitted(), 
				uni.getSATVerbal(), uni.getSATMath(), uni.getExpenses(), uni.getPercentFA(), 
				uni.getNumApplicants(), uni.getPercentAdmitted(), uni.getPercentEnrolled(), 
				uni.getAcademicScale(), uni.getSocialScale(), uni.getQualLife(), 
				uni.getGradRate(), uni.getLink());
		if(result==-1) {
			System.out.println("Error in adding school");
			return false;
		}
		else {
			return true;
		}
	}
}