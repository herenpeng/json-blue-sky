package com.herenpeng.json.test;

import java.io.Serializable;

/**
 * @author herenpeng
 * @since 2021-07-02 23:08
 */
public class Car implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String name) {
        this.name = name;
    }

    public Car() {
    }
}
