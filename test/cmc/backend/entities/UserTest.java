package cmc.backend.entities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.User;

public class UserTest {
	private static User testUser;
	private static String testUname = "testuname";
	private static String testPass = "testpass";
	private static char testType = 'u';
	private static String testFName = "Test";
	private static String testLName = "AUser";
	private static char testActivated = 'Y';

	@Before
	public void setUp() throws Exception {
		testUser = new User(testUname, testPass, testType, testFName, testLName, testActivated);
	}

	@After
	public void tearDown() throws Exception {
		// No database use for unit testing this class, so nothing to "tear down"!
	}
	
	@Test
	public void testConstructor() {
		Assert.assertEquals(testFName, testUser.getFirstName());
		Assert.assertEquals(testLName, testUser.getLastName());
		Assert.assertEquals('Y', testUser.getActivated());
	}

	@Test
	public void testIsAdmin() {
		Assert.assertFalse(testUser.isAdmin());
		testUser.setType('a');
		Assert.assertTrue(testUser.isAdmin());
	}
	
	@Test
	public void testGetUsername() {
		Assert.assertEquals(testUname, testUser.getUsername());
	}
	
	@Test
	public void testGetPassword() {
		Assert.assertEquals(testPass, testUser.getPassword());
	}
	
	@Test
	public void testSetPassword() {
		testUser.setPassword("Lalo");
		Assert.assertEquals("Lalo", testUser.getPassword());
	}
	
	@Test
	public void testGetType() {
		Assert.assertEquals(testPass, testUser.getPassword());
	}
	
	@Test
	public void testSetType() {
		testUser.setType('u');
		Assert.assertEquals('u', testUser.getType());
	}
	
	@Test
	public void TestgetFirstName() {
		Assert.assertEquals("Test", testUser.getFirstName());
	}
	
	@Test
	public void TestsetFirstName() {
		testUser.setFirstName("Will.I.Am");
		Assert.assertEquals("Will.I.Am", testUser.getFirstName());
	}
	
	@Test
	public void TestgetLastName() {
		Assert.assertEquals("AUser", testUser.getLastName());
	}
	
	@Test
	public void TestsetLastName() {
		testUser.setLastName("Valverde01");
		Assert.assertEquals("Valverde01", testUser.getLastName());
	}
	
	@Test
	public void TestgetActivated() {
		Assert.assertEquals('Y', testUser.getActivated());
	}
	
	@Test
	public void TestsetActivated() {
		testUser.setActivated('Y');
		Assert.assertEquals('Y', testUser.getActivated());
	}

}
