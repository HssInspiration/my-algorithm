package com.hss.algorithm.august.base;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:33
 * @Version 1.0.0
 */
public class 矩阵最大值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine().replace(",", "");   //直接将输入值转换为字符串
            int max = 0;
            for (int j = 0; j < n; j++) {
                String newS = s.substring(j) + s.substring(0, j); //字符串分段拼接相当于右移
                max = Math.max(max, Integer.valueOf(newS, 2));
            }
            res += max;
        }
        System.out.println(res);
    }
}
