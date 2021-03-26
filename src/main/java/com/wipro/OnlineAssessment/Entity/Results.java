package com.wipro.OnlineAssessment.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Results {
	private String Assessment;
	@Id
	private String TestDate;
	private int TestMarks;
	private int TotalMarks;
	private String email;
	private String result;
	
	public Results() {
	}
	
	public Results(String assessment, String testDate, int testMarks, int totalMarks, String email, String result) {
		super();
		Assessment = assessment;
		TestDate = testDate;
		TestMarks = testMarks;
		TotalMarks = totalMarks;
		this.email = email;
		this.result = result;
	}

	public String getAssessment() {
		return Assessment;
	}

	public void setAssessment(String assessment) {
		Assessment = assessment;
	}

	public String getTestDate() {
		return TestDate;
	}

	public void setTestDate(String testDate) {
		TestDate = testDate;
	}

	public int getTestMarks() {
		return TestMarks;
	}

	public void setTestMarks(int testMarks) {
		TestMarks = testMarks;
	}

	public int getTotalMarks() {
		return TotalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		TotalMarks = totalMarks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
