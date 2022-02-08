package com.iteriam.calculator.model;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValuesDtO {

	/**
	 * First Operator Value 
	 */
	private Optional<String> firstValue;
	
	/**
	 * Second Operator Value
	 */
	private Optional<String> secondValue;
	
	/**
	 * Default Constructor
	 * @param firstValue: First Operator Value
	 * @param secondValue: Second Operator Value
	 */
	public ValuesDtO(Optional<String> firstValue, Optional<String> secondValue) {
		this.firstValue = firstValue.filter(str -> str.matches("(^\\d*\\.?\\d*[0-9]+\\d*$)|(^[0-9]+\\.?\\d*$)"));
		this.secondValue = secondValue.filter(str -> str.matches("(^\\d*\\.?\\d*[0-9]+\\d*$)|(^[0-9]+\\.?\\d*$)"));
	}

}