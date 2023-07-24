package com.hss.algorithm.advance;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Author hss
 * @Date 2023/2/6 22:06
 * @Version 1.0.0
 */
public class 不含101的数 {
    public static void mains(String[] args) {
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

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        int secNum = sc.nextInt();
        int res = secNum - firstNum + 1;
        for (int i = firstNum; i <= secNum; i++) {
            String s = getBinary(i);
            if (s.contains("101")) {
                res--;
            }
        }
        System.out.println(res);
    }

    /**
     * 自定义二进制转换方法实现
     *
     * @param num 整数
     * @return 二进制数
     */
    private static String getBinary(int num) {
        StringBuilder binary = new StringBuilder();
        while (num != 0) {
            binary.append(num % 2);
            num = num / 2;
        }
        return binary.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        // 返回值
        int res = r - l + 1;
        for (int i = l; i <= r; i++) {
            String binary = getBinaryStr(i);
            if (binary.contains("101")) {
                res--;
            }
        }
        System.out.println(res);
    }

    private static String getBinaryStr(int i) {
        StringBuilder binary = new StringBuilder();
        while (i != 0) {
            binary.append(i % 2);
            i = i / 2;
        }
        return binary.reverse().toString();
    }

}
