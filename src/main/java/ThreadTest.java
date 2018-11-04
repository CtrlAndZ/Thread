/**
 * 继承Thread类，重写该类的run()方法。
 */

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread myThread1 = null;
            Thread myThread2 = null;
            if (i == 30) {
                myThread1 = new MyThread();     // 创建一个新的线程  myThread1  此线程进入新建状态
                myThread2 = new MyThread();     // 创建一个新的线程 myThread2 此线程进入新建状态
                myThread1.start();                     // 调用start()方法使得线程进入就绪状态
                myThread2.start();                     // 调用start()方法使得线程进入就绪状态
            }
        }
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ " " + i);
        }
    }

}

/**
 * 运行结果：
 * 先后输出
 * main 1 - 99
 * Thread-1 1 - 99
 * Thread-2 1 - 99
 * 总结：
 * 调用线程的start()方法后，线程只是进入就绪状态
 * 先执行完主线程，然后再并发执行Thread1和Thread2
 */
