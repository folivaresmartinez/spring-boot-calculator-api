package com.iteriam.calculator.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteriam.calculator.exception.BadRequestException;
import com.iteriam.calculator.interfaces.ICalculatorService;
import com.iteriam.calculator.model.CalculationDTO;
import com.iteriam.calculator.model.CalculationRequest;
import com.iteriam.calculator.model.ValuesDtO;

import io.corp.calculator.TracerImpl;


@Service
public class CalculatorService implements ICalculatorService {

	@Autowired
	private TracerImpl tracerUtil;
	
	private float firstValue = 0;
	private float secondValue = 0;
	
	/**
	 * Method that implement the parsing operation over the input values
	 * @param values: Values to parse
	 */
	private void GetValuesFromRequest(Optional<CalculationRequest> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(CalculationRequest::getFirstValue), values.flatMap(CalculationRequest::getSecondValue));

		
		try {
			
			firstValue = checkValues.getFirstValue().map(Float::parseFloat).orElseThrow(BadRequestException::new);
			secondValue = checkValues.getSecondValue().map(Float::parseFloat).orElseThrow(BadRequestException::new);
			
		} catch(BadRequestException exc) {

			tracerUtil.trace(ExceptionUtils.getStackTrace(exc));	
			
			throw exc;
		}		
	}
	
	@Override
	public CalculationDTO add(Optional<CalculationRequest> values) {
		
		tracerUtil.trace("Operation: Add, values: " + values);
		
		GetValuesFromRequest(values);

		return new CalculationDTO(BigDecimal.valueOf(firstValue).add(BigDecimal.valueOf(secondValue)));			
	}
	
	@Override
	public CalculationDTO subtract(Optional<CalculationRequest> values) {

		tracerUtil.trace("Operation: Subtract, values: " + values);
		
		GetValuesFromRequest(values);
		
		return new CalculationDTO(BigDecimal.valueOf(firstValue).subtract(BigDecimal.valueOf(secondValue)));
	}	


	@Override
	public CalculationDTO multiply(Optional<CalculationRequest> values) {
		
		tracerUtil.trace("Operation: Multiply, values: " + values);

		GetValuesFromRequest(values);
		
		return new CalculationDTO(BigDecimal.valueOf(firstValue).multiply(BigDecimal.valueOf(secondValue), MathContext.DECIMAL32));
	}
}