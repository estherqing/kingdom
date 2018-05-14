package com.esther.code.api.schema.service.observer.ordinary;

import com.esther.code.api.schema.observer.ordinary.Observer;
import com.esther.code.api.schema.observer.ordinary.Subject;

/**
 * 显示器，既是观察者又是被观察者
 * @author Administrator
 *
 */
public class Display extends Subject implements Observer {
    private boolean isBoiled = false;   //表示水是否烧开了
    private int displayTemperature;     //定义显示器的温度

    public boolean isBoiled() {
        return isBoiled;
    }

    public void setBoiled(boolean isBoiled) {
        this.isBoiled = isBoiled;
    }

    @Override
    public void update(String state) {
        displayTemperature = Integer.parseInt(state);
        System.out.println("当前显示器显示的温度是："+displayTemperature);
        this.displayTemperature(displayTemperature);

    }

    private void displayTemperature(int temperature){
        if(temperature>100){
            this.setBoiled(true);
            this.notifyAllObservers(Boolean.toString(isBoiled));
        }
    }
}
