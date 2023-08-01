package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:44
 * @Version 1.0.0
 */
public class 字符串变换最小字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();

        List<Character> listBySort = new ArrayList<>();
        char[] chars = new char[len];   //原字符数组

        for (int i = 0; i < len; i++) {
            listBySort.add(s.charAt(i));
            chars[i] = s.charAt(i);
        }
        Collections.sort(listBySort);   //对字符进行排序

        char change = ' ';  //需要替换的字符
        int minIndex = 0;   //较小的字符下标
        int changeIndex = 0;    //需要替换的字符下标
        for (int i = 0; i < len; i++) {
            if (listBySort.get(i) < s.charAt(i)) {  //小字符串在后进行替换
                change = listBySort.get(i);
                changeIndex = i;
                break;
            }
        }

        if (change != ' ') {
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) == change) {
                    minIndex = i;
                    break;
                }
            }
            chars[minIndex] = chars[changeIndex];
            chars[changeIndex] = change;
        }
        System.out.println(String.valueOf(chars));
    }
}
