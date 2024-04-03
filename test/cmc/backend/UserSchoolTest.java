package cmc.backend;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UserSchoolTest {
	private String University = "William";
	private Date timestamp = new Date(234);
	private UserSchool userschool;

	@Before
	public void setUp() throws Exception {
		userschool = new UserSchool(University, timestamp);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testUserSchool() {
		Assert.assertEquals("William", userschool.getUniversity());
		userschool.setUniversity("Valverde");
		Assert.assertEquals("Valverde",userschool.getUniversity());
		
		Date newdate = new Date(123);
		Assert.assertEquals(timestamp, userschool.getTimestamp());
		userschool.setTimestamp(newdate);
		Assert.assertEquals(newdate, userschool.getTimestamp());
		
	}


}
