package com.esther.code.thread;

public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread previous=Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new Join(previous),"Thread "+i);
            thread.start();
            previous=thread;
        }
        System.out.println(Thread.currentThread().getName()+" teminate.");
    }
    static class Join implements Runnable{
        private Thread thread;
        public Join(Thread thread){
            this.thread=thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" teminate.");
        }
    }
}
