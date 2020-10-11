package com.alehyem.personalfinances.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = -299089265220451433L;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Portfolio> portfolios;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "role")
    private Role role;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "country")
    private String country;

    @Column(name = "banned")
    private String banned;

    @Column(name = "transaction_banned")
    private String transaction_banned;

    public User() {
    }

    public User(Role role, String login, String password, String email, String name,
                String surname, String country, String banned, String transaction_banned) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.banned = banned;
        this.transaction_banned = transaction_banned;
    }

    public void add(Portfolio portfolio) {
        if (portfolios == null) {
            portfolios = new ArrayList<>();
        }
        portfolios.add(portfolio);
        portfolio.setUser(this);
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public String getTransactionBanned() {
        return transaction_banned;
    }

    public void setTransactionBanned(String transaction_banned) {
        this.transaction_banned = transaction_banned;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", banned='" + banned + '\'' +
                ", transaction_banned='" + transaction_banned + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        User newUser = (User) object;
        return getLogin().equals(newUser.getLogin()) &&
                getEmail().equals(newUser.getEmail());
    }

    @Override
    public int hashCode() {
        return getLogin().hashCode() + getEmail().hashCode();
    }
}