package com.security.demo.config;

public enum ApplicationUserPermission {
	
	SUTUDENT_READ("student:read"),
	SUTUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	private final String permission;
	
	ApplicationUserPermission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return this.permission;
	}
	

}
