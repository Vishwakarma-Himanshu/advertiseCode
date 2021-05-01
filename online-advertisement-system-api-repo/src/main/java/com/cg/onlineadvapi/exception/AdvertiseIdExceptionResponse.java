package com.cg.onlineadvapi.exception;

/**
 * This class is used to get mentioned field 
 * @author hvishwak
 *
 */
public class AdvertiseIdExceptionResponse {

	private String advertiseId;
	
	public AdvertiseIdExceptionResponse(String advertiseId) {
		super();
		this.advertiseId = advertiseId;
	}

	public String getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(String advertiseId) {
		this.advertiseId = advertiseId;
	}
	
}
