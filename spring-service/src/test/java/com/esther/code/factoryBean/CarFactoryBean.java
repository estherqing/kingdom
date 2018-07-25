package com.esther.code.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author esther
 * 2018-07-24 17:34
 * 生产car的FactoryBean
 */

public class CarFactoryBean implements FactoryBean<Car> {
    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setPrice(Double.valueOf(infos[1]));
        car.setMaxSpeed(Integer.valueOf(infos[2]));
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
