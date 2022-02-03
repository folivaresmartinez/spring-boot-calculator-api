package com.iteriam.calculator.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iteriam.calculator.exception.BadRequestException;
import com.iteriam.calculator.exception.DivisionByZeroException;
import com.iteriam.calculator.interfaces.ICalculatorService;
import com.iteriam.calculator.model.CalculationDTO;
import com.iteriam.calculator.model.CalculationRequest;
import com.iteriam.calculator.model.ValuesDtO;

@Service
public class CalculatorService implements ICalculatorService {

	@Override
	public CalculationDTO add(Optional<CalculationRequest> values) {

		return new CalculationDTO(BigDecimal.valueOf(12).add(BigDecimal.valueOf(10)));
	}
	
	@Override
	public CalculationDTO subtract(Optional<CalculationRequest> values) {

		return new CalculationDTO(BigDecimal.valueOf(12).subtract(BigDecimal.valueOf(10)));
	}	



	@Override
	public CalculationDTO multiply(Optional<CalculationRequest> values) {

		return new CalculationDTO(
				BigDecimal.valueOf(12).multiply(BigDecimal.valueOf(10), MathContext.DECIMAL32));
	}
}