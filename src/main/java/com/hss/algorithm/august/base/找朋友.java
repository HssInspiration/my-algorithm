package com.hss.algorithm.august.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:26
 * @Version 1.0.0
 */
public class 找朋友 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) { //最后一个直接跳过
            for (int j = i + 1; j < n; j++) {
                if (ints[j] > ints[i]) {
                    list.add(j);
                    break;
                }
                if (j == n - 1) {    //到最后一位都没有符合的
                    list.add(0);
                }
            }
        }
        list.add(0);    //最后一位小朋友
        System.out.println(list);
    }
}
