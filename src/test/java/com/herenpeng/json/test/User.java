package com.herenpeng.json.test;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author herenpeng
 * @since 2021-07-04 20:15
 */
public class User implements Serializable {

    private String username;

    private String password;

    private BigDecimal money;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public User(String username, String password, BigDecimal money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public User() {
    }
}
