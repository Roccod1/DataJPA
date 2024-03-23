package com.DataProject.DataJPA.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.DataProject.DataJPA.errors.JpaDataApiException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(JpaDataApiException.class)
	public ResponseEntity<Object> handleJpaDataApiException(JpaDataApiException ex) {
		// Costruiamo la risposta da restituire
		ApiErrorResponse response = new ApiErrorResponse(ex.getHttpStatus(), ex.getApplicationCode().getDescription(),
				ex.getObject());

		return new ResponseEntity<>(response, ex.getHttpStatus());
	}

	private static class ApiErrorResponse {
		private HttpStatus status;
		private String message;
		private Object details;

		public ApiErrorResponse(HttpStatus status, String message, Object details) {
			this.status = status;
			this.message = message;
			this.details = details;
		}

		public HttpStatus getStatus() {
			return status;
		}

		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Object getDetails() {
			return details;
		}

		public void setDetails(Object details) {
			this.details = details;
		}
		
	}

}
