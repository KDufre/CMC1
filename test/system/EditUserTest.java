package system;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.AccountController;
import cmc.backend.DatabaseController;
import cmc.backend.entities.User;
import cmc.frontend.UserInteraction;
import junit.framework.Assert;

public class EditUserTest {
	private static String userToTest = "tester567898765345678987566542";
	private static String passToTest = "pass98765432345679876425807311459";

	@Before
	public void setUp() throws Exception {
		User user = new User(userToTest, passToTest, 'u', "k", "dt", 'Y');
		DatabaseController.addUser(user);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(userToTest);
	}

	@Test
	public void testEditFirstName() {
		String newFirstName = "I";
		AccountController.editFirstName(userToTest, newFirstName);
		User user = DatabaseController.getUser(userToTest);
		Assert.assertEquals(newFirstName, user.getFirstName());
	}
	
	@Test
	public void testEditLastName() {
		String newLastName = "S";
		AccountController.editLastName(userToTest, newLastName);
		User user = DatabaseController.getUser(userToTest);
		Assert.assertEquals(newLastName, user.getLastName());
	}
	
	@Test
	public void testEditPassword() {
		AccountController.editPassword(userToTest, "newPassword");
		Assert.assertEquals(true, UserInteraction.login(userToTest, "newPassword"));
	}

}
