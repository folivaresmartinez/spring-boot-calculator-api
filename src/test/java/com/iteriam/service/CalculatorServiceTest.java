package com.iteriam.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.iteriam.calculator.exception.BadRequestException;
import com.iteriam.calculator.model.CalculationDTO;
import com.iteriam.calculator.model.CalculationRequest;
import com.iteriam.calculator.service.CalculatorService;



@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
	
    @InjectMocks
    private CalculatorService caculatorService;
    
    private Optional<CalculationRequest> ocalculationRequest = Optional.empty();

    @BeforeEach
	public void setUp() {
    	ocalculationRequest = Optional.of(new CalculationRequest());
		
	}
    
    @Test
    public void addTwoValuesFirstValueIncorrect (){
    	
    	ocalculationRequest = Optional.of(new CalculationRequest());
    			
    	ocalculationRequest.get().setFirstValue(Optional.of("12A"));
    	ocalculationRequest.get().setSecondValue(Optional.of("10"));
    	
    	Assertions.assertThrows(BadRequestException.class, () -> {
    		caculatorService.add(ocalculationRequest);
    	});
    }
    
    @Test
    public void addTwoValuesSecondValueIncorrect (){
    	
    	ocalculationRequest = Optional.of(new CalculationRequest());
    			
    	ocalculationRequest.get().setFirstValue(Optional.of("12"));
    	ocalculationRequest.get().setSecondValue(Optional.of("10A"));
    	
    	Assertions.assertThrows(BadRequestException.class, () -> {
    		caculatorService.add(ocalculationRequest);
    	});
    }
    
    @Test
    public void addTwoValuesAreIncorrect (){
    	
    	ocalculationRequest = Optional.of(new CalculationRequest());
		
    	ocalculationRequest.get().setFirstValue(Optional.of("12"));
    	ocalculationRequest.get().setSecondValue(Optional.of("10A"));
    	
    	Assertions.assertThrows(BadRequestException.class, () -> {
    		caculatorService.add(ocalculationRequest);
    	});    }    

    @Test
    public void addTwoValuesAreCorrect (){
    	
    	ocalculationRequest = Optional.of(new CalculationRequest());
    			
    	ocalculationRequest.get().setFirstValue(Optional.of("12"));
    	ocalculationRequest.get().setSecondValue(Optional.of("10"));
    	
    	CalculationDTO result = caculatorService.add(ocalculationRequest);
    	
        assertEquals(result.getResult().intValue(), 22);
    }     
    
    @AfterEach
	public void after() {
    	ocalculationRequest = null;
		
	}

}

  
