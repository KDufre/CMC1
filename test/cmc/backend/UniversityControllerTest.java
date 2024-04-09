package cmc.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.frontend.UserInteraction;
import junit.framework.Assert;


public class UniversityControllerTest {
	//public static boolean schoolExample = UniversityController.addUniversity("JavaLand02383ur", "Montana", "United States", "N.A", 10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	private String state = "Minnesota";
	private String location = "city";
	private String school = "43908579348759374985";
	private String school2 = "56347t72t02t3t2";
	private String school3 = "893t429t5248ty4";
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
	private University uni1;
	private University uni2;
	
	private static User testUser;
	private static User testUser2;
	private static String testUname = "testuname09387490183275";
	private static String testUname2 = "testuname283252t5285";
	private static String testPass = "testpass";
	private static char testType = 'u';
	private static String testFName = "Test";
	private static String testLName = "AUser";
	private static char testActivated = 'Y';	

	
	@Before
	//(String school, String state, String location, String control, int numbersOfStudents, double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) 
	public void setUp() throws Exception {
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		DatabaseController.addUniversity(uni);
		
		testUser = new User(testUname, testPass, testType, testFName, testLName, testActivated);
		DatabaseController.addUser(testUser);
		
		uni1 = new University (school2, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		DatabaseController.addUniversity(uni1);
		
		uni2 = new University (school3, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		
		DatabaseController.saveSchool(testUser.getUsername(), uni1.getSchool());
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.deleteUniversity(uni.getSchool());
		DatabaseController.deleteUniversity(uni1.getSchool());
		DatabaseController.deleteUniversity(uni2.getSchool());
		DatabaseController.removeUser(testUname);
	}

	
	@Test

	//Test save school
	public void testSaveSchool() {
		Assert.assertEquals(true, UniversityController.saveSchool(testUname, uni.getSchool()));
	}
	 
	
	@Test
	//Testing method for removing a school
	public void testRemoveSchool() {
		Assert.assertEquals(true, UniversityController.removeSchool(testUname, uni.getSchool()));
		Assert.assertEquals(true, UniversityController.removeSchool(testUname, uni1.getSchool()));
		
	}
	
	
	@Test
	//Testing method for adding university
	public void testAddUniversity() {
		Assert.assertFalse(UniversityController.addUniversity(uni1));
		
	}
	
	@Test
	//Testing method for deleting the University in the database
	//Black Box Testing 
	//Tests and looks for a school thats been deleted from the database
	public void testDeleteUniversity() {
		Assert.assertTrue(UniversityController.deleteUniversity(uni.getSchool()));
		Assert.assertEquals(true, UniversityController.deleteUniversity(uni1.getSchool()));
		Assert.assertTrue(UniversityController.deleteUniversity(uni2.getSchool()));
	}

	
	@Test
	//Testing method for editing the University
	public void testEditUniversity() {
		Assert.assertTrue(UniversityController.editUniversity(uni));
		Assert.assertTrue(UniversityController.editUniversity(uni1));
		Assert.assertTrue(UniversityController.editUniversity(uni2));
		
	}


}
