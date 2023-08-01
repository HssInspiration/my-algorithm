package com.hss.algorithm.august.mixins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:27
 * @Version 1.0.0 s = (a1 + an)*n/2-------->  a1 = (2s/n +1 -n )/2  ,则 2s/n - n 必须为奇数
 */
public class 求连续数列 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        // 1、输入正整数的和S和数列里数的个数N
        int s = sc.nextInt();
        int n = sc.nextInt();
        int a1 = 1;
        List<Integer> list = new ArrayList<>();
        if (2 * s % n != 0) {
            System.out.println(-1);
            return;
        } else if ((2 * s / n - n) % 2 == 0) {
            System.out.println(-1);
            return;
        } else {
            a1 = (2 * s / n + 1 - n) / 2;
        }
        for (int i = 0; i < n; i++) {
            list.add(a1 + i);
        }
        System.out.println(list);
    }

}
