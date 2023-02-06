package com.hss.algorithm.advance;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:06
 * @Version 1.0.0
 */
public class 不含101的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int res = r - l + 1;
        for (int i = l; i <= r; i++) {
            String binary = Integer.toBinaryString(i);
            if (binary.contains("101")) {
                res--;
            }
        }
        System.out.println(res);
    }
}
