package cmc.backend;

import java.util.List;

public class AccountController {
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
	public static boolean addUser(String username, String password,
			String firstName, String lastName, boolean isAdmin) {
		char type = (isAdmin ? 'a' : 'u');

		User theUser = new User(username, password, type, firstName,
				lastName, 'Y');
		return DatabaseController.addUser(theUser);
	}

	// this ADMIN ONLY method attempts to remove a user from the database
	// based on the provided username
	public static boolean removeUser(String username) {
		return DatabaseController.removeUser(username);
	}

	//changes password
	public static boolean editPassword(String username, String newPassword) {
		return DatabaseController.editPassword(username, newPassword);
	}
	//changes firstName
	public static boolean editFirstName(String username, String newFirstName) {
		return DatabaseController.editFirstName(username, newFirstName);
	}
	//changes lastName
	public static boolean editLastName(String username, String newLastName) {
		return DatabaseController.editLastName(username, newLastName);
	}

	public static boolean deactivateUser(String username) {
		return DatabaseController.deactivateUser(username);
	}

	public static boolean activateUser(String username) {
		return DatabaseController.activateUser(username);
	}
}
