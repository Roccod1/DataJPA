package com.DataProject.DataJPA.errors;

import org.springframework.http.HttpStatus;

public class JpaDataApiException extends RuntimeException{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;

    private ApplicationCode applicationCode;

    private Object object;
    
    public JpaDataApiException(HttpStatus httpStatus, ApplicationCode applicationCode){
        this(httpStatus,applicationCode, null, null, null);
    }

    public JpaDataApiException(HttpStatus httpStatus, ApplicationCode applicationCode, Object object){
        this(httpStatus,applicationCode,object, null, null);
    }
    
    public JpaDataApiException(HttpStatus httpStatus, ApplicationCode applicationCode, Object object, String msg, Throwable cause){
        super(msg,cause);
        this.httpStatus=httpStatus;
        this.applicationCode=applicationCode;
        this.object=object;
    }
    
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ApplicationCode getApplicationCode() {
        return applicationCode;
    }

    public Object getObject() {
        return object;
    }
}
