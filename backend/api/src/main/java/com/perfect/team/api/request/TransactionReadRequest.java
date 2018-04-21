package com.perfect.team.api.request;

import javax.ws.rs.QueryParam;

public class TransactionReadRequest {

  @QueryParam("id")
  private Long id;

  @QueryParam("date")
  private Long date;

  @QueryParam("categoryId")
  private Long categoryId;

  @QueryParam("accountId")
  private Long accountId;

  @QueryParam("userId")
  private Long userId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
