package com.raghu.astro.domain.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ApiResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiResponse() {
		super();
		status = new Status();
		payload = new ArrayList();
	}

	private Status status;

	private List payload;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List getPayload() {
		return payload;
	}

	public void setPayload(List payload) {
		this.payload = payload;
	}

}

