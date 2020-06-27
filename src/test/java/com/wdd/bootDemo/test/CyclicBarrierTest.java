package com.wdd.bootDemo.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

   static class  TaskCyclicBarrier extends Thread{

        CyclicBarrier cyclicBarrier;
        int num;

        public  TaskCyclicBarrier(CyclicBarrier cyclicBarrier,int threadNum){
            this.cyclicBarrier=cyclicBarrier;
            this.num = threadNum;
            //this.setName("线程"+num);
        }

        @Override
        public void run() {

            try {
                System.out.println(getName()+"到达栅栏");
                cyclicBarrier.await();
                Thread.sleep(10000);
                System.out.println(getName()+"冲出栅栏");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        int tNum = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println(Thread.currentThread().getName()+"执行任务打破栅栏");
        });

        for (int i = 0; i < 5; i++) {
            new TaskCyclicBarrier(cyclicBarrier,i).start();
        }

    }
}
