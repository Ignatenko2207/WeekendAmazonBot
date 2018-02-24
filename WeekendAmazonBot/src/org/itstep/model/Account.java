package org.itstep.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {

	private String firstName;
	private String secondName;
	private String email;
	private String password;
	
	public Account(String firstName, String secondName, String email, String password) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.password = password;
	}
	
	public Account() {
	}
}
