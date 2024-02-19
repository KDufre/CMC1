package regression;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.DatabaseController;
import cmc.backend.SystemController;
import junit.framework.Assert;

public class AddSavedSchoolsTest {
	private static String userToTest = "tester12323534253246743653892756";
	private static String passToTest = "pass3205971908475091834760957";
	private static String schoolToTest = "AAAAA235439875980734095873489077";

	@Before
	public void setUp() throws Exception {
		DatabaseController.addUser(userToTest, passToTest, 'u', userToTest, passToTest);
		DatabaseController.addUniversity(schoolToTest, passToTest, userToTest, passToTest, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DatabaseController.saveSchool(userToTest, schoolToTest);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.deleteUniversity(schoolToTest);
		DatabaseController.removeUser(userToTest);
	}

	@Test
	public void test() {
		Assert.assertEquals(false, SystemController.saveSchool(userToTest, schoolToTest));
	}

}
