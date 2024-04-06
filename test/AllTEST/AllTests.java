package AllTEST;

import org.junit.runner.RunWith; 
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cmc.backend.DatabaseControllerTest;
import cmc.backend.SearchControllerTest;
import cmc.backend.UniversityTest;
import cmc.backend.UserSchoolTest;
import cmc.backend.UserTest;
import regression.*;
import system.*;

@RunWith(Suite.class)
@SuiteClasses({ DatabaseControllerTest.class, SearchControllerTest.class, UniversityTest.class, UserSchoolTest.class,
		UserTest.class, DeactivatedUserTest.class, RemoveUserTest.class, SearchWithoutStateTest.class, ActivateUserTest.class
		, AddSavedSchoolsTest.class, AddUniversityTest.class, AddUserTest.class, EditUserTest.class, LoggingUserTest.class
		, RemoveUniversityTest.class})
public class AllTests {

}
