package cmc.backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
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
	public void testUniversity() {
		Assert.assertEquals("Minnesota", uni.getState());
		uni.setState("helloo");
		Assert.assertEquals("helloo",uni.getState());
		
		Assert.assertEquals("city", uni.getLocation());
		uni.setLocation("cities");
		Assert.assertEquals("cities",uni.getLocation());
		
		Assert.assertEquals("pp", uni.getSchool());
		uni.setSchool("shark");
		Assert.assertEquals("shark",uni.getSchool());
		
		Assert.assertEquals("rt", uni.getControl());
		uni.setControl("Melodie");
		Assert.assertEquals("Melodie",uni.getControl());
		
		Assert.assertEquals(12, uni.getNumStudents());
		uni.setNumStudents(1900);
		Assert.assertEquals(1900 ,uni.getNumStudents());
		
		Assert.assertEquals(12.5, uni.getPercentFemale());
		uni.setPercentFemale(15.0);
		Assert.assertEquals(15.0 ,uni.getPercentFemale());
		
		Assert.assertEquals(123, uni.getSATMath());
		uni.setSATMath(757);
		Assert.assertEquals(757,uni.getSATMath());
		
		Assert.assertEquals(12, uni.getSATVerbal());
		uni.setSATVerbal(22);
		Assert.assertEquals(22, uni.getSATVerbal());
		
		Assert.assertEquals(1234.0, uni.getExpenses());
		uni.setExpenses(4321.0);
		Assert.assertEquals(4321.0, uni.getExpenses());
		
		Assert.assertEquals(234.0, uni.getPercentFA());
		uni.setPercentFA(3478.0);
		Assert.assertEquals(3478.0, uni.getPercentFA());
		
		Assert.assertEquals(2, uni.getNumApplicants());
		uni.setNumApplicants(25);
		Assert.assertEquals(25,uni.getNumApplicants());
		
		Assert.assertEquals(2.0, uni.getPercentAdmitted());
		uni.setPercentAdmitted(25.5);
		Assert.assertEquals(25.5,uni.getPercentAdmitted());
		
		Assert.assertEquals(232.0, uni.getPercentEnrolled());
		uni.setPercentEnrolled(1492.5);
		Assert.assertEquals(1492.5, uni.getPercentEnrolled());
		
		Assert.assertEquals(12, uni.getSocialScale());
		uni.setSocialScale(21);
		Assert.assertEquals(21, uni.getSocialScale());
		
		Assert.assertEquals(1, uni.getAcademicScale());
		uni.setAcademicScale(4);
		Assert.assertEquals(4, uni.getAcademicScale());
		
		Assert.assertEquals(2, uni.getQualLife());
		uni.setQualLife(3);
		Assert.assertEquals(3, uni.getQualLife());
		
		Assert.assertEquals(2.3, uni.getGradRate());
		uni.setGradRate(78.3);
		Assert.assertEquals(78.3, uni.getGradRate());
		
		Assert.assertEquals("", uni.getLink());
		uni.setLink("t");
		Assert.assertEquals("t",uni.getLink());
	}

}
