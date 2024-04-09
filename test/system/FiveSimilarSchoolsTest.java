package system;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.DatabaseController;
import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.frontend.UserInteraction;
import junit.framework.Assert;

public class FiveSimilarSchoolsTest {
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
		DatabaseController.addUser(testUser);
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		DatabaseController.addUniversity(uni);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(testUser.getUsername());
		DatabaseController.deleteUniversity(uni.getSchool());
	}

	@Test
	public void test() {
		Assert.assertEquals(5, UserInteraction.getFiveSimilarSchools(uni).size());
	}

}
