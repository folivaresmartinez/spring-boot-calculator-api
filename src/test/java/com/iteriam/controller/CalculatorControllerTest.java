package com.iteriam.controller;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import junit.framework.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.MessageFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iteriam.calculator.exception.BadRequestException;
import com.iteriam.calculator.model.CalculationDTO;

import io.corp.calculator.TracerImpl;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private TracerImpl tracerUtil = new TracerImpl();
	
	private static String strParams = "firstValue={0}&secondValue={1}";
	
    
	@BeforeEach                           
	void setUp() {   
		strParams = "firstValue={0}&secondValue={1}"; 
	}
	

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		
		tracerUtil.trace("shouldReturnDefaultMessage");
		
		this.mockMvc.perform(get("/api/calculator/home")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World")));
	}
	
    @Test
    void addOperationMustReturnBadRequestException_Case_1 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "6", "xx");
   		
   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/add?" + strParams)
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
		
		MvcResult result = resultActions.andReturn();
		
		assertTrue((result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value()) &&
				(result.getResponse().getErrorMessage().equals("Please enter a valid input values")) && 
				(result.getResponse().getContentLength() == 0));
				
    }
    
    @Test
    void addOperationMustReturnBadRequestException_Case_2 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "xx", "10");
            
	   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/add?" + strParams)
			           .contentType(MediaType.APPLICATION_JSON)
			           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
			
			MvcResult result = resultActions.andReturn();
			
			assertTrue((result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value()) &&
					(result.getResponse().getErrorMessage().equals("Please enter a valid input values")) && 
					(result.getResponse().getContentLength() == 0));
    }
    
    @Test
    void addOperationMustReturnBadRequestException_Case_3 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "10", "5");
            
   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/add?" + strParams)
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		MvcResult result = resultActions.andReturn();
		
		
		assertTrue(result.getResponse().getStatus() == HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		CalculationDTO calculationDTO = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<CalculationDTO>() {});
		
		if(calculationDTO != null ) {
			
			assertEquals(15, calculationDTO.getResult().intValue());
		}
    }    

    
    @Test
    void substactOperationMustReturnBadRequestException_Case_1 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "6", "xx");
            
	   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/subtract?" + strParams)
			           .contentType(MediaType.APPLICATION_JSON)
			           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
			
			MvcResult result = resultActions.andReturn();
			
			assertTrue((result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value()) &&
					(result.getResponse().getErrorMessage().equals("Please enter a valid input values")) && 
					(result.getResponse().getContentLength() == 0));
    }
    
    @Test
    void substractOperationMustReturnBadRequestException_Case_2 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "xx", "10");
            
	   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/subtract?" + strParams)
			           .contentType(MediaType.APPLICATION_JSON)
			           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
			
			MvcResult result = resultActions.andReturn();
			
			assertTrue((result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value()) &&
					(result.getResponse().getErrorMessage().equals("Please enter a valid input values")) && 
					(result.getResponse().getContentLength() == 0));
    }
    
    @Test
    void substractOperationMustReturnBadRequestException_Case_3 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "10", "5");
            
   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/subtract?" + strParams)
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		MvcResult result = resultActions.andReturn();
				
		assertTrue(result.getResponse().getStatus() == HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		CalculationDTO calculationDTO = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<CalculationDTO>() {});
		
		if(calculationDTO != null ) {
			
			assertEquals(5, calculationDTO.getResult().intValue());
		}
    }    
    
    
    @Test
    void multiplyOperationMustReturnBadRequestException_Case_1 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "6", "xx");
            
	   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/multiply?" + strParams)
			           .contentType(MediaType.APPLICATION_JSON)
			           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
			
			MvcResult result = resultActions.andReturn();
			
			assertTrue((result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value()) &&
					(result.getResponse().getErrorMessage().equals("Please enter a valid input values")) && 
					(result.getResponse().getContentLength() == 0));
    }
    
    @Test
    void multiplyOperationMustReturnBadRequestException_Case_2 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "xx", "10");
            
   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/multiply?" + strParams)
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
		
		MvcResult result = resultActions.andReturn();
		
		assertTrue((result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value()) &&
				(result.getResponse().getErrorMessage().equals("Please enter a valid input values")) && 
				(result.getResponse().getContentLength() == 0));
    }
    
    @Test
    void multiplyOperationMustReturnBadRequestException_Case_3 () throws Exception{
    	
   		strParams = MessageFormat.format(strParams, "10", "5");
            
   		ResultActions resultActions = this.mockMvc.perform(get("/api/calculator/multiply?" + strParams)
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		MvcResult result = resultActions.andReturn();
				
		assertTrue(result.getResponse().getStatus() == HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		CalculationDTO calculationDTO = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<CalculationDTO>() {});
		
		if(calculationDTO != null ) {
			
			assertEquals(50, calculationDTO.getResult().intValue());
		}
    }     	
}
