package com.iteriam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.corp.calculator.TracerImpl;


/**
 * Main class for the SpringBootIteriamCalculatorApplication
 * @author Fernando Olivares
 * @version 1.0
 *
 */
@SpringBootApplication
public class SpringBootIteriamCalculatorApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootIteriamCalculatorApplication.class, args);
	}
}
