package practise;

import java.util.Random;

/**
 * PackageName practise
 * Created by wangkang on 2018/1/29.
 */
public class Singleton {
    private int num;
    private static volatile Singleton instance = null;
    private Singleton(){
        this.num = new Random().nextInt();
    }
    public int getNum(){
        return num;
    }
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    return instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton s = Singleton.getInstance();
                System.out.println("num1: " + s.num);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton s = Singleton.getInstance();
                System.out.println("num2: " + s.num);
            }
        });
        t1.start();
        t2.start();
        while (Thread.activeCount() > 20);
    }
}
