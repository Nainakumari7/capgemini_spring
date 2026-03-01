package com.capgemini.assignment2_26_02_26.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ApplicationException {
		@ExceptionHandler(Exception.class)
		public String handleException() {
			return "Exception Handle Method";
		}
		
		@ExceptionHandler(DataNotExists.class)
		public String handleException1() {
			return "Data Not Exist";
		}


}