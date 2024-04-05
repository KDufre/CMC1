package cmc.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.University;
import cmc.backend.entities.User;
import cmc.backend.entities.UserSchool;
import junit.framework.Assert;

public class SearchControllerTest {
	
	
	@Before
	public void setUp() throws Exception {
		AccountController.addUser("5thPrez", "Monroedoctrine", "James", "Monroe", false);
		UniversityController.addUniversity("JamesMonroeUniversity", "Virginia", "MonroeHall", "Public", 1758, 0.0, 900, 1200, 71831, 40, 10000, 60, 90, 8, 7, 5, 0, "google.com");
		UniversityController.saveSchool("5thPrez", "JamesMonroeUniversity");
	}

	@After
	public void tearDown() throws Exception {
		UniversityController.removeSchool("5thPrez", "JamesMonroeUniversity");
		AccountController.removeUser("5thPrez");
		UniversityController.deleteUniversity("JamesMonroeUniversity");
	}

	@Test
	public void testSearch() {
		System.out.println(         SearchController.search("", "", "MonroeHall", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", "", "", ""));
		//List<University> list = //SearchController.search("JamesMonroeUniversity", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", "", "", "");
		//System.out.println(list);
		//Assert.assertEquals(list.size(), 0);
	}

	@Test
	public void testGetSavedSchools() {
		List<UserSchool> list2 = SearchController.getSavedSchools("5thPrez");
		Assert.assertEquals(list2.size(), 1);
	}

	@Test
	public void testGetAllUsers() {
		List<User> list3 = SearchController.getAllUsers();
		Assert.assertEquals(list3.size(), 9);
	}
	

}

