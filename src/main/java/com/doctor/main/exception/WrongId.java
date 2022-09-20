package com.doctor.main.exception;

public class WrongId extends RuntimeException{

	private String Msg;

	public WrongId(String msg) {
		Msg = msg;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}
}
