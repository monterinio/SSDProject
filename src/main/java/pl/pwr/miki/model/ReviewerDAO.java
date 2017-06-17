package pl.pwr.miki.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReviewerDAO {
	@Id
	private long id;
	
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
