package com.tlc.tracker.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class ErrorApi {

	private String codeError;
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> details;
}