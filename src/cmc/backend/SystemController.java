package cmc.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cmc.CMCException;

public class SystemController {
	
	// other classes should *not* instantiate this class.  It is "pure static".
	private SystemController() throws CMCException {
		throw new CMCException("Attempt to instantiate a SystemController");
	}
	
	/**
	 * Verify whether the username and password provided match a user in the
	 * database.  Return a Boolean indicating yes or no.
	 * 
	 * TODO: how could we distinguish a DB error from a failed login?
	 * 
	 * @param username the username to check
	 * @param password the password to check for matching the username
	 * @return the matching User object if the username and password match
	 * a database entry, or null otherwise
	 */
	public static User login(String username, String password) {
		User theUser = DatabaseController.getUser(username);
		
		if (theUser.getActivated() != 'Y' || !theUser.password.equals(password)) {
			return null;
		}
		else {
			return theUser;
		}
	}

	// this ADMIN ONLY method returns the list of all the users (and their data)
	// TODO: shouldn't this return a List of User objects?
	public static List<String[]> getAllUsers() {
		List<String[]> usersList = DatabaseController.getAllUsers();
		return usersList;
	}
	
	// this ADMIN ONLY method attempts to add a user to the database with the
	// provided details
	public static boolean addUser(String username, String password,
			String firstName, String lastName, boolean isAdmin) {
		char type = (isAdmin ? 'a' : 'u');
		try {
			return DatabaseController.addUser(username, password, type, firstName, lastName);
		} catch (CMCException e) {
			// TODO: should we let the calling class report the error more
			//       clearly by passing it on?
			return false;
		}
	}
	
	// this ADMIN ONLY method attempts to remove a user from the database
	// based on the provided username
	public static boolean removeUser(String username) {
		try {
			//DatabaseController.removeUserSavedSchools(username);
			return DatabaseController.removeUser(username);
		} catch (CMCException e) {
			// TODO: should we let the calling class report the error more
			//       clearly by passing it on?
			return false;
		}
	}
	
	// this REGULAR USER ONLY method searches for schools in the database
	// based on provided criteria (just state for now)
	public static List<String[]> search(String schoolInput, String state, String location
			, String control, int minNumberOfStudents, int maxNumberOfStudents, int minPercentFemale, 
			int maxPercentFemale, int minSATVerbal, int maxSATVerbal, int minSATMath, int maxSATMath,
			int minExpenses, int maxExpenses, int minPercentAid, int maxPercentAid, 
			int minNumOfApplicants, int maxNumOfApplicants, int minPercentAdmitted, int maxPercentAdmitted, 
			int minPercentEnrolled, int maxPercentEnrolled, int minAcademicScale, int maxAcademicScale, 
			int minSocialScale, int maxSocialScale, int minQualityLifeScale, int maxQualityLifeScale) {
		List<String[]> schoolList = DatabaseController.getAllSchools();
		
		
		
		List<String[]> filteredList = new ArrayList<String[]>();
		for (int i = 0; i < schoolList.size(); i++) {
			String[] school = schoolList.get(i);
			if (((school[0].equalsIgnoreCase(schoolInput) || schoolInput=="") 
					&& (school[1].equalsIgnoreCase(state) || state =="")
					&& (school[2].equalsIgnoreCase(location) || location =="")
					&& (school[3].equalsIgnoreCase(control) || control=="")
					&& (Integer.parseInt(school[4])>=minNumberOfStudents && Integer.parseInt(school[4])<=maxNumberOfStudents)
					&& (Integer.parseInt(school[5])>=minPercentFemale && Integer.parseInt(school[5])<=maxPercentFemale)
					&& (Integer.parseInt(school[6])>=minSATVerbal && Integer.parseInt(school[6])<=maxSATVerbal)
					&& (Integer.parseInt(school[7])>=minSATMath && Integer.parseInt(school[7])<=maxSATMath)
					&& (Integer.parseInt(school[8])>=minExpenses && Integer.parseInt(school[8])<=maxExpenses)
					&& (Integer.parseInt(school[9])>=minPercentAid && Integer.parseInt(school[9])<=maxPercentAid)
					&& (Integer.parseInt(school[10])>=minNumOfApplicants && Integer.parseInt(school[10])<=maxNumOfApplicants)
					&& (Integer.parseInt(school[11])>=minPercentAdmitted && Integer.parseInt(school[11])<=maxPercentAdmitted)
					&& (Integer.parseInt(school[12])>=minPercentEnrolled && Integer.parseInt(school[12])<=maxPercentEnrolled)
					&& (Integer.parseInt(school[13])>=minAcademicScale && Integer.parseInt(school[13])<=maxAcademicScale)
					&& (Integer.parseInt(school[14])>=minSocialScale && Integer.parseInt(school[14])<=maxSocialScale)
					&& (Integer.parseInt(school[15])>=minQualityLifeScale && Integer.parseInt(school[15])<=maxQualityLifeScale))
					|| (schoolInput=="" && state=="" && location=="" && control=="" && minNumberOfStudents==0 
					&& maxNumberOfStudents==Integer.MAX_VALUE && minPercentFemale==0 && maxPercentFemale==Integer.MAX_VALUE && minSATVerbal==0 && 
					maxSATVerbal==Integer.MAX_VALUE && minSATMath==0 && maxSATMath==Integer.MAX_VALUE && minExpenses==0 && maxExpenses==Integer.MAX_VALUE && 
					minPercentAid==0 && maxPercentAid==Integer.MAX_VALUE && minNumOfApplicants==0 && maxNumOfApplicants==Integer.MAX_VALUE && minPercentAdmitted==0 
					&& maxPercentAdmitted==Integer.MAX_VALUE && minPercentEnrolled==0 && maxPercentEnrolled==Integer.MAX_VALUE && minAcademicScale==0 && 
					maxAcademicScale==Integer.MAX_VALUE && minSocialScale==0 && maxSocialScale==Integer.MAX_VALUE && minQualityLifeScale==0 && maxQualityLifeScale==Integer.MAX_VALUE))
				filteredList.add(school);
		}
		
		return filteredList;
	}
	
