package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:36
 * @Version 1.0.0
 */
public class 计算面积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        int[] ints = new int[2];
        for (int i = 0; i < n; i++) {
            ints[0] = sc.nextInt();
            ints[1] = sc.nextInt();
            list.add(ints);
            ints = new int[2];
        }
        int res = 0;
        int high = 0;
        for (int i = 1; i < list.size(); i++) {
            // Y轴方向的运动轨迹(相当于高)
            high += list.get(i - 1)[1];
            res += Math.abs((list.get(i)[0] - list.get(i - 1)[0]) * high);
        }
        res += Math.abs((e - list.get(n - 1)[0]) * (high + list.get(n - 1)[1]));
        System.out.println(res);
    }
}
