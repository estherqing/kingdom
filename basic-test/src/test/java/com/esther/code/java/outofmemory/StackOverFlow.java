package com.esther.code.java.outofmemory;

/**
 * @author esther
 * 2018-07-19 19:56
 * 栈溢出
 */

public class StackOverFlow {
    private int i;

    public void plus() {
        i++;
        plus();
    }

    public static void main(String[] args) {

        StackOverFlow stackOverFlow = new StackOverFlow();
        try {
            stackOverFlow.plus();
        } catch (Exception e) {
            System.out.println("Exception:stack length:" + stackOverFlow.i);
            e.printStackTrace();
        } catch (Error e) {
            System.out.println("Error:stack length:" + stackOverFlow.i);
            e.printStackTrace();
        }
    }
}
