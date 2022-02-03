package com.iteriam.calculator.interfaces;

import java.util.Optional;

import com.iteriam.calculator.model.CalculationRequest;
import com.iteriam.calculator.model.ValuesDtO;
import com.iteriam.calculator.model.CalculationDTO;

public interface ICalculatorService {

	CalculationDTO add(Optional<CalculationRequest> values);

	default CalculationDTO divide(Optional<CalculationRequest> values) {
		return null;
	}

	CalculationDTO multiply(Optional<CalculationRequest> values);

	CalculationDTO subtract(Optional<CalculationRequest> values);
}
