package com.iteriam.calculator.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iteriam.calculator.exception.BadRequestException;
import com.iteriam.calculator.interfaces.ICalculatorService;
import com.iteriam.calculator.model.CalculationDTO;
import com.iteriam.calculator.model.CalculationRequest;
import com.iteriam.calculator.model.ValuesDtO;


@Service
public class CalculatorService implements ICalculatorService {

	@Override
	public CalculationDTO add(Optional<CalculationRequest> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(CalculationRequest::getFirstValue), values.flatMap(CalculationRequest::getSecondValue));

		float firstValue = checkValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);
		float secondValue = checkValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);

		return new CalculationDTO(BigDecimal.valueOf(firstValue).add(BigDecimal.valueOf(secondValue)));
	}
	
	@Override
	public CalculationDTO subtract(Optional<CalculationRequest> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(CalculationRequest::getFirstValue), values.flatMap(CalculationRequest::getSecondValue));

		float firstValue = checkValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);
		float secondValue = checkValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);

		return new CalculationDTO(BigDecimal.valueOf(firstValue).subtract(BigDecimal.valueOf(secondValue)));
	}	



	@Override
	public CalculationDTO multiply(Optional<CalculationRequest> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(CalculationRequest::getFirstValue), values.flatMap(CalculationRequest::getSecondValue));

		float firstValue = checkValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);
		float secondValue = checkValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);

		return new CalculationDTO(
				BigDecimal.valueOf(firstValue).multiply(BigDecimal.valueOf(secondValue), MathContext.DECIMAL32));
	}
}