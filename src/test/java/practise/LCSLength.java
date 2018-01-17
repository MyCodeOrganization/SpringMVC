package practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 求最长公共子序列长度--->衍伸问题，怎么样求两个字符串的所有最长公共子序列
 * 输入两个字符串：BDCABA    ABCBDAB     最长公共子序列:BCBA=4
 * PackageName practise
 * Created by wangkang on 2018/1/17.
 */
public class LCSLength {
    private static int[][] childResult;
    private static List<Index> stack;
    private static void initChildResult(int m,int n){
        childResult = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                childResult[i][j] = 0;
            }
        }
        stack = new LinkedList<>();
    }
    private static int maxChildStrLength(char[] stra,char[] strb){
        int m = stra.length;
        int n = strb.length;
        initChildResult(m,n);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (stra[i] == strb[j]){
                    if (stack.isEmpty()){
                        Index in = new Index(i,j);
                        stack.add(in);
                    }else {
                        Index in = stack.get(stack.size()-1);
                        if (i > in.i && j > in.j){
                            stack.add(new Index(i,j));
                        }
                    }
                    if (i < 1 || j < 1){
                        childResult[i][j] = 1;
                    }else{
                        childResult[i][j] = childResult[i-1][j-1] + 1;
                    }
                }else{
                    if (i < 1 || j < 1){
                        childResult[i][j] = 0;
                    }else {
                        int a = childResult[i][j-1];
                        int b = childResult[i-1][j];
                        childResult[i][j] = a > b ? a : b;
                    }
                }
            }
        }
        return showAndMaxLength(childResult,m,n);
    }
    private static void showLCS(char[] stra,char[] strb){
        if (stack.isEmpty())
            return;
        for (int i = 0;i<stack.size();i++){
            Index in = stack.get(i);
            System.out.println(in.i + ":" + stra[in.i] + "   " + in.j + ":" + strb[in.j]);
        }
    }
    private static int showAndMaxLength(int[][] re,int m,int n){
        int max = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (re[i][j] > max){
                    max = re[i][j];
                }
                System.out.print(re[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        char[] stra = {'b','d','c','a','b','a'};
        char[] strb = {'a','b','c','b','d','a','b'};
        int m = maxChildStrLength(stra,strb);
        System.out.println("max length: " + m);
        showLCS(stra,strb);
        System.out.println("*****************");
        int n = maxChildStrLength(strb,stra);
        System.out.println("max length: " + n);
        showLCS(strb,stra);
        System.exit(0);
    }
    static class Index{
        int i;
        int j;
        Index(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
}
