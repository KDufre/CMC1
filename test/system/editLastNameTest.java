/**
 * 
 */
package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.AccountController;
import cmc.backend.DatabaseController;
import cmc.backend.entities.User;
import cmc.frontend.UserInteraction;
import junit.framework.Assert;
/**
 * 
 */
public class editLastNameTest {
			private static String userToTest = "tester867475937583947375984";
			private static String passToTest = "pass98754214678743807311459";
			
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
				String newLastName = "S";
				AccountController.editLastName(userToTest, newLastName);
				User user = DatabaseController.getUser(userToTest);
				Assert.assertEquals(newLastName, user.getLastName());
			}

		}

