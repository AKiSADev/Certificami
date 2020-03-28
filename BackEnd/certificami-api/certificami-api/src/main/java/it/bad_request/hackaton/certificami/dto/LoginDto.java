package it.bad_request.hackaton.certificami.dto;

import java.security.MessageDigest;

public class LoginDto {

	String email;
	String psw;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
}
