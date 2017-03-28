package com.evoleht.util.exception;

public class IllegalOperationException extends Exception{
	
	public IllegalOperationException() {
		super();
	}
	
	public IllegalOperationException(String msg) {
		super(msg);
	}
	
	public Throwable fillInThrowable() {
		return this;
	}
}
