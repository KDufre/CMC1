package cmc.backend;

import java.util.List; 

import cmc.backend.entities.University;
import cmc.backend.entities.UserSchool;

public class UniversityController {
	// this REGULAR USER ONLY method attempts to add the provided school
	// to the list of saved schools for the provided username
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

	public static boolean removeSchool(String user, String school) {
		return DatabaseController.removeSchool(user, school);
	}

	public static boolean addUniversity(University uni) {
		return DatabaseController.addUniversity(uni);
	}
	public static boolean deleteUniversity(String school) {
		return DatabaseController.deleteUniversity(school);
	}
	public static boolean editUniversity(University uni) {
		return DatabaseController.editUniversity(uni);
	}
}
