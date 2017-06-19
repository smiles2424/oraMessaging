package oramessaging.models;

import oramessaging.models.*;

public class Metadata {
  private Pager pagination;

  public Metadata(Pager pagination){
    this.pagination = pagination;
  }

  public Pager getPagination() {
    return this.pagination;
  }
}
