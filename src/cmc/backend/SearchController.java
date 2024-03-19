package cmc.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchController {
	// this REGULAR USER ONLY method searches for schools in the database
	// based on provided criteria (just state for now)
	public static List<University> search(String schoolInput, String state, String location
			, String control, int minNumberOfStudents, int maxNumberOfStudents, int minPercentFemale, 
			int maxPercentFemale, int minSATVerbal, int maxSATVerbal, int minSATMath, int maxSATMath,
			int minExpenses, int maxExpenses, int minPercentAid, int maxPercentAid, 
			int minNumOfApplicants, int maxNumOfApplicants, int minPercentAdmitted, int maxPercentAdmitted, 
			int minPercentEnrolled, int maxPercentEnrolled, int minAcademicScale, int maxAcademicScale, 
			int minSocialScale, int maxSocialScale, int minQualityLifeScale, int maxQualityLifeScale) {
		List<University> schoolList = DatabaseController.getAllSchools();


		List<University> filteredList = new ArrayList<University>();
		for (int i = 0; i < schoolList.size(); i++) {
			University school = schoolList.get(i);
			if (((school.getSchool().equalsIgnoreCase(schoolInput) || schoolInput=="") 
					&& (school.getState().equalsIgnoreCase(state) || state =="")
					&& (school.getLocation().equalsIgnoreCase(location) || location =="")
					&& (school.getControl().equalsIgnoreCase(control) || control=="")
					&& (school.getNumStudents()>=minNumberOfStudents && school.getNumStudents()<=maxNumberOfStudents)
					&& (school.getPercentFemale()>=minPercentFemale && school.getPercentFemale()<=maxPercentFemale)
					&& (school.getSATVerbal()>=minSATVerbal && school.getSATVerbal()<=maxSATVerbal)
					&& (school.getSATMath()>=minSATMath && school.getSATMath()<=maxSATMath)
					&& (school.getExpenses()>=minExpenses && school.getExpenses()<=maxExpenses)
					&& (school.getPercentFA()>=minPercentAid && school.getPercentFA()<=maxPercentAid)
					&& (school.getNumApplicants()>=minNumOfApplicants && school.getNumApplicants()<=maxNumOfApplicants)
					&& (school.getPercentAdmitted()>=minPercentAdmitted && school.getPercentAdmitted()<=maxPercentAdmitted)
					&& (school.getPercentEnrolled()>=minPercentEnrolled && school.getPercentEnrolled()<=maxPercentEnrolled)
					&& (school.getAcademicScale()>=minAcademicScale && school.getAcademicScale()<=maxAcademicScale)
					&& (school.getSocialScale()>=minSocialScale && school.getSocialScale()<=maxSocialScale)
					&& (school.getQualLife()>=minQualityLifeScale && school.getQualLife()<=maxQualityLifeScale))
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

	// this REGULAR USER ONLY method attempts to retrieve the list of saved
	// schools for the provided username
	public static List<String> getSavedSchools(String user) {
		Map<String, List<String>> usersToSavedSchools = DatabaseController.getUserSavedSchoolMap();
		return usersToSavedSchools.get(user);
	}

	// this ADMIN ONLY method returns the list of all the users (and their data)
	public static List<User> getAllUsers() {
		List<User> usersList = DatabaseController.getAllUsers();
		return usersList;
	}
}
