package cmc.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.User;
import cmc.frontend.UserInteraction;
import junit.framework.Assert;

public class AccountControllerTest {

	private static String username = "this_is_a_unique_name";
	private static String username1 = "badUsername";
	private static String password = "this_is_a_unique_password";
	private static String password1 = "badPassword";
	private static String firstName = "Isaiah";
	private static String firstName1 = "Thomas";
	private static String lastName = "Silver";
	private static String lastName1 = "Shelby";
	private static boolean isAdmin = true;
	//for deactivated user
	private static String username3 = "Cormac";
	
	@Before
	public void setUp() throws Exception {
		User user1 = new User (username, password, 'u', firstName1, lastName1, 'y');
		DatabaseController.addUser(user1);
		User user2 = new User (username1, password1, 'u', "", "", 'y');
		User user3 = new User(username3, password, 'u', firstName1, lastName, 'n');
		DatabaseController.addUser(user3);
			}

	@After
	public void tearDown() throws Exception {
		DatabaseController.removeUser(username);
		DatabaseController.removeUser(username1);
		DatabaseController.removeUser(username3);
	}

	//this test counts as a white box (true/false)
		@Test
	public void testLogin() {
		Assert.assertEquals(username, AccountController.login(username, password).getUsername());//valid login
		Assert.assertNull(AccountController.login(username, "hello"));//invalid login 
		
	}

	@Test//white box testing
	public void testAddUser() {
		Assert.assertEquals(true, AccountController.addUser(username1, password1, firstName, lastName, isAdmin));//add user not in database
		Assert.assertEquals(false, AccountController.addUser(username, password, firstName, lastName, isAdmin));//add user already in database
	}

	@Test//white box testing
	public void testRemoveUser() {
		Assert.assertEquals(true, AccountController.removeUser(username));//remove user already in the database
		Assert.assertEquals(false, AccountController.removeUser(username1));//remove user that's not in the database
		}

	@Test//white bix testing
	public void testEditPassword() {
		Assert.assertEquals(true, AccountController.editPassword(username, password1));//edit a password that is already in the database
	}

	@Test//white box testing
	public void testEditFirstName() {
		Assert.assertEquals(true, AccountController.editFirstName(username, firstName1));//edit a first name that is already in the database
	}

	@Test//white box testing
	public void testEditLastName() {
		Assert.assertEquals(true, AccountController.editLastName(username, lastName1));//edit a last name that is already in the database
	}

	@Test//This is my example of black box testing 
	public void testDeactivateUser() {
		Assert.assertEquals(true, AccountController.deactivateUser(username));//activated
		Assert.assertEquals(false, AccountController.deactivateUser("Kappa8765432"));// doesn't exist
		Assert.assertEquals(true, AccountController.deactivateUser(username3));//deactivated
	}

	@Test//black box testing
	public void testActivateUser() {
		Assert.assertEquals(true, AccountController.activateUser(username));//activated
		Assert.assertEquals(false, AccountController.activateUser("Kappa8765432"));// doesn't exist
		Assert.assertEquals(true, AccountController.activateUser(username3));//deactivated
	}
	

}
