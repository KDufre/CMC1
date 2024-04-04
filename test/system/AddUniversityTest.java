package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.SearchController;
import cmc.backend.UniversityController;
import junit.framework.Assert;

public class AddUniversityTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		UniversityController.deleteUniversity("Texas123hieh99393939344");
	}

	@Test
	public void test() {
		UniversityController.addUniversity("Texas123hieh99393939344", "Cali", "Mexico", "Japan", 10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Assert.assertEquals(1, SearchController.search("Texas123hieh99393939344", "", "", "", 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, "", "", "", "", "").size());
	}

}
