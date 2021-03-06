package com.iteriam.calculator.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Validated
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
		
		tracerUtil.trace("Dummy method implemented to test the connection to the controller layer");
		
		return "Hello World!";
	}	

	@Operation(summary = "addWithParams", tags = {
	"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
			@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = Float.class))),
			@ApiResponse(responseCode = "400", description = "Please enter a valid input for the first and secodd value") }, operationId = "add")
	@GetMapping(value = "/addWithParams")
	public ResponseEntity<CalculationDTO> addWithParams(@RequestParam(required = true, name = "firstValue") @NotNull float firstValue, @RequestParam(required = true, name = "secondValue") @NotBlank  float secondValue) {
			
		return ResponseEntity.ok().body(this.calculatorService.addWithParams(Optional.ofNullable(firstValue), Optional.ofNullable(secondValue)));
	}
	
	
	@Operation(summary = "add", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = CalculationRequest.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input for the first and secodd value") }, operationId = "add")
	@GetMapping(value = "/add")
	public ResponseEntity<CalculationDTO> add(CalculationRequest values) {
				
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
