package com.perfect.team.common.model;

import java.util.Objects;

public class Credentials {

  private Long id;

  private String username;

  private String password;

  private Type type;

  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
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
    Credentials that = (Credentials) o;
    return Objects.equals(username, that.username) &&
        Objects.equals(password, that.password) &&
        type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, type);
  }

  @Override
  public String toString() {
    return "Credentials{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", type=" + type +
        '}';
  }

  public enum Type {
    EMAIL
  }
}
