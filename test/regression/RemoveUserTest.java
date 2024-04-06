package regression;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.CMCException;
import cmc.backend.AccountController;
import cmc.backend.DatabaseController;
import cmc.backend.entities.University;
import cmc.backend.entities.User;
import junit.framework.Assert;

public class RemoveUserTest {
	private static String userToTest = "tester12323534253246743653892756";
	private static String passToTest = "pass3205971908475091834760957";
	private static String schoolToTest = "AAAAA235439875980734095873489077";
	
	private String state = "Minnesota";
	private String location = "city";
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
		User user = new User(userToTest, passToTest, 'u', "k", "dt", 'Y');
		DatabaseController.addUser(user);
		
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		DatabaseController.addUniversity(uni);
		DatabaseController.saveSchool(userToTest, schoolToTest);
	}

	@After
	public void tearDown() throws Exception {
		List<User> list = DatabaseController.getAllUsers();
		for(User user : list) {
			System.out.println(user.getUsername());	
			if(user.getUsername().equalsIgnoreCase(userToTest)) {
				DatabaseController.removeUserSavedSchools(userToTest);
				DatabaseController.removeUser(userToTest);
				System.out.println("successful");
			}
		}
		DatabaseController.deleteUniversity(schoolToTest);
	}

	@Test
	public void test() {
		Assert.assertEquals(true, AccountController.removeUser(userToTest));
	}

}
