package com.hss.algorithm.august.mixins;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/7/17 8:14
 * @Version 1.0.0
 */
public class 分苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getResult(arr));
    }

    private static int getResult(int[] arr) {
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            first ^= arr[i];
        }
        // 异或之后数量不为0说明不可以满足A的要求
        if(first != 0){
            return -1;
        }
        // 否则满足要求，返回数量中最少的给A，总重量扣除给A的，剩余是B的
        return Arrays.stream(arr).sum() - Arrays.stream(arr).min().getAsInt();
    }
}
