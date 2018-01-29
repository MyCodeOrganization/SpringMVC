package practise;

/**
 * PackageName practise
 * Created by wangkang on 2018/1/24.
 */
public class SimpleTest {
    private static String dd = "hello";
    private static void change(int b){
        System.out.println("b="+b);
        b = 10;
    }

    public static void main(String[] args) {
        int a = 5;
        change(a);
        String cc = new SimpleTest().dd;
        System.out.println("cc=" + cc);
        System.out.println("a=" + a);
        System.exit(0);
    }
}
