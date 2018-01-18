package practise.T1_10;

/**
 * 输入一个整形数组，数组里有正数也有负数。
 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 求所有子数组的和的最大值。要求时间复杂度为 O(n)。
 例如输入的数组为 1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为 3, 10, -4, 7, 2，
 因此输出为该子数组的和 18。
 * PackageName practise.T1_10
 * Created by wangkang on 2018/1/18.
 */
public class MaxChildArray {
    /**
     * 数组里有正数也有负数 这句话是关键,只要加和小于0就丢弃原来的加和，重新开始计算
     * 初始最大值应该取一个极小数，
     * 如果数组全部都是整数，毫无疑问就是整个数组的加和
     * 如果数组全部是负数，哪最大值应该是最大的哪个负数
     * @param arr
     * @return
     */
    private static int maxSubArray(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int max = -(1<<31);
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
            if (sum > max){
                max = sum;
            }else if(sum < 0){
                sum = 0;//如果加和小于0就丢弃
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int sunmax = maxSubArray(arr);
        System.out.println("submax: " + sunmax);
        int [] arr1  = {4,2,1,6,8,5};
        int submax = maxSubArray(arr1);
        System.out.println("submax: " + submax);
        int[] arr2 = {-4,-2,-1,-6,-8,-5};
        int submax2 = maxSubArray(arr2);
        System.out.println("submax: " + submax2);
        System.exit(0);
    }
}
