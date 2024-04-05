package cmc.backend;

import java.util.List;

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

	public static boolean addUniversity(String school, String state, String location, String control, int numbersOfStudents, 
			double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, 
			double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale, int gradRate, String link) {

		return DatabaseController.addUniversity(school, state, location, control, numbersOfStudents, percentAdmitted, 
				SATVerbal, SATMath, expenses, percentFinancialAid, 
				numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale
				, gradRate, link);
	}
	public static boolean deleteUniversity(String school) {
		return DatabaseController.deleteUniversity(school);
	}
	public static boolean editUniversity(String school, String state, String location, String control, int numbersOfStudents, 
			double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, 
			double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale, int gradRate, String link) {

		return DatabaseController.editUniversity(school, state, location, control, numbersOfStudents, percentAdmitted, 
				SATVerbal, SATMath, expenses, percentFinancialAid, 
				numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, gradRate, link);
	}
}
