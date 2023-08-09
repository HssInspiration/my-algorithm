package com.hss.algorithm.august.mixins;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/7/17 9:48
 * @Version 1.0.0
 */
public class 组成最大数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String val = sc.nextLine();
        String[] strArr = val.split(",");
        int len = strArr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int first = Integer.parseInt(strArr[i] + strArr[j]);
                int second = Integer.parseInt(strArr[j] + strArr[i]);
                if (first < second) {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;   
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (String s : strArr) {
            res.append(s);
        }
        System.out.println(Long.parseLong(res.toString()));
    }
}
