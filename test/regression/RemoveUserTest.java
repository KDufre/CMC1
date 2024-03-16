package regression;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.CMCException;
import cmc.backend.DatabaseController;
import cmc.backend.SystemController;
import cmc.backend.User;
import junit.framework.Assert;

public class RemoveUserTest {
	private static String userToTest = "tester12323534253246743653892756";
	private static String passToTest = "pass3205971908475091834760957";
	private static String schoolToTest = "AAAAA235439875980734095873489077";
	@Before
	public void setUp() throws Exception {
		User user = new User(userToTest, passToTest, 'u', "k", "dt", 'Y');
		DatabaseController.addUser(user);
		DatabaseController.addUniversity(schoolToTest, passToTest, userToTest, passToTest, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
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
		Assert.assertEquals(true, SystemController.removeUser(userToTest));
	}

}
