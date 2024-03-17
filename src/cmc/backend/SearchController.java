package cmc.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchController {
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
