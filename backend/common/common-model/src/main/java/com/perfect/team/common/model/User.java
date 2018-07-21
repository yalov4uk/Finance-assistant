package com.perfect.team.common.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

  private Long id;

  private String name;

  private String email;

  private String password;

  private Boolean confirmed;

  private List<Account> accounts;

  private List<Category> categories;

  private List<Transaction> transactions;

  private List<Transfer> transfers;

  private List<Confirmation> confirmations;

  public User() {
  }

  public User(Long id, boolean confirmed) {
    this.id = id;
    this.confirmed = confirmed;
  }

  public User(String name, String email, boolean confirmed) {
    this.name = name;
    this.email = email;
    this.confirmed = confirmed;
  }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public List<Transfer> getTransfers() {
    return transfers;
  }

  public void setTransfers(List<Transfer> transfers) {
    this.transfers = transfers;
  }

  public List<Confirmation> getConfirmations() {
    return confirmations;
  }

  public void setConfirmations(List<Confirmation> confirmations) {
    this.confirmations = confirmations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name) &&
        Objects.equals(email, user.email) &&
        Objects.equals(password, user.password) &&
        Objects.equals(confirmed, user.confirmed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, password, confirmed);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", confirmed=" + confirmed +
        '}';
  }
}
