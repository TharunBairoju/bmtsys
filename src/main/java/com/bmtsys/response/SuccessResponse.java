package com.bmtsys.response;

import java.io.Serializable;

/**
 * created on : Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public class SuccessResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String message;
	private Object body;

	public SuccessResponse(int code, String message, Object body) {
		this.code = code;
		this.message = message;
		this.body = body;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
