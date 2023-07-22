package com.hss.algorithm.third.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 参考链接：<a href="https://blog.csdn.net/qq_34465338/article/details/130722491"><a/>
 */
public class 分苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] apples = new int[num];
        for (int i = 0; i < num; i++) {
            apples[i] = sc.nextInt();
        }
        System.out.println(getRes(num, apples));
    }

    private static int getRes(int num, int[] apples) {
        int count = apples[0];
        for (int i = 1; i < num; i++) {
            count ^= apples[i];
        }
        int res = -1;
        if (count == 0) {
            int min = Arrays.stream(apples).min().getAsInt();
            int sum = Arrays.stream(apples).sum();
            res = sum - min;
        }
        return res;
    }
}
