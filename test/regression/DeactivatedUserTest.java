package regression;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.AccountController;
import cmc.backend.DatabaseController;
import cmc.backend.entities.User;
import junit.framework.Assert;

public class DeactivatedUserTest {
	private static String userToTest = "tester12323534253246743653892756";
	private static String passToTest = "pass3205971908475091834760957";
	@Before
	public void setUp() throws Exception {
		User user = new User(userToTest, passToTest, 'u', "k", "dt", 'Y');
		DatabaseController.addUser(user);
		DatabaseController.deactivateUser(userToTest);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(userToTest);
	}

	@Test
	public void test() {
		Assert.assertEquals(null, AccountController.login(userToTest, passToTest));
	}

}
