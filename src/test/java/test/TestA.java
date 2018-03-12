package test;

/**
 * PackageName test
 * Created by wangkang on 2018/3/7.
 */
public class TestA {
    static {
        System.out.println("1");
    }
    public void show(){
        System.out.println("2");
    }
}
class TestB extends TestA{
    static {
        System.out.println("a");
    }
    public void show(){
        System.out.println("b");
    }

    public static void main(String[] args) {
        TestA a = new TestB();
        StringBuffer str = new StringBuffer();
        str.append("aaaa");
        StringBuilder sb = new StringBuilder();
        sb.append("bbbb");
        System.exit(0);
    }
}
