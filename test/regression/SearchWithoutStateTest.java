package regression;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.DatabaseController;
import cmc.backend.SystemController;

public class SearchWithoutStateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<String[]> list = SystemController.search("", "", "", "", 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
		Assert.assertTrue(list.size()==(DatabaseController.getAllSchools().size()));
	}

}
