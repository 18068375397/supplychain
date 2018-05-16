package com.xinyonghang.supplychain.utils;

public class ThreadUtils extends Thread {

    private ThreadUtils(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                this.yield();
            }
        }
    }


    public static void main(String[] args) {
        ThreadUtils yt1 = new ThreadUtils("张三");
        ThreadUtils yt2 = new ThreadUtils("李四");
        yt1.setPriority(Thread.MAX_PRIORITY);
        yt2.setPriority(Thread.MIN_PRIORITY);

        yt1.start();
        yt2.start();
    }

}


