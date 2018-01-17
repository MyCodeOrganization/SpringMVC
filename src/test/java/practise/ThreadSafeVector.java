package practise;

import java.util.Random;
import java.util.Vector;

/**
 * 这个类主要是想验证vector的安全性，事实证明vector的安全性还是可以保障的
 * PackageName practise
 * Created by wangkang on 2018/1/16.
 */
public class ThreadSafeVector {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello").append("world");
        unsafeVector();
    }
    private static void unsafeVector(){
        for (int i = 0; i<20;i++){
            vector.add(i);
        }
        Thread removeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < vector.size(); i++) {
                    Integer v = vector.remove(i);
                    System.out.println("remove thread: " + v);
                }
            }
        });

        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<vector.size();i++){
                    Integer v = vector.get(i);
                    System.out.println("read thread: " + v);
                }
            }
        });
        removeThread.start();
        readThread.start();
        while (Thread.activeCount() > 20){
            System.out.println("activeCount: " + Thread.activeCount());
        }
    }

    private void safeVector(){
        for (int i = 0; i<20;i++){
            vector.add(i);
        }
        Thread removeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        Random r = new Random();
                        int sleep = r.nextInt(5);
                        try {
                            Thread.sleep(sleep*100);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        Integer v = vector.remove(i);
                        System.out.println("sleep: " + sleep*100 + "   remove thread: " + v);
                    }
                }
            }
        });

        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (vector){
                    for (int i=0;i<vector.size();i++){
                        Random r = new Random();
                        int sleep = r.nextInt(5);
                        try {
                            Thread.sleep(sleep*100);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        Integer v = vector.get(i);
                        System.out.println("sleep: " + sleep*100 +"    read thread: " + v);
                    }
                }
            }
        });
        removeThread.start();
        readThread.start();
        while (Thread.activeCount() > 20);
    }

}
