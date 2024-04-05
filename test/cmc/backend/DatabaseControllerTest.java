package cmc.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.frontend.UserInteraction;
import junit.framework.Assert;

public class DatabaseControllerTest {
	private String state = "Minnesota";
	private String location = "city";
	private String school = "pp";
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

	private static User testUser;
	private static User testUser2;
	private static String testUname = "testuname09387490183275";
	private static String testUname2 = "testuname09387490183232985709237575";
	private static String testPass = "testpass";
	private static char testType = 'u';
	private static String testFName = "Test";
	private static String testLName = "AUser";
	private static char testActivated = 'Y';

	@Before
	public void setUp() throws Exception {
		testUser = new User(testUname, testPass, testType, testFName, testLName, testActivated);
		testUser2 = new User(testUname2, testPass, testType, testFName, testLName, testActivated);
		DatabaseController.addUser(testUser2);
		
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(testUname);
		DatabaseController.removeUser(testUname2);
		DatabaseController.deleteUniversity(school);
	}

	@Test
	public void testAddUser() {
		//AddUser
		//WhiteBox
		Assert.assertEquals(true, DatabaseController.addUser(testUser));
		Assert.assertEquals(true, UserInteraction.login(testUname, testPass));
		Assert.assertEquals(false, DatabaseController.addUser(testUser));
	}

	@Test
	public void testRemoveUser() {
		//removeUser
		Assert.assertEquals(true, DatabaseController.removeUser(testUname2));
		Assert.assertEquals(false, UserInteraction.login(testUname, testPass));
	}
	
	@Test
	public void testGetUser() {
		DatabaseController.addUser(testUser);
		Assert.assertEquals(testUser.getFirstName(), DatabaseController.getUser(testUname).getFirstName());
		
		DatabaseController.removeUser(testUname);
		Assert.assertEquals(null, DatabaseController.getUser(testUname));
	}

	@Test
	public void testGetAllUsers() {
		Assert.assertNotNull(DatabaseController.getAllUsers());}

	@Test
	public void testGetAllSchools() {
		Assert.assertNotNull(DatabaseController.getAllSchools());
	}

	@Test
	public void testGetEmphasis() {
		Assert.assertNotNull(DatabaseController.getEmphasis());
	}

	@Test
	public void testSaveSchool() {
		
	}

	@Test
	public void testRemoveSchool() {
		
	}

	@Test
	public void testRemoveUserSavedSchools() {
		
	}

	@Test
	public void testGetUserSavedSchoolMap() {
		
	}

	@Test
	public void testEditUser() {
		
	}

	@Test
	public void testDeactivateUser() {
		
	}

	@Test
	public void testActivateUser() {
		
	}

	@Test
	public void testAddUniversity() {
		Assert.assertTrue(DatabaseController.addUniversity(school, state, location, control, numStudents, PercentFemale, SATVerbal, SATMath, expenses, PercentFA, NumApplicants, PercentAdmitted, PercentEnrolled, AcademicScale, SocialScale, NumApplicants, AcademicScale, link));
	}

	@Test
	public void testDeleteUniversity() {
		
	}

	@Test
	public void testRemoveUniversityEmphases() {
		
	}

	@Test
	public void testEditUniversity() {
		
	}
	 
}
