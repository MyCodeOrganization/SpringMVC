package practise;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/**
 * PackageName practise
 * Created by wangkang on 2018/1/30.
 */
public class LoadUnsafeInstance {
    private int var1;
    private double var2;
    private String var3;

    public static Unsafe getUnsafeInstance() throws Exception{
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe)theUnsafe.get(Unsafe.class);
    }

    public static long sizeOf(Object o) throws Exception{
        Unsafe u = getUnsafeInstance();
        HashSet<Field> fields = new HashSet<>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }
        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = u.objectFieldOffset(f);
            System.out.println("field: " + f.getName() + "  offset: " + offset);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }
        return ((maxSize/8) + 1) * 8;   // padding
    }

    public static long sizeof2(Object o) throws Exception{
        Unsafe u = getUnsafeInstance();
        u.throwException(new IOException());
        return u.getAddress(normalize(u.getInt(o,4L))+ 12L);
    }

    private static long normalize(int value) {
        if(value >= 0) return value;
        return (~0L >>> 32) & value;
    }
    private static void fakepasswd(){
        String passwd = new String("100wj#o@l");
        String fake = new String(passwd.replaceAll(".","?"));
        System.out.println("passwd: " + passwd);
        System.out.println("fake: " + fake);

    }

    public static void main(String[] args) throws Exception{
        int[] arr = new int[32];
        Unsafe u = getUnsafeInstance();
        int base = u.arrayBaseOffset(arr.getClass());
        int b = u.arrayIndexScale(arr.getClass());
        int ashift = 31 - Integer.numberOfLeadingZeros(b);
        u.putIntVolatile(arr,((long)10<<ashift)+base,20);
        System.out.println("a=" + base);
        System.out.println("b=" + ashift);
        System.out.println("arr[10]=" + arr[10]);
        System.exit(0);
    }
}
