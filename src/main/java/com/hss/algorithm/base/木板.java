package com.hss.algorithm.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/qq_34465338/article/details/128331597
 *
 * @Author hss
 * @Date 2023/2/6 20:41
 * @Version 1.0.0
 */
public class 木板 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++) {
            intArr[i] = sc.nextInt();
        }
        // 按自然顺序排列
        Arrays.sort(intArr);
        while (m > 0) {
            // 按段分割
            m--;
            for (int i = 1; i < intArr.length; i++) {
                // 前一段比后一段大则加1
                if (intArr[i] > intArr[i - 1]) {
                    intArr[i - 1]++;
                    break;
                }
                // 如果前面都是相等的则在最后一个木板上+1
                if (i == n - 1) {
                    intArr[i]++;
                }
            }
        }
        System.out.println(intArr[0]);
    }
}
