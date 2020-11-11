package com.balaji.login;

public class LoginService {

	public boolean isUserValid(String user, String password) {
		if (user.equals("balaji") && password.equals("balaji"))
			return true;

		return false;
	}

}
