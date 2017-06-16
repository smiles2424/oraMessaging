package oraMessaging.models;

import java.util.Date;

public class Chat {
  private final long id;
  private final String content;
  private final Date date;

  public Chat(long id, String content){
    this.id = id;
    this.content = content;
    this.date = new Date();
  }

  public long getId() {
    return this.id;
  }

  public String getContent() {
    return this.content;
  }

  public Date getDate() {
    return this.date;
  }

}