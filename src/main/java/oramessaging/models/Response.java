package oramessaging.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Response<T> {
  private T data;
  @JsonInclude(Include.NON_NULL)
  private String message;
  private Metadata meta;
  @JsonInclude(Include.NON_NULL)
  private Iterable<Error> errors;

  public Response(T data) {
    this.data = data;
  }

  public T getData() {
    return this.data;
  }

  public String getMessage() {
    return this.message;
  }

  public Metadata getMetadata() {
    return this.meta;
  }

  public Iterable<Error> getErrors() {
    return this.errors;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setMetadata(Metadata meta) {
    this.meta = meta;
  }

  public void setErrors(Iterable<Error> errors) {
    this.errors = errors;
  }

  

}