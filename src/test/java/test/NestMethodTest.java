package test;

/**
 * PackageName test
 * Created by wangkang on 2018/1/17.
 */
public class NestMethodTest {
    private static void test1(){
        Object o = new Object();
        System.out.println("o hashcode: " + o.hashCode());
        test2(o);
        if (o == null){
            System.out.println("o is empty!");
        }else {
            System.out.println("o is not empty!");
        }
    }
    private static void test2(Object t){
        if (t != null){
            System.out.println("t hashcode: " + t.hashCode());
            t = null;
        }
    }

    public static void main(String[] args) {
        test1();
        System.exit(0);
    }

}
