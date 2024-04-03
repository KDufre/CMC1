package cmc.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchController {
	// this REGULAR USER ONLY method searches for schools in the database
	// based on provided criteria (just state for now)
	public static List<University> search(String schoolInput, String state, String location
			, String control, int minNumberOfStudents, int maxNumberOfStudents, int minPercentFemale, 
			int maxPercentFemale, int minSATVerbal, int maxSATVerbal, int minSATMath, int maxSATMath,
			int minExpenses, int maxExpenses, int minPercentAid, int maxPercentAid, 
			int minNumOfApplicants, int maxNumOfApplicants, int minPercentAdmitted, int maxPercentAdmitted, 
			int minPercentEnrolled, int maxPercentEnrolled, int minAcademicScale, int maxAcademicScale, 
			int minSocialScale, int maxSocialScale, int minQualityLifeScale, int maxQualityLifeScale, String emphasis1, String emphasis2, String emphasis3, String emphasis4, String emphasis5) {
		List<University> schoolList = DatabaseController.getAllSchools();
		
		HashMap<String, List<String>> emphasisMap = DatabaseController.getEmphasis();


		List<University> filteredList = new ArrayList<University>();
		for (int i = 0; i < schoolList.size(); i++) {
			University school = schoolList.get(i);
			
			List<String> getList1 = emphasisMap.get(school.getSchool());
			boolean containsEmphasis1 = false;
			if (getList1 != null) {
				containsEmphasis1 = getList1.contains(emphasis1.toUpperCase());
				
			}
			List<String> getList2 = emphasisMap.get(school.getSchool());
			boolean containsEmphasis2 = false;
			if (getList2 != null) {
				containsEmphasis2 = getList2.contains(emphasis2.toUpperCase());
				
			}
			List<String> getList3 = emphasisMap.get(school.getSchool());
			boolean containsEmphasis3 = false;
			if (getList3 != null) {
				containsEmphasis3 = getList3.contains(emphasis3.toUpperCase());
				
			}
			List<String> getList4 = emphasisMap.get(school.getSchool());
			boolean containsEmphasis4 = false;
			if (getList4 != null) {
				containsEmphasis4 = getList4.contains(emphasis4.toUpperCase());
				
			}
			List<String> getList5 = emphasisMap.get(school.getSchool());
			boolean containsEmphasis5 = false;
			if (getList5 != null) {
				containsEmphasis5 = getList5.contains(emphasis5.toUpperCase());
				
			}
			
			
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
					&& (containsEmphasis1 || emphasis1 == "") && (containsEmphasis2 || emphasis2 == "") && (containsEmphasis3 || emphasis3 == "") 
					&& (containsEmphasis4 || emphasis4 == "") && (containsEmphasis5 || emphasis5 == "") 
					|| (schoolInput=="" && state=="" && location=="" && control=="" && minNumberOfStudents==0 
					&& maxNumberOfStudents==Integer.MAX_VALUE && minPercentFemale==0 && maxPercentFemale==Integer.MAX_VALUE && minSATVerbal==0 && 
					maxSATVerbal==Integer.MAX_VALUE && minSATMath==0 && maxSATMath==Integer.MAX_VALUE && minExpenses==0 && maxExpenses==Integer.MAX_VALUE && 
					minPercentAid==0 && maxPercentAid==Integer.MAX_VALUE && minNumOfApplicants==0 && maxNumOfApplicants==Integer.MAX_VALUE && minPercentAdmitted==0 
					&& maxPercentAdmitted==Integer.MAX_VALUE && minPercentEnrolled==0 && maxPercentEnrolled==Integer.MAX_VALUE && minAcademicScale==0 && 
					maxAcademicScale==Integer.MAX_VALUE && minSocialScale==0 && maxSocialScale==Integer.MAX_VALUE && minQualityLifeScale==0 && 
					maxQualityLifeScale==Integer.MAX_VALUE && emphasis1 == "" && emphasis2 == "" && emphasis3 == "" && emphasis4 == "" && emphasis5 == ""))
				filteredList.add(school);
		}

		return filteredList;
	}
	

	// this REGULAR USER ONLY method attempts to retrieve the list of saved
	// schools for the provided username
	public static List<UserSchool> getSavedSchools(String user) {
		Map<String, List<UserSchool>> usersToSavedSchools = DatabaseController.getUserSavedSchoolMap();
		return usersToSavedSchools.get(user);
	}

	// this ADMIN ONLY method returns the list of all the users (and their data)
	public static List<User> getAllUsers() {
		List<User> usersList = DatabaseController.getAllUsers();
		return usersList;
	}
	
	public static List<University> getFiveSimilarSchools(University school){
		HashMap<University, Integer> map = new HashMap<>();
		List<University> allSchools = DatabaseController.getAllSchools();
		
		for(University uni : allSchools) {
			int score = 0;
			if(uni.getState()==school.getState()) {
				score++;
			}
			if(uni.getLocation()==school.getLocation()) {
				score++;
			}
			map.put(uni, score);
		}
		// Get the top 5 objects based on their integer values
        List<University> top5Objects = map.entrySet().stream()
                // Sort the entries by their value (integer) in descending order
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                // Limit the stream to the first 5 entries
                .limit(5)
                // Extract the key from each entry
                .map(Map.Entry::getKey)
                // Collect the keys into a List<Object>
                .collect(Collectors.toList());
		return top5Objects;
		
	}
}
