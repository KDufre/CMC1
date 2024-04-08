package cmc.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.entities.University;
import junit.framework.Assert;

public class UniversityTest {
	private String state = "Minnesota";
	private String location = "city";
	private String school = "pp";
	private String control = "rt";
	private int numStudents = 12;
	private double PercentFemale = 12.5;
	private int SATMath = 123;
	private int SATVerbal = 12;
	private double expenses = 1234.0;
	private double PercentFA = 234.0;
	private int NumApplicants = 2;
	private double PercentAdmitted = 2.0;
	private double PercentEnrolled = 232.0;
	private int SocialScale = 12;
	private int AcademicScale = 1;
	private int QualLife = 2;
	private double gradRate = 2.3;
	private String link = "";
	private University uni;

	@Before
	public void setUp() throws Exception {
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetState() {
		Assert.assertEquals("Minnesota", uni.getState());
	}

	@Test
	public void testSetState() {
		uni.setState("helloo");
		Assert.assertEquals("helloo",uni.getState());
	}

	@Test
	public void testGetLocation() {
		Assert.assertEquals("city", uni.getLocation());
	}

	@Test
	public void testSetLocation() {
		uni.setLocation("cities");
		Assert.assertEquals("cities",uni.getLocation());
	}

	@Test
	public void testGetSchool() {
		Assert.assertEquals("pp", uni.getSchool());
	}

	@Test
	public void testSetSchool() {
		uni.setSchool("shark");
		Assert.assertEquals("shark",uni.getSchool());
	}

	@Test
	public void testGetControl() {
		Assert.assertEquals("rt", uni.getControl());
	}

	@Test
	public void testSetControl() {
		uni.setControl("Melodie");
		Assert.assertEquals("Melodie",uni.getControl());
	}

	@Test
	public void testGetNumStudents() {
		Assert.assertEquals(12, uni.getNumStudents());
	}

	@Test
	public void testSetNumStudents() {
		uni.setNumStudents(1900);
		Assert.assertEquals(1900 ,uni.getNumStudents());
	}

	@Test
	public void testGetPercentFemale() {
		Assert.assertEquals(12.5, uni.getPercentFemale());
	}

	@Test
	public void testSetPercentFemale() {
		uni.setPercentFemale(15.0);
		Assert.assertEquals(15.0 ,uni.getPercentFemale());
	}

	@Test
	public void testGetSATMath() {
		Assert.assertEquals(123, uni.getSATMath());
	}

	@Test
	public void testSetSATMath() {
		uni.setSATMath(757);
		Assert.assertEquals(757,uni.getSATMath());
	}

	@Test
	public void testGetSATVerbal() {
		Assert.assertEquals(12, uni.getSATVerbal());
	}

	@Test
	public void testSetSATVerbal() {
		uni.setSATVerbal(22);
		Assert.assertEquals(22, uni.getSATVerbal());
	}

	@Test
	public void testGetExpenses() {
		Assert.assertEquals(1234.0, uni.getExpenses());
	}

	@Test
	public void testSetExpenses() {
		uni.setExpenses(4321.0);
		Assert.assertEquals(4321.0, uni.getExpenses());
	}

	@Test
	public void testGetPercentFA() {
		Assert.assertEquals(234.0, uni.getPercentFA());
	}

	@Test
	public void testSetPercentFA() {
		uni.setPercentFA(3478.0);
		Assert.assertEquals(3478.0, uni.getPercentFA());
	}

	@Test
	public void testGetNumApplicants() {
		Assert.assertEquals(2, uni.getNumApplicants());
	}

	@Test
	public void testSetNumApplicants() {
		uni.setNumApplicants(25);
		Assert.assertEquals(25,uni.getNumApplicants());
	}

	@Test
	public void testGetPercentAdmitted() {
		Assert.assertEquals(2.0, uni.getPercentAdmitted());
	}

	@Test
	public void testSetPercentAdmitted() {
		uni.setPercentAdmitted(25.5);
		Assert.assertEquals(25.5,uni.getPercentAdmitted());
	}

	@Test
	public void testGetPercentEnrolled() {
		Assert.assertEquals(232.0, uni.getPercentEnrolled());
	}

	@Test
	public void testSetPercentEnrolled() {
		uni.setPercentEnrolled(1492.5);
		Assert.assertEquals(1492.5, uni.getPercentEnrolled());
	}

	@Test
	public void testGetSocialScale() {
		Assert.assertEquals(12, uni.getSocialScale());
	}

	@Test
	public void testSetSocialScale() {
		uni.setSocialScale(21);
		Assert.assertEquals(21, uni.getSocialScale());
	}

	@Test
	public void testGetAcademicScale() {
		Assert.assertEquals(1, uni.getAcademicScale());
	}

	@Test
	public void testSetAcademicScale() {
		uni.setAcademicScale(4);
		Assert.assertEquals(4, uni.getAcademicScale());
	}

	@Test
	public void testGetQualLife() {
		Assert.assertEquals(2, uni.getQualLife());
	}

	@Test
	public void testSetQualLife() {
		uni.setQualLife(3);
		Assert.assertEquals(3, uni.getQualLife());
	}

	@Test
	public void testGetGradRate() {
		Assert.assertEquals(2.3, uni.getGradRate());
	}

	@Test
	public void testSetGradRate() {
		uni.setGradRate(78.3);
		Assert.assertEquals(78.3, uni.getGradRate());
	}

	@Test
	public void testGetLink() {
		Assert.assertEquals("", uni.getLink());
	}

	@Test
	public void testSetLink() {
		uni.setLink("t");
		Assert.assertEquals("t",uni.getLink());
	}

}
