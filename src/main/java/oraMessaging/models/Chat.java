package oraMessaging.models;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Chat {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  private String content;
  private Date date;

  protected Chat() {
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

  @Override
  public String toString() {
    return String.format(
      "Chat[id=%d, content='%s', date=%d]", 
      this.id, 
      this.content, 
      this.date);
  }

}