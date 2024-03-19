package regression;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddSavedSchoolsTest.class, DeactivatedUserTest.class, RemoveUserTest.class,
		SearchWithoutStateTest.class, editPasswordTest.class, AddUniversityTest.class, RemoveUniversityTest.class,
		editLastNameTest.class, editFirstNameTest.class})
public class AllRegressionTests {

}
