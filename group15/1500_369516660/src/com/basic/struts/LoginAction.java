package com.basic.struts;
/**
 * ��¼��ҵ����
 * @author Jodie
 *
 */
public class LoginAction {

	private String name;
	private String password;
	private String message;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute(){
		if("test".equals(name)&&"1234".equals(password)){
			this.message = "login successful";
			return "success";
		}
		this.message = "login fail,please check your name or password";
		return "fail";
	}
	
}
