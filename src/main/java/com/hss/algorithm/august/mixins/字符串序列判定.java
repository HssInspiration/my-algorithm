package com.hss.algorithm.august.mixins;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:35
 * @Version 1.0.0
 */
public class 字符串序列判定 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String L = sc.nextLine();
        int n = 0;
        int m = 0;
        while (m < L.length() && n < S.length()) {
            if (S.charAt(n) == L.charAt(m)) {
                n++;
            }
            m++;
        }
        if (n == S.length()) {
            System.out.println(m - 1);
        } else {
            System.out.println(-1);
        }
    }
}
