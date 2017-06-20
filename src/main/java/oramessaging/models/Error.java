package oramessaging.models;
/**
 * Bean for formatted errors
 */
public class Error {
  private String name;

  public Error(String name){
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
