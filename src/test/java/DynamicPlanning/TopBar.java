package DynamicPlanning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * n层台阶没次只能上1阶或者2阶问有多少中方法
 * f(n) = f(n-1) + f(n+2)
 * f(1) = 1
 * f(2) = 2
 * PackageName DynamicPlanning
 * Created by wangkang on 2018/3/8.
 */
public class TopBar {
    /**
     * n->f(n)
     */
    private static Map<Integer,Integer> cache = new HashMap<>();
    public static int calculate(int n){
        if (n == 1 || n == 2){
            cache.put(n,n);
            return n;
        }
        Integer n_1 = cache.get(n-1);
        if (n_1 == null){
            n_1 = calculate(n-1);
            cache.put(n-1,n_1);
        }
        Integer n_2 = cache.get(n-2);
        if (n_2 == null){
            n_2 = calculate(n-2);
            cache.put(n-2,n_2);
        }
        return n_1 + n_2;
    }

    public static void main(String[] args) {
//        int n_10_5 = fun(10,5);
//        int n_100_5 = fun(100,5);
//        System.out.println("n_10_5 = " + n_10_5);
//        System.out.println("n_100_5 = " + n_100_5);
        int m10_n3 = fun(10,3);
        System.out.println("m10_n3 " + m10_n3);
//        int m5_n2 = fun(5,2);
//        System.out.println("m5_n2 " + m5_n2);
//        int m6_n2 = fun(6,2);
//        System.out.println("m6_n2 " + m6_n2);
//        int m30_n8 = fun(30,8);
//        System.out.println("m30_n8 " + m30_n8);
//        int m8_n2 = fun(8,2);
//        System.out.println("m8_n2 " + m8_n2);
        System.exit(0);
    }

    /**
     * f(m) = m
     *0 < m < 100    0 < n < 100
     */
    public static int fun(int m,int n){
        List<Integer> arr = new ArrayList<>();
        for (int i = 0;i < m;i++){
            arr.add(i+1);
        }
//        while (arr.size() > n){
//            List<Integer> tmp = new ArrayList<>();
//            for (int i = 0;i<arr.size();i++){
//                int index = i+1;
//                if (!(index % n == 0)){
//                    tmp.add(arr.get(i));
//                }
//            }
//            arr = tmp;
//        }
//        while(arr.size() != 1){
//            arr.remove(n % arr.size());
//        }
        return cal2(arr,n);
    }

    public static int cal(List<Integer> arr,int n){
        List<Integer> remove = new ArrayList<>();
        int index = 1;
        int i = 0;
        while(arr.size() != 1){
            if (index == n && i < arr.size()){
                int r = arr.remove(i);
                remove.add(r);
                index = 1;
                continue;
            }
            index++;
            i = (i+1) % arr.size();
        }
        for (Integer r : remove){
            System.out.print(r + " ");
        }
        System.out.println();
        return arr.get(0);
    }

    public static int cal2(List<Integer> arr,int n){
        List<Integer> remove = new ArrayList<>();
        int index = n;
        int s = 0;
        while((s = arr.size()) != 1){
            int i = (index % s)-1;
            remove.add(arr.remove(i));
            index = (i+n);
        }
        for (Integer r : remove){
            System.out.print(r + " ");
        }
        System.out.println();
        return arr.get(0);
    }
}
