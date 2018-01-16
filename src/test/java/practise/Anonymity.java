package practise;

/**
 * PackageName practise
 * Created by wangkang on 2018/1/15.
 */
public class Anonymity {
    public static void main(String[] args) {
        new AnonyClass(){
            {
                /**
                 * 该代码区在当前对象初始化的时候执行，匿名类是抽象类的子类，当前代码区在父类构造器执行之后执行
                 */
                System.out.println("1111");
            }
            @Override
            public void show() {
                System.out.println("3333");
            }
        };
        System.exit(0);
    }
}
abstract class AnonyClass{
    static {
        System.out.println("22222");
    }
    public AnonyClass(){
        System.out.println("44444");
    }
    public abstract void show();
}