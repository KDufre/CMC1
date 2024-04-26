package cmc.backend;

import java.util.List; 

import cmc.backend.entities.University;
import cmc.backend.entities.UserSchool;

public class UniversityController {
	// this REGULAR USER ONLY method attempts to add the provided school
	// to the list of saved schools for the provided username
	/**
	 * This method attemps to add the provided school to the list of saved schools
	 * for the provided username
	 * @param user get the user to say they can save a school
	 * @param school that is chosen is being saved
	 * @return boolean true if the school was successfuly saved
	 */
	public static boolean saveSchool(String user, String school) {
		List<UserSchool> schools = SearchController.getSavedSchools(user); 
		if(schools!=null) {
			for(UserSchool s : schools) {
				if(school.equalsIgnoreCase(s.getUniversity())) {
					System.out.println("Already saved");
					return false;	
				}
			}
		}
		return DatabaseController.saveSchool(user, school);
	}
	/**
	 * This method removes a school from the user
	 * @param user is chosen to be able to remove school
	 * @param school is removed
	 * @return boolean true if school was removed succesfully
	 */
	public static boolean removeSchool(String user, String school) {
		return DatabaseController.removeSchool(user, school);
	}
	/**
	 * This method adds a university to the system
	 * @param uni is the uni that is being added
	 * @return boolean false if university was already added to the system before.
	 */
	public static boolean addUniversity(University uni) {
		return DatabaseController.addUniversity(uni);
	}
	/**
	 * This method deletes the university from the system
	 * @param school chosen is deleted from the system
	 * @return boolean true if uni can be removed from the system
	 */
	public static boolean deleteUniversity(String school) {
		return DatabaseController.deleteUniversity(school);
	}
	/**
	 * This method allows the admin to edit the University
	 * @param uni chosen can be edited
	 * @return boolean false if university not in the database
	 */
	public static boolean editUniversity(University uni) {
		return DatabaseController.editUniversity(uni);
	}
	public static University getSchool(String school) {
		return DatabaseController.getSchool(school);
	}
	public static List<University> getAllSchools() {
		return DatabaseController.getAllSchools();
	}
}
