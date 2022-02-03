package com.iteriam.calculator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iteriam.calculator.model.CalculationDTO;
import com.iteriam.calculator.model.CalculationRequest;
import com.iteriam.calculator.service.CalculatorService;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

	@Autowired
	CalculatorService calculatorService;
	
	@Autowired
	private TracerImpl tracerUtil;

	
	/**
	 * Test method published by the REST controller
	 * @return
	 */
	@GetMapping("/home")
	public String Home() {
		return "Hello World!";
	}	

	@Operation(summary = "add", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = CalculationRequest.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input for the first and secodd value") }, operationId = "add")
	@GetMapping(value = "/add")
	public ResponseEntity<CalculationDTO> add(CalculationRequest values) {
		
		tracerUtil.trace(values);
		
        return ResponseEntity.ok().body(this.calculatorService.add(Optional.ofNullable(values)));
	}
	
	@Operation(summary = "subtract", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = CalculationRequest.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input for the first and secodd value") }, operationId = "subtract")
	@GetMapping(value = "/subtract")
	public ResponseEntity<CalculationDTO> subtract(CalculationRequest values) {
		

		return ResponseEntity.ok().body(this.calculatorService.subtract(Optional.ofNullable(values)));
	}
	
	@Operation(summary = "multiply", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
			@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = CalculationRequest.class))),
			@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "multiply")
	@GetMapping(value = "/multiply")
	public ResponseEntity<CalculationDTO> multiply(CalculationRequest values) {
	
	return ResponseEntity.ok().body(this.calculatorService.multiply(Optional.ofNullable(values)));
	
	}
		
}
