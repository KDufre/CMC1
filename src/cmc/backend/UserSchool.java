package cmc.backend;

import java.util.Date;

public class UserSchool {
	
	public String University;
	public Date timestamp;
	/**
	 * @param university
	 * @param timestamp
	 */
	public UserSchool(String university, Date timestamp) {
		this.University = university;
		this.timestamp = timestamp;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return University;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		University = university;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
