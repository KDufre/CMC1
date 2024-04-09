package system;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.backend.DatabaseController;
import cmc.backend.entities.University;
import junit.framework.Assert;

public class EditUniversityTest {
	private String state = "Minnesota";
	private String location = "city";
	private String school = "43908579348759374985";
	private String school2 = "28475908347598";
	private String school3 = "2847239857609823655908347598";
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
	private University uni; //This one gets added to database in setup
	private University uniedit;

	@Before
	public void setUp() throws Exception {
		uni = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,link);
		DatabaseController.addUniversity(uni);
		
		uniedit = new University (school, state, location, control, numStudents,
				PercentFemale, SATMath, SATVerbal, expenses, PercentFA, NumApplicants,
				PercentAdmitted, PercentEnrolled, SocialScale, AcademicScale, QualLife, 
				gradRate,"google.com");
	}

	@After
	public void tearDown() throws Exception {
		DatabaseController.deleteUniversity(uni.getSchool());
	}

	@Test
	public void test() {
		Assert.assertTrue(DatabaseController.editUniversity(uniedit));
		List<University> list = DatabaseController.getAllSchools();
		University uniSchool = uni;
		for(University school : list) {
			if(school.getSchool().equalsIgnoreCase(uniedit.getSchool())) {
				uniSchool = school;
			}
		}
		Assert.assertEquals(uniedit.getLink(), uniSchool.getLink());
	}

}
