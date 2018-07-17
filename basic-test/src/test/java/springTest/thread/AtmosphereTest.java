package springTest.thread;

import java.util.Random;

public class AtmosphereTest{
	 
    public static void main(String[] args) {
        Atmosphere atmosphere = new Atmosphere();
        AtmosphereSensor atmosphereSensor = new AtmosphereSensor(atmosphere);
        Computer computer = new Computer(atmosphereSensor);
        new Thread(atmosphereSensor).start();
        new Thread(computer).start();
    }
 
}
 
/**
 * 传感器 1.5秒/次 读取大气信息
 * 
 * @author 795829
 * 
 */
class AtmosphereSensor implements Runnable {
    private Atmosphere atmosphere;
 
    public AtmosphereSensor(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }
 
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }
 
    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }
 
    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {
                Thread.sleep(500);
                atmosphere.setHumidity(new Random(System.currentTimeMillis()).nextFloat());
                Thread.sleep(500);
                atmosphere.setTemperature(new Random(System.currentTimeMillis()).nextFloat());
                Thread.sleep(500);
                atmosphere.setWind(new Random(System.currentTimeMillis()).nextFloat());
                System.out.println("----- " + i++ + " 传感器数据    温度 = " + atmosphere.getTemperature() + ", 湿度 = "
                        + atmosphere.getHumidity() + ", 风速 = " + atmosphere.getWind());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
 
/**
 * 计算机 2秒/次 读取传感器数据
 * 
 * @author 795829
 * 
 */
class Computer implements Runnable {
 
    private AtmosphereSensor atmosphereSensor;
 
    public Computer(AtmosphereSensor atmosphereSensor) {
        this.atmosphereSensor = atmosphereSensor;
    }
 
    public AtmosphereSensor getAtmosphereSensor() {
        return atmosphereSensor;
    }
 
    public void setAtmosphereSensor(AtmosphereSensor atmosphereSensor) {
        this.atmosphereSensor = atmosphereSensor;
    }
 
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 50; i++) {
                Thread.sleep(2000);
                System.out.println(i + " 计算机数据    温度 = " + atmosphereSensor.getAtmosphere().getTemperature()
                        + ", 湿度 = " + atmosphereSensor.getAtmosphere().getHumidity() + ", 风速 = "
                        + atmosphereSensor.getAtmosphere().getWind());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
 
class Atmosphere {
    private float temperature;
    private float humidity;
    private float wind;
 
    public float getTemperature() {
        return temperature;
    }
 
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
 
    public float getHumidity() {
        return humidity;
    }
 
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
 
    public float getWind() {
        return wind;
    }
 
    public void setWind(float wind) {
        this.wind = wind;
    }
}
