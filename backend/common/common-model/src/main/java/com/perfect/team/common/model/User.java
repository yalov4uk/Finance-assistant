package com.perfect.team.common.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

  private Long id;

  private String name;

  private List<Account> accounts;

  private List<Category> categories;

  private List<Transaction> transactions;

  private List<Transfer> transfers;

  private List<Confirmation> confirmations;

  private List<Credential> credentials;

  public User() {
  }

  public User(Long id) {
    this.id = id;
  }

  public User(String name) {
    this.name = name;
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

  public List<Credential> getCredentials() {
    return credentials;
  }

  public void setCredentials(List<Credential> credentials) {
    this.credentials = credentials;
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
    return Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
