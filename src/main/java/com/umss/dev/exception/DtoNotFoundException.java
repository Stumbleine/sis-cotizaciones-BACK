package com.umss.dev.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DtoNotFoundException extends RuntimeException {

    public DtoNotFoundException(String objName, Integer Id) {
    	super("%s con id = %s no pudo ser encontrado.".format(objName,Id));
    }
}
