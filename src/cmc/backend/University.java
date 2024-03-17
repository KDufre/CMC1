/**
 * 
 */
package cmc.backend;

/**
 * 
 */
public class University {
	public String state;
	public String location;
	public String school;
	public String control;
	public int numStudents;
	public double PercentFemale;
	public int SATMath;
	public int SATVerbal;
	public double expenses;
	public double PercentFA;
	public int NumApplicants;
	public double PercentAdmitted;
	public double PercentEnrolled;
	public int SocialScale;
	public int AcademicScale;
	public int QualLife;
	public University(String state, String location, String school, String control, int numStudents,
			double percentFemale, int sATMath, int sATVerbal, double expenses, double percentFA, int numApplicants,
			double percentAdmitted, double percentEnrolled, int socialScale, int academicScale, int qualLife) {
		super();
		this.state = state;
		this.location = location;
		this.school = school;
		this.control = control;
		this.numStudents = numStudents;
		this.PercentFemale = percentFemale;
		this.SATMath = sATMath;
		this.SATVerbal = sATVerbal;
		this.expenses = expenses;
		this.PercentFA = percentFA;
		this.NumApplicants = numApplicants;
		this.PercentAdmitted = percentAdmitted;
		this.PercentEnrolled = percentEnrolled;
		this.SocialScale = socialScale;
		this.AcademicScale = academicScale;
		this.QualLife = qualLife;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * @return the control
	 */
	public String getControl() {
		return control;
	}
	/**
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}
	/**
	 * @return the numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}
	/**
	 * @param numStudents the numStudents to set
	 */
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	/**
	 * @return the percentFemale
	 */
	public double getPercentFemale() {
		return PercentFemale;
	}
	/**
	 * @param percentFemale the percentFemale to set
	 */
	public void setPercentFemale(double percentFemale) {
		PercentFemale = percentFemale;
	}
	/**
	 * @return the sATMath
	 */
	public int getSATMath() {
		return SATMath;
	}
	/**
	 * @param sATMath the sATMath to set
	 */
	public void setSATMath(int sATMath) {
		SATMath = sATMath;
	}
	/**
	 * @return the sATVerbal
	 */
	public int getSATVerbal() {
		return SATVerbal;
	}
	/**
	 * @param sATVerbal the sATVerbal to set
	 */
	public void setSATVerbal(int sATVerbal) {
		SATVerbal = sATVerbal;
	}
	/**
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}
	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	/**
	 * @return the percentFA
	 */
	public double getPercentFA() {
		return PercentFA;
	}
	/**
	 * @param percentFA the percentFA to set
	 */
	public void setPercentFA(double percentFA) {
		PercentFA = percentFA;
	}
	/**
	 * @return the numApplicants
	 */
	public int getNumApplicants() {
		return NumApplicants;
	}
	/**
	 * @param numApplicants the numApplicants to set
	 */
	public void setNumApplicants(int numApplicants) {
		NumApplicants = numApplicants;
	}
	/**
	 * @return the percentAdmitted
	 */
	public double getPercentAdmitted() {
		return PercentAdmitted;
	}
	/**
	 * @param percentAdmitted the percentAdmitted to set
	 */
	public void setPercentAdmitted(double percentAdmitted) {
		PercentAdmitted = percentAdmitted;
	}
	/**
	 * @return the percentEnrolled
	 */
	public double getPercentEnrolled() {
		return PercentEnrolled;
	}
	/**
	 * @param percentEnrolled the percentEnrolled to set
	 */
	public void setPercentEnrolled(double percentEnrolled) {
		PercentEnrolled = percentEnrolled;
	}
	/**
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return SocialScale;
	}
	/**
	 * @param socialScale the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		SocialScale = socialScale;
	}
	/**
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return AcademicScale;
	}
	/**
	 * @param academicScale the academicScale to set
	 */
	public void setAcademicScale(int academicScale) {
		AcademicScale = academicScale;
	}
	/**
	 * @return the qualLife
	 */
	public int getQualLife() {
		return QualLife;
	}
	/**
	 * @param qualLife the qualLife to set
	 */
	public void setQualLife(int qualLife) {
		QualLife = qualLife;
	}



}
