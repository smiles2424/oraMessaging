package oramessaging.models;

/**
 * Data structure to match desired JSON outputs
 */
public class Metadata {
  private Pager pagination;

  public Metadata(Pager pagination){
    this.pagination = pagination;
  }

  public Pager getPagination() {
    return this.pagination;
  }
}
