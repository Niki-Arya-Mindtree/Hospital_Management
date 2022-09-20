package com.doctor.main.exception;

public class EmptyData extends RuntimeException{
	
	private String Msg;

	public EmptyData(String msg) {
		Msg = msg;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}
}
