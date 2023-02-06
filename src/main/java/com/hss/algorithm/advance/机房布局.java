package com.hss.algorithm.advance;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:17
 * @Version 1.0.0
 */
public class 机房布局 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int res = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == 'M') {
                if (i + 1 < string.length() && string.charAt(i + 1) == 'I') {
                    res++;
                    i += 2;
                } else if (i - 1 >= 0 && string.charAt(i - 1) == 'I') {
                    res++;
                } else {
                    res = -1;   //前后都没有空间则为-1，且退出循环
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
