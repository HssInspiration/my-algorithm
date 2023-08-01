package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 21:55
 * @Version 1.0.0
 */
public class 字符串中所有整数最小和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = getList(sc.nextLine());
        System.out.println(list.stream().mapToInt(e -> e).sum());
    }

    private static List<Integer> getList(String input) {
        int len = input.length();
        boolean minusFlag = false;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char val = input.charAt(i);
            if (Character.isDigit(val)) {
                if (minusFlag) {
                    //有负号的情况下数字越大越好，直接拼接
                    sb.append(val);
                } else {
                    //没有负号直接加入集合
                    list.add(Character.getNumericValue(val));
                }
            } else if (val == '-') {
                //temp中有值且不是一个“-”单字符串的情况下
                if (checkSpecialStr(sb)) {
                    list.add(Integer.parseInt(String.valueOf(sb)));
                }
                //说明下一个字符串有了负号
                sb = new StringBuilder("-");
                minusFlag = true;
            } else {
                // 字母和“+”的情况
                if (checkSpecialStr(sb)) {
                    list.add(Integer.parseInt(String.valueOf(sb)));
                }
                // 无论之前是什么，都需要置空
                sb = new StringBuilder();
                minusFlag = false;
            }
        }
        return list;
    }

    private static boolean checkSpecialStr(StringBuilder sb) {
        return !sb.toString().equals("") && !sb.toString().equals("-");
    }
}
