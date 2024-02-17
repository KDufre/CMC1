package regression;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddSavedSchoolsTest.class, DeactivatedUserTest.class, RemoveUserTest.class,
		SearchWithoutStateTest.class })
public class AllRegressionTests {

}
