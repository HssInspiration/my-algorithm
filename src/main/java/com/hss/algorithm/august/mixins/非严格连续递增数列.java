package com.hss.algorithm.august.mixins;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:42
 * @Version 1.0.0
 */
public class 非严格连续递增数列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int max = 0;
        int count = 0;
        if (Character.isDigit(s.charAt(0))) { //如果第一个字符为数字则将count置1
            count = 1;
        }
        for (int i = 1; i < n; i++) {
            //判断字符是否为数字
            if (Character.isDigit(s.charAt(i))) {
                if (count != 0) {
                    //count不为0则可以进行比较，反则置为1，下次进行比较
                    if ((s.charAt(i) >= s.charAt(i - 1))) {
                        //符合条件
                        count++;
                    } else {
                        //不符合条件则抛出最大
                        max = Math.max(max, count);
                        //因为本次是数字，所以置1
                        count = 1;
                    }
                } else {
                    count = 1;
                }
            } else if (count != 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        System.out.println(Math.max(max, count));
    }
}
