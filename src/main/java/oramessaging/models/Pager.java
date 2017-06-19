package oramessaging.models;

public class Pager {
  private int current;
  private int perPage;
  private int pageCount;
  private int totalCount;

  public Pager(int current, int perPage, int pageCount, int totalCount){
    this.current = current;
    this.perPage = perPage;
    this.pageCount = pageCount;
    this.totalCount = totalCount;
  }

  public int getCurrent() {
    return this.current;
  }
  public int getPerPage() {
    return this.perPage;
  }
  public int getPageCount() {
    return this.pageCount;
  }
  public int getTotalCount() {
    return this.totalCount;
  }
  
}
