package com.hss.algorithm.base;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author hss
 * @Date 2023/2/6 22:04
 * @Version 1.0.0
 */
public class 任务总执行时长 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        int aTime = Integer.valueOf(strings[0]);
        int bTime = Integer.valueOf(strings[1]);
        int num = Integer.valueOf(strings[2]);
        Set<Integer> total = new TreeSet<>();
        int res;
        for (int i = 0; i <= num; i++) {
            res = aTime * (num - i) + i * bTime;
            total.add(res);
        }
        System.out.println(total);
    }
}
