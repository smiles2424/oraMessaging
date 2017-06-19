package oramessaging.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import oramessaging.helpers.PasswordMatches;

@Entity
@PasswordMatches
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  @NotNull
  @NotEmpty
  private String email;
  @NotNull
  @NotEmpty
  private String name;
  @NotNull
  @NotEmpty
  // @JsonProperty(access = Access.WRITE_ONLY)
  private String password;
  @NotNull
  @NotEmpty
  @JsonProperty(access = Access.WRITE_ONLY)
  private String confirmedPassword;

  protected User() {  }

  public long getId(){
    return this.id;
  }

  public String getEmail(){
    return this.email;
  }

  public String getName(){
    return this.name;
  }

  public String getPassword(){
    return this.password;
  }

  public String getConfirmedPassword() {
    return this.confirmedPassword;
  }

  public void setPassword(String pass) {
    this.password = pass;
  }

  public void setConfirmedPassword(String pass) {
    this.confirmedPassword = pass;
  }

  @Override
  public String toString() {
    return String.format(
      "User[id=%d, name='%s', password='%s']",
      this.id,
      this.name,
      this.password
    );
  }

}
