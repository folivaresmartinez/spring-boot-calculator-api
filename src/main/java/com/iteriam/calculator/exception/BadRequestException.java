package com.iteriam.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please enter a valid input values")
@NoArgsConstructor
public class BadRequestException extends NumberFormatException {
	/**
	 *
	 */
	private static final long serialVersionUID = -5875017293268426173L;

}