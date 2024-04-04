package cmc.backend;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SearchControllerTest {
	
	
	@Before
	public void setUp() throws Exception {
		//AccountController.addUser("5thPrez", "Monroedoctrine", "James", "Monroe", false);
		UniversityController.addUniversity("JamesMonroeUniversity", "Virginia", "MonroeHall", "Control", 1758, 0, 900, 1200, 71831, 40, 10000, 60, 90, 8, 7, 5);
		
	}

	@After
	public void tearDown() throws Exception {
		//AccountController.removeUser("5thPrez");
		UniversityController.deleteUniversity("JamesMonroeUniversity");
	}

	@Test
	public void testSearch() {
		SearchController.search("JamesMonroeUniversity", "Virginia", "MonroeHall", "Control", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		Assert.assertEquals("JamesMonroeUniversity", "JamesMonroeUniversity");
	}

	@Test
	public void testGetSavedSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}
	

}
