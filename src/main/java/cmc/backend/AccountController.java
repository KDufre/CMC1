package cmc.backend;

import java.util.List;

import cmc.backend.entities.User;
import cmc.backend.entities.UserSchool;

public class AccountController {
	/**
	 * This method allows the user to login to the CMC.
	 * @param username is required to login
	 * @param password is also required to login
	 * @return User that logs in, if false it returns null
	 */
	public static User login(String username, String password) {
		User theUser = DatabaseController.getUser(username);


		if (theUser==null || !theUser.password.equals(password) || !theUser.username.equals(username) || theUser.getActivated() != 'Y') {
			return null;
		}
		else {
			return theUser;
		}
	}

	// this ADMIN ONLY method attempts to add a user to the database with the
	// provided details
	/**
	 * This method adds a User with their important information
	 * @param username is needed for login
	 * @param password is needed for login
	 * @param firstName is needed for the user identity
	 * @param lastName is the users last name
	 * @param isAdmin true if user is an admin, false if user is not an admin
	 * @return boolean true if the User was added successfully, false if the user was already added
	 */
	public static boolean addUser(String username, String password,
			String firstName, String lastName, boolean isAdmin) {
		char type = (isAdmin ? 'a' : 'u');

		User theUser = new User(username, password, type, firstName,
				lastName, 'Y');
		return DatabaseController.addUser(theUser);
	}

	// this ADMIN ONLY method attempts to remove a user from the database
	// based on the provided username
	/**
	 * This method removes a user from the database
	 * @param username that is being removed from the system
	 * @return boolean if successfully removed from the database
	 */
	public static boolean removeUser(String username) {
		return DatabaseController.removeUser(username);
	}

	//changes password
	/**
	 * This method allows the user to be able to edit their password
	 * @param username of user who wants to change their password
	 * @param newPassword the user enters their desired new password
	 * @return boolean true if changing the password was successfull
	 */
	public static boolean editPassword(String username, String newPassword) {
		User user = DatabaseController.getUser(username);
		User userUpdate = new User(username, newPassword, user.type, user.getFirstName(), user.getLastName(), user.activated);
		return DatabaseController.editUser(userUpdate);
	}
	//changes firstName
	/**
	 * This method allows the user to change their first name
	 * @param username the users username to know who is changing it
	 * @param newFirstName user enters their new name is updated
	 * @return boolean true if the update was successfull
	 */
	public static boolean editFirstName(String username, String newFirstName) {
		User user = DatabaseController.getUser(username);
		User userUpdate = new User(username, user.getPassword(), user.type, newFirstName, user.getLastName(), user.activated);
		return DatabaseController.editUser(userUpdate);
	}
	//changes lastName
	/**
	 * This method allows the user to change their last name
	 * @param username the users username to know who is changing it
	 * @param newFirstName user enters their new lastname is updated
	 * @return boolean true if the update was successfull
	 */
	public static boolean editLastName(String username, String newLastName) {
		User user = DatabaseController.getUser(username);
		User userUpdate = new User(username, user.getPassword(), user.type, user.getFirstName(), newLastName, user.activated);
		return DatabaseController.editUser(userUpdate);
	}
	/**
	 * This method allows admin to deactivate the user
	 * @param username of the user that is being deactivated
	 * @return boolean true if user is now deactivated
	 */
	public static boolean deactivateUser(String username) {
		return DatabaseController.deactivateUser(username);
	}
	/**
	 * This method allows admin to activate the user
	 * @param username of the user that is being activated
	 * @return boolean true if user is now activated
	 */
	public static boolean activateUser(String username) {
		return DatabaseController.activateUser(username);
	}
	
	public static User getUser(String username) {
		return DatabaseController.getUser(username);
	}
	public static List<User> getAllUsers(){
		return DatabaseController.getAllUsers();
	}
	public static boolean editUser(User user) {
		return DatabaseController.editUser(user);
	}
}
