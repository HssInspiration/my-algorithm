package com.hss.algorithm.august.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/7/17 9:25
 * @Version 1.0.0
 */
public class 分糖果 {
    public static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        splitCandy(val, 0);
        Object[] objects = numList.toArray();
        Arrays.sort(objects);
        System.out.println(objects[0].toString());
    }

    private static void splitCandy(int val, int num) {
        if (val == 1) {
            numList.add(num);
            return;
        }
        num++;
        if (val % 2 == 0) {
            splitCandy(val / 2, num);
        } else {
            splitCandy(val - 1, num);
            splitCandy(val + 1, num);
        }
    }
}
