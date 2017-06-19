package oramessaging.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
  private Pager pagination;

  public Metadata(Pager pagination){
    this.pagination = pagination;
  }

  public Pager getPagination() {
    return this.pagination;
  }
}
