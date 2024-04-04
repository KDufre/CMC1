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

public class AddUserTest {
	private static String username = "Vijay_Dr.V_TheGoats123!!!???7771234567890123456789009876543210987654321";
	private static String passcode = "kohls";

	@Before
	public void setUp() throws Exception {
		User newUser = new User(username, passcode, 'u',"", "", 'y');
		DatabaseController.addUser(newUser);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(username);
	}

	@Test
	public void test() {
		
		Assert.assertEquals(true, UserInteraction.login(username, passcode));
	}

}
