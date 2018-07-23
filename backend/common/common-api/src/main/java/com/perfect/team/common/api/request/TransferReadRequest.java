package com.perfect.team.common.api.request;

import javax.ws.rs.QueryParam;

public class TransferReadRequest {

  @QueryParam("id")
  private Long id;

  @QueryParam("date")
  private Long date;

  @QueryParam("fromAccountId")
  private Long fromAccountId;

  @QueryParam("toAccountId")
  private Long toAccountId;

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

  public Long getFromAccountId() {
    return fromAccountId;
  }

  public void setFromAccountId(Long fromAccountId) {
    this.fromAccountId = fromAccountId;
  }

  public Long getToAccountId() {
    return toAccountId;
  }

  public void setToAccountId(Long toAccountId) {
    this.toAccountId = toAccountId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
