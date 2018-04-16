package indi.linj2n.filterDemo.domain;

import java.io.Serializable;

public class User implements Serializable {
	 
	private static final long serialVersionUID = 7992978088679477411L;
	
	private int id;
	private String name;
	private String password;
	private String mail;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
