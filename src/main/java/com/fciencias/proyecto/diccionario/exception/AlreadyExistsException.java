package com.fciencias.proyecto.diccionario.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(value = HttpStatus.IM_USED)
public class AlreadyExistsException extends RuntimeException{
  private String resourceName;
  private String fieldName;
  private String fieldValue;

  public AlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
    super(String.format("%s already exists with %s : '%s'", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }
}
