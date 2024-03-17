package regression;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.SearchController;
import cmc.backend.UniversityController;
import junit.framework.Assert;

public class RemoveUniversityTest {

	@Before
	public void setUp() throws Exception {
		UniversityController.addUniversity("school2324", "R&B", "Trap", "POP", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
		UniversityController.deleteUniversity("school2324");
	}	

	@Test
	public void test() {
		UniversityController.deleteUniversity("school2324");
		Assert.assertEquals(0, SearchController.search("school2324", "", "", "", 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE).size());
	}

}
