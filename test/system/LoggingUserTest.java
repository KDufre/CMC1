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

public class LoggingUserTest {
	private static String username = "this_is_a_unique_name";
	private static String password = "this_is_a_unique_password";

	@Before
	public void setUp() throws Exception {
		User user = new User (username, password, 'u', "", "", 'y');
		DatabaseController.addUser(user);
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(username);
	}

	@Test
	public void test1() {
		Assert.assertEquals(true, UserInteraction.login(username, password));
		
	}
	@Test
	public void test2() {
		Assert.assertEquals(false, UserInteraction.login(username, "hello"));
		
	}
	

}
