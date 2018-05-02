package com.perfect.team.business.model;

import java.io.Serializable;
import java.util.Objects;

public class Confirmation implements Serializable {

  private Long id;

  private String code;

  private Boolean confirmed;

  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Confirmation that = (Confirmation) o;
    return Objects.equals(code, that.code) &&
        Objects.equals(confirmed, that.confirmed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, confirmed);
  }

  @Override
  public String toString() {
    return "Confirmation{" +
        "id=" + id +
        ", code='" + code + '\'' +
        ", confirmed=" + confirmed +
        '}';
  }
}
