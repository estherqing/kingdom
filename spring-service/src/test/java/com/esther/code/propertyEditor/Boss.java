package com.esther.code.propertyEditor;

import com.esther.code.factoryBean.Car;

import java.util.Date;

/**
 * @author esther
 * 2018-07-25 10:18
 * $DESCRIPTION}
 */

public class Boss {
    private String name;
    private Car car;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", date=" + date +
                '}';
    }
}
