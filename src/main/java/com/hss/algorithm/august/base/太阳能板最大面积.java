package com.hss.algorithm.august.base;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/7/17 9:18
 * @Version 1.0.0
 */
public class 太阳能板最大面积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String[] arrStr = nextLine.split(",");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            int min = arr[i];
            int temp = i - 1;
            for (int j = 1; j <= i; j++) {
                min = Math.min(min, arr[temp--]);
                max = Math.max(i * min, max);
            }
        }
        System.out.println(max);
    }
}
