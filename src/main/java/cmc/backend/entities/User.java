package cmc.backend.entities;

public class User {
	public String username;
	public String password;
	public char type; // u or a
	public String firstName;
	public String lastName;
	public char activated; // Y or N

	public User(String username, String password, char type, String firstName,
			String lastName, char activated) {
		this.username = username;
		this.password = password;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.activated = activated;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		// NOTE: we cannot modify the username, since this is the core
		// "id" for users in the database (and must be unique)
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	// return true if the user is an admin ('a') type,
	// or false otherwise
	public boolean isAdmin() {
		return (type == 'a');
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the activated
	 */
	public char getActivated() {
		return activated;
	}

	/**
	 * @param activated the activated to set
	 */
	public void setActivated(char activated) {
		this.activated = activated;
	}
	
	public boolean isActivated() {
		return (activated=='Y');
	}

}
