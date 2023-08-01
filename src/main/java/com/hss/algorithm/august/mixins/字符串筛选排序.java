package com.hss.algorithm.august.mixins;

import java.util.Arrays;

/**
 * @Author hss
 * @Date 2023/8/1 22:47
 * @Version 1.0.0
 */
public class 字符串筛选排序 {
    // TODO
    public static void main(String[] args) {
        String input = "AbCdeFG";
        int position = 3; // 排序后子串中的第n个
        char[] chArr = input.toCharArray();
        char obj = ' ';
        char[] newArr = chArr.clone();
        Arrays.sort(chArr);
        if (position > chArr.length) {
            obj = chArr[chArr.length - 1];// 取ASCC最大的字符
        } else {
            obj = chArr[position - 1];
        }
        for (int i = 0; i < newArr.length; i++) {
            if (obj == newArr[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
