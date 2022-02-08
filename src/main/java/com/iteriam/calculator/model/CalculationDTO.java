package com.iteriam.calculator.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationDTO {

	/**
	 * operation Result.
	 */
	private BigDecimal result;

}