package system;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.DatabaseController;
import cmc.backend.UniversityController;
import cmc.backend.entities.User;
import junit.framework.Assert;

public class AddSavedSchoolsTest {
	private static String userToTest = "tester12323534253246743653892756";
	private static String passToTest = "pass3205971908475091834760957";
	private static String schoolToTest = "AAAAA235439875980734095873489077";

	@Before
	public void setUp() throws Exception {
		User user = new User(userToTest, passToTest, 'u', "k", "dt", 'Y');
		DatabaseController.addUser(user);
		DatabaseController.addUniversity(schoolToTest, passToTest, userToTest, passToTest, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "");
		DatabaseController.saveSchool(userToTest, schoolToTest);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.deleteUniversity(schoolToTest);
		DatabaseController.removeUser(userToTest);
	}

	@Test
	public void test() {
		Assert.assertEquals(false, UniversityController.saveSchool(userToTest, schoolToTest));
	}

}
