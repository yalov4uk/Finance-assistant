package com.perfect.team.business.model;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {

  private Long id;

  private String name;

  private String icon;

  private Type type;

  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
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
    Category category = (Category) o;
    return Objects.equals(name, category.name) &&
        Objects.equals(icon, category.icon) &&
        type == category.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, icon, type);
  }

  @Override
  public String toString() {
    return "Category{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", icon='" + icon + '\'' +
        ", type=" + type +
        '}';
  }

  public enum Type {
    INCOME, OUTCOME
  }
}
