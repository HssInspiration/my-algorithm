package com.hss.algorithm.august.mixins;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:49
 * @Version 1.0.0
 */
public class 寻找身高相近的小朋友 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = sc.nextInt();
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                int a = Math.abs(ints[j] - H);
                int b = Math.abs(ints[j + 1] - H);
                if (a > b || (a == b && ints[j] > ints[j + 1])) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            res.append(ints[i]);
            if (i != N - 1) {
                res.append(" ");
            }
        }
        System.out.println(res);
    }
}
