package cmc.backend;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.backend.entities.UserSchool;
import junit.framework.Assert;

public class SearchControllerTest {
	private String state = "Virginia";
	private String location = "MonroeHall";
	private String school = "43908579348759374985";
	private String control = "rt";
	private int numStudents = 12;
	private double PercentFemale = 12.5;
	private int SATMath = 123;
	private int SATVerbal = 12;
	private double expenses = 1234.0;
	private double PercentFA = 234.0;
	private int NumApplicants = 2;
	private double PercentAdmitted = 2.0;
	private double PercentEnrolled = 232.0;
	private int SocialScale = 12;
	private int AcademicScale = 1;
	private int QualLife = 2;
	private double gradRate = 2.3;
	private String link = "";
	private University uni;
	
	@Before
	public void setUp() throws Exception {
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		AccountController.addUser("5thPrez", "Monroedoctrine", "James", "Monroe", false);
		UniversityController.addUniversity(uni);
		UniversityController.saveSchool("5thPrez", school);
	}

	@After
	public void tearDown() throws Exception {
		UniversityController.removeSchool("5thPrez", "43908579348759374985");
		AccountController.removeUser("5thPrez");
		UniversityController.deleteUniversity("43908579348759374985");
	}

	@Test
	public void testSearch() {
		//System.out.println(SearchController.search("", "Virginia", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", "", "", ""));
		List<University> list = SearchController.search("43908579348759374985", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", "", "", "");
		//System.out.println(list);
		Assert.assertEquals(list.size(), 1);
	}

	@Test
	public void testGetSavedSchools() {
		List<UserSchool> list2 = SearchController.getSavedSchools("5thPrez");
		Assert.assertEquals(list2.size(), 1);
	}

	@Test
	public void testGetAllUsers() {
		List<User> list3 = SearchController.getAllUsers();
		Assert.assertNotNull(list3.size());
	}
	

}