	// this REGULAR USER ONLY method attempts to add the provided school
	// to the list of saved schools for the provided username
	public static boolean saveSchool(String user, String school) {
		List<String> schools = getSavedSchools(user); 
		if(schools!=null) {
			for(String s : schools) {
				if(school.equalsIgnoreCase(s)) {
					System.out.println("Already saved");
					return false;	
				}
			}
		}
		return DatabaseController.saveSchool(user, school);
	}
	
	public static boolean removeSchool(String user, String school) {
		return DatabaseController.removeSchool(user, school);
	}
	
	// this REGULAR USER ONLY method attempts to retrieve the list of saved
	// schools for the provided username
	public static List<String> getSavedSchools(String user) {
		Map<String, List<String>> usersToSavedSchools = DatabaseController.getUserSavedSchoolMap();
		return usersToSavedSchools.get(user);
	}
	
	//changes password
	public static boolean editPassword(String username, String newPassword) {
		return DatabaseController.editPassword(username, newPassword);
	}
	//changes firstName
	public static boolean editFirstName(String username, String newFirstName) {
		return DatabaseController.editFirstName(username, newFirstName);
	}
	//changes lastName
	public static boolean editLastName(String username, String newLastName) {
		return DatabaseController.editLastName(username, newLastName);
	}
	
	public static boolean deactivateUser(String username) {
		return DatabaseController.deactivateUser(username);
	}
	
	public static boolean activateUser(String username) {
		return DatabaseController.activateUser(username);
	}
	
	public static boolean addUniversity(String school, String state, String location, String control, int numbersOfStudents, 
			double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, 
			double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		
		return DatabaseController.addUniversity(school, state, location, control, numbersOfStudents, percentAdmitted, 
				SATVerbal, SATMath, expenses, percentFinancialAid, 
                numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
	public static boolean deleteUniversity(String school) {
		return DatabaseController.deleteUniversity(school);
	}
	public static boolean editUniversity(String school, String state, String location, String control, int numbersOfStudents, 
			double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, 
			double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		
		return DatabaseController.editUniversity(school, state, location, control, numbersOfStudents, percentAdmitted, 
				SATVerbal, SATMath, expenses, percentFinancialAid, 
                numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
}
