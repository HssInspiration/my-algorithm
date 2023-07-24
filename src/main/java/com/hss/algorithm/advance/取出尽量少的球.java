package com.hss.algorithm.advance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:07
 * @Version 1.0.0
 */
public class 取出尽量少的球 {

    private static int sum;
    private static int len;
    private static int[] ints;

    public static void mains(String[] args) {
        Scanner sc = new Scanner(System.in);
        int SUM = sc.nextInt();
        int ballNumsLen = sc.nextInt();
        int[] ballNums = new int[ballNumsLen];
        //球的总数
        int ballCount = 0;
        for (int i = 0; i < ballNumsLen; i++) {
            //各个管子中的球的个数
            ballNums[i] = sc.nextInt();
            ballCount += ballNums[i];
        }
        //球的总数大于SUM时需要处理
        if (SUM < ballCount) {
            //maxCapacity的最小值
            int min = SUM / ballNumsLen;
            //maxCapacity的最大值
            int max = Arrays.stream(ballNums).max().getAsInt();
            //各个管子移除的球的个数数组（暂时存放）
            int[] tempOut = new int[ballNumsLen];
            //各个管子移除的球的个数数组
            int[] ballOut = {};
            for (int i = min; i <= max; i++) {
                //每个管子都需要移除i个球
                for (int j = 0; j < ballNumsLen; j++) {
                    tempOut[j] = Math.max(ballNums[j] - i, 0);
                }
                //取出的球的总数
                int outCount = Arrays.stream(tempOut).sum();
                //剩余的球的总数
                int remainCount = ballCount - outCount;
                //剩下的球大于SUM，则输出
                if (remainCount > SUM) {
                    break;
                } else {
                    ballOut = Arrays.copyOf(tempOut, tempOut.length);
                }
            }
            System.out.println(ballOut.length == 0 ? Arrays.toString(tempOut) : Arrays.toString(ballOut));
        } else {
            System.out.println("[]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sum = sc.nextInt();
        len = sc.nextInt();
        ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = sc.nextInt();
        }
        System.out.println(getBalls(Arrays.stream(ints).sum()));
    }

    private static String getBalls(int totalInts) {
        if (totalInts <= sum) {
            return "[]";
        }
        // 设定maxCapacity-数组中的最大元素，既可以取出的最多小球
        int maxCapacity = Arrays.stream(ints).max().getAsInt();
        // 设定minCapacity-最小取出数量
        int minCapacity = sum / len;
        int[] tempArray = new int[len];
        int[] acquireArray = {};
        for (int i = minCapacity; i <= maxCapacity; i++) {
            for (int j = 0; j < len; j++) {
                // 将可获取的小球数量存入临时数组
                tempArray[j] = Math.max(ints[j] - i, 0);
            }
            // 算出总数-取出的小球总数，如果大sum则跳出循环
            if (totalInts - Arrays.stream(tempArray).sum() > sum) {
                // 大于sum跳出循环
                break;
            }
            // 将临时数组赋给acquireArray
            acquireArray = Arrays.copyOf(tempArray, tempArray.length);
        }
        return acquireArray.length > 0 ? Arrays.toString(acquireArray) : Arrays.toString(tempArray);
    }
}
