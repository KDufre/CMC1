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
	private String school = "43908579348759374985";
	private String school2 = "28475908347598";
	private String school3 = "2847239857609823655908347598";
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
	private University uni; //This one gets added to database in setup
	private University uni2; // This one doesn't get added to database in setup
	private University uni3; //This one gets added and saved by testUser2
	
	private static User testUser;
	private static User testUser2;
	private static User testUser3;
	private static String testUname = "testuname09387490183275";
	private static String testUname2 = "testuname09387490183232985709237575";
	private static String testUname3 = "testuname093874901832329857092375750953410292";
	private static String testPass = "testpass";
	private static char testType = 'u';
	private static String testFName = "Test";
	private static String testLName = "AUser";
	private static char testActivated = 'Y';

	@Before
	public void setUp() throws Exception {
		testUser = new User(testUname, testPass, testType, testFName, testLName, testActivated);
		testUser2 = new User(testUname2, testPass, testType, testFName, testLName, testActivated);
		testUser3 = new User(testUname3, testPass, testType, testFName, testLName, testActivated);
		DatabaseController.addUser(testUser2);
		
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		DatabaseController.addUniversity(uni);
		
		uni2 = new University (school2, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		
		uni3 = new University (school3, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		
		DatabaseController.addUniversity(uni3);
		DatabaseController.saveSchool(testUser2.getUsername(), uni3.getSchool());

	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(testUname);
		DatabaseController.removeUser(testUname2);
		DatabaseController.deleteUniversity(uni.getSchool());
		DatabaseController.deleteUniversity(uni2.getSchool());
		DatabaseController.deleteUniversity(uni3.getSchool());
	}

	@Test
	public void testAddUser() {
		//AddUser
		//WhiteBox
		//One for the if to be true
		//One for the if to be false
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
		//black box
		//user that is in the database
		//user that is not in the database
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
		//White Box
		//One for if to be true 
		//One for it to be false
		
		Assert.assertTrue(DatabaseController.saveSchool(testUser2.getUsername(), uni.getSchool()));
		Assert.assertFalse(DatabaseController.saveSchool(testUser2.getUsername(), uni2.getSchool()));
		
	}

	@Test
	public void testRemoveSchool() {
		//White Box
		//One for if to be true
		//One for it to be false
		Assert.assertTrue(DatabaseController.removeSchool(testUser2.getUsername(), uni3.getSchool()));
		Assert.assertFalse(DatabaseController.removeSchool(testUser3.getUsername(), uni2.getSchool()));
	}

	@Test
	public void testRemoveUserSavedSchools() {
		Assert.assertTrue(DatabaseController.removeUserSavedSchools(testUser2.getUsername()));
	}

	@Test
	public void testGetUserSavedSchoolMap() {
		Assert.assertNotNull(DatabaseController.getUserSavedSchoolMap());
	}

	@Test
	public void testEditUser() {
		Assert.assertTrue(DatabaseController.editUser(testUser2));
	}

	@Test
	public void testDeactivateUser() {
		Assert.assertTrue(DatabaseController.deactivateUser(testUser2.getUsername()));
		Assert.assertFalse(UserInteraction.login(testUser2.getUsername(), testUser2.getPassword()));
	}

	@Test
	public void testActivateUser() {
		Assert.assertTrue(DatabaseController.activateUser(testUser2.getUsername()));
		}

	@Test
	public void testAddUniversity() {
		//Black Box
		//uni that is in the database
		//uni2 that is NOT in the database
		Assert.assertTrue(DatabaseController.addUniversity(uni2));
		Assert.assertFalse(DatabaseController.addUniversity(uni));
	}

	@Test
	public void testDeleteUniversity() {
		//Black Box
		//university that is in the database
		//university is not in the database
		
		Assert.assertEquals(true, DatabaseController.deleteUniversity(uni.getSchool()));
		
		
		Assert.assertEquals(true, DatabaseController.deleteUniversity(uni2.getSchool()));
	}

	@Test
	public void testRemoveUniversityEmphases() {
		Assert.assertTrue(DatabaseController.removeUniversityEmphases(uni2.getSchool()));
	}

	@Test
	public void testEditUniversity() {
		Assert.assertTrue(DatabaseController.editUniversity(uni2));
	}
	 
}
