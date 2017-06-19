package oramessaging.models;

import java.io.Serializable;

import oramessaging.models.*;


public class Response<T> {
  private T data;
  private String message;
  private Metadata meta;
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