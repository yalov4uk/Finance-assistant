package com.perfect.team.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Account implements Serializable {

    private Long id;

    private String name;

    private String icon;

    private Long initialBalance;

    private Date initialDate;

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

    public Long getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Long initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name) &&
                Objects.equals(icon, account.icon) &&
                Objects.equals(initialBalance, account.initialBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, icon, initialBalance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", initialBalance=" + initialBalance +
                ", initialDate=" + initialDate +
                '}';
    }
}
