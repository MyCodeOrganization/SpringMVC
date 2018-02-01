package practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**o
 * PackageName practise
 * Created by wangkang on 2018/1/29.
 */
public class ConCurrentHashMapTest {
    private static int getNCPU(){
        return Runtime.getRuntime().availableProcessors();
    }

    private static void testConCurrentHashMap(){
        final Map<Integer,Integer> map = new ConcurrentHashMap<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i < 10;i++){
                    Random r = new Random();
                    Integer v = r.nextInt();
                    map.put(i,v);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=200;i<210;i++){
                    Random r = new Random();
                    Integer v = r.nextInt();
                    map.put(i,v);
                }
            }
        });
        t1.start();
        t2.start();
        while (Thread.activeCount() > 20);
    }
    private static void testSingleThread(){
        Map<String,String> map1 = new HashMap<>();
        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        for (int i=0;i<100;i++){
            Random r = new Random();
            Integer v = r.nextInt();
            map.put(i,v);
            int index = new Random().nextInt(100);
            Integer o = map.get(index);
            if (o != null){
                map.remove(o);
            }
        }
    }

    private static void SingleTestString(){
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("adasd","adasdads");
        map.put("fadfasd","fadfasd");
        map.put("adfadfa","asdfadsf");
        map.put("asdfasd","asdfasd");
    }
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static int numberOfLeadingZeros(int i) {
        // HD, Figure 5-6
        if (i == 0)
            return 32;
        int n = 1;
        if (i >>> 16 == 0) { n += 16; i <<= 16; }
        if (i >>> 24 == 0) { n +=  8; i <<=  8; }
        if (i >>> 28 == 0) { n +=  4; i <<=  4; }
        if (i >>> 30 == 0) { n +=  2; i <<=  2; }
        n -= i >>> 31;
        return n;
    }
    public static void main(String[] args) {
//        int ncpu = getNCPU();
//        System.out.println("ncpu: " + ncpu);
        //testSingleThread();
        //SingleTestString();
        System.exit(0);
    }
}
