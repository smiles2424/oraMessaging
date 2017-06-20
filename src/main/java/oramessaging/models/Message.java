package oramessaging.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import oramessaging.helpers.DateFormatter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Message {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  @NotNull
  private String content;
  private Date date;


  protected Message() {
    this.date = new Date();
  }

  public long getId() {
    return this.id;
  }

  public String getContent() {
    return this.content;
  }

  public String getDate() {
    return DateFormatter.formatDateToIso(this.date);
  }

  @Override
  public String toString() {
    return String.format(
      "Message[id=%d, content='%s', date=%d]", 
      this.id, 
      this.content, 
      this.date);
  }

}
