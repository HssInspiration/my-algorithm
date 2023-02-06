package com.hss.algorithm.base;

import java.util.Scanner;

/**
 * https://blog.csdn.net/qq_34465338/article/details/128332074
 *
 * @Author hss
 * @Date 2023/2/6 20:56
 * @Version 1.0.0
 */
public class 查找重复代码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();
        String minStr = text1.length() <= text2.length() ? text1 : text2;
        String maxStr = minStr.equals(text1) ? text2 : text1;
        String resStr = "";
        for (int i = 0; i < minStr.length() - 1; i++) {
            for (int j = i + 2; j <= minStr.length(); j++) {
                String temp = minStr.substring(i, j);
                if (maxStr.contains(temp) && temp.length() > resStr.length()) {
                    resStr = temp;
                }
            }
        }
        System.out.println(resStr);
    }
}
