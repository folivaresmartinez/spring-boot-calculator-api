package com.iteriam.calculator.interfaces;

import java.util.Optional;

import com.iteriam.calculator.model.CalculationDTO;
import com.iteriam.calculator.model.CalculationRequest;

public interface ICalculatorService {

	CalculationDTO add(Optional<CalculationRequest> values);

	CalculationDTO multiply(Optional<CalculationRequest> values);

	CalculationDTO subtract(Optional<CalculationRequest> values);
}
