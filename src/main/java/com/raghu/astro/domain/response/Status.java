package com.raghu.astro.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Status {
	@JsonInclude
	private String code;
	@JsonInclude
	private String message;

	private Error error;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Status(String code) {
		super();
		this.code = code;
	}
	public Status() {
		super();
	}
}
