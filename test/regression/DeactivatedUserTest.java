package regression;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.DatabaseController;
import cmc.backend.SystemController;
import cmc.backend.User;
import junit.framework.Assert;

public class DeactivatedUserTest {
	private static String userToTest = "tester12323534253246743653892756";
	private static String passToTest = "pass3205971908475091834760957";
	@Before
	public void setUp() throws Exception {
		DatabaseController.addUser(userToTest, passToTest, 'u', userToTest, passToTest);
		DatabaseController.deactivateUser(userToTest);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(userToTest);
	}

	@Test
	public void test() {
		Assert.assertEquals(null, SystemController.login(userToTest, passToTest));
	}

}
