package com.school.management.bean;

import java.util.Date;

public class ResponseException {
	
	private Date exceptionDate;
	private String exceptionMessage;
	private String details;
	public Date getExceptionDate() {
		return exceptionDate;
	}
	public void setExceptionDate(Date exceptionDate) {
		this.exceptionDate = exceptionDate;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ResponseException(Date exceptionDate, String exceptionMessage, String details) {
		super();
		this.exceptionDate = exceptionDate;
		this.exceptionMessage = exceptionMessage;
		this.details = details;
	}
	@Override
	public String toString() {
		return "ResponseException [exceptionDate=" + exceptionDate + ", exceptionMessage=" + exceptionMessage
				+ ", details=" + details + "]";
	}

}
