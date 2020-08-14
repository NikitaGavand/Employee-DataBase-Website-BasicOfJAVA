package com.cg.empmaintenance.exception;

@SuppressWarnings("serial")
public class EmployeeException extends Exception {
	String message;

	public EmployeeException(String msg) {

		{
			message = msg;
		}
	}

	@Override
	public String getMessage() {
		return message;
	}
}
