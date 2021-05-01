package com.cg.onlineadvapi.exception;

public class NoAdvertiseExceptionResponse {

	private String noAdvertise;
	
	public NoAdvertiseExceptionResponse(String noAdvertise) {
		super();
		this.noAdvertise = noAdvertise;
	}

	public String getNoAdvertise() {
		return noAdvertise;
	}

	public void setNoAdvertise(String noAdvertise) {
		this.noAdvertise = noAdvertise;
	}
}
