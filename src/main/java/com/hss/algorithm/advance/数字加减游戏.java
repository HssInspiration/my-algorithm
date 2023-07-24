package com.hss.algorithm.advance;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:12
 * @Version 1.0.0
 */
public class 数字加减游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = 0;
        int add = s;
        int sub = s;
        while (true) {
            if ((t - add) % b == 0) {
                break;
            }
            if ((t - sub) % b == 0) {
                break;
            }
            add += a;
            sub -= a;
            res++;
        }
        System.out.println(res);
    }
}
