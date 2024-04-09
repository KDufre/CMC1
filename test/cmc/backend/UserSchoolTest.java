package cmc.backend;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.UserSchool;
import junit.framework.Assert;

public class UserSchoolTest {
	private String University = "William";
	private Date timestamp = new Date(234);
	private UserSchool userschool;
	private Date newdate;

	@Before
	public void setUp() throws Exception {
		userschool = new UserSchool(University, timestamp);
		Date newdate = new Date(123);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testgetUniversity() {
		Assert.assertEquals("William", userschool.getUniversity());
	}
	
	@Test
	public void testsetUniversity() {
		userschool.setUniversity("Valverde");
		Assert.assertEquals("Valverde",userschool.getUniversity());
	}
	
	@Test
	public void testgetTimestamp() {
		Assert.assertEquals(timestamp, userschool.getTimestamp());
	}
	
	@Test
	public void testsetTimestamp() {
		userschool.setTimestamp(newdate);
		Assert.assertEquals(newdate, userschool.getTimestamp());
	}


}
