package test;

import sun.nio.ch.ThreadPool;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * PackageName test
 * Created by wangkang on 2018/2/27.
 */
public class ArraysSort {
    public static void main(String[] args) {
        Integer[] arr = {4,1,6,3,2,8,6};
        Arrays.sort(arr);
        for (int a : arr){
            System.out.print(a + "\t");
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.exit(0);
    }
}
