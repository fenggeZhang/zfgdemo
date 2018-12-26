package com.zfg.test.javatest;

/**
 * Created by zfg on 2018/12/25
 * 结束线程得几种方法
 * (1) 使用退出标记，使线程正常退出，也就是run方法完成之后完成线程
 * (2) 使用 interrupt()方法终止
 * (3) 使用stop方法强制终止线程（不推荐使用，会出现意想不到得问题，类似于断电操作）
 */
public class ThreadTest {
    public static volatile boolean exit = false;//volatile 同步得 同一个时刻只能由一个线程修改值

    public static void main(String[] strings) {
        //优雅中止线程  使用退出标志终止线程

        /**
         * 方法1
         */
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();
        stop();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                if (i == 4) {
                    exit = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /***********/
        /**
         * 方法2
         */
        ThreadSafe2 threadSafe2 = new ThreadSafe2();
        threadSafe2.start();
    }

    /**
     * 方法2  其实就是阻塞得时候 终止线程
     */
    public static class ThreadSafe2 extends Thread {
        public void run() {
            while (!isInterrupted()) {
                System.out.println("线程2 操作");
                try {
                    Thread.sleep(5 * 1000);//阻塞过程捕获中断异常来退出
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;//捕获到异常之后，执行break跳出循环。
                }
            }
        }
    }

    /**
     * 方法1
     */
    public static class ThreadSafe extends Thread {

        public void run() {
            while (!exit) {
                System.out.println("执行操作");
            }
        }
    }

    /**
     * 方法1
     */
    public static void stop() {
        if (exit) {
            exit = false;
        }
    }
}
