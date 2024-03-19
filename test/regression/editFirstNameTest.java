/**
 * 
 */
package regression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.AccountController;
import cmc.backend.DatabaseController;
import cmc.backend.User;
import cmc.frontend.UserInteraction;
import junit.framework.Assert;

/**
 * 
 */
public class editFirstNameTest {
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
		public void test() {
			String newFirstName = "I";
			AccountController.editFirstName(userToTest, newFirstName);
			User user = DatabaseController.getUser(userToTest);
			Assert.assertEquals(newFirstName, user.getFirstName());
		}

	}

