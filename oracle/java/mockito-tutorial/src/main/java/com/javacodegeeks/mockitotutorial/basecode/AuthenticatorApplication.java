package com.javacodegeeks.mockitotutorial.basecode;

public class AuthenticatorApplication {
	private AuthenticatorInterface authenticator;

	public AuthenticatorApplication(AuthenticatorInterface authenticator) {
		this.authenticator = authenticator;
	}
	
	public boolean authenticate(String username, String password) {
		boolean authenticated;
		authenticated = this.authenticator.authenticateUser(username, password);
		return authenticated;
	}
}
