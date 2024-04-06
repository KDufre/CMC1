package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.SearchController;
import cmc.backend.UniversityController;
import cmc.backend.entities.University;
import junit.framework.Assert;

public class AddUniversityTest {
	
	private String state = "Minnesota";
	private String location = "city";
	private String school = "43908579348759374985";
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
		UniversityController.deleteUniversity("Texas123hieh99393939344");
	}

	@Test
	public void test() {
		UniversityController.addUniversity(uni);
		Assert.assertEquals(1, SearchController.search(uni.getSchool(), "", "", "", 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, "", "", "", "", "").size());
	}

}
