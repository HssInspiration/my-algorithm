package com.hss.algorithm.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:13
 * @Version 1.0.0
 */
public class 最差产品奖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        String[] strs = sc.nextLine().split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= strs.length - M; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < i + M; j++) {
                min = Math.min(min, Integer.parseInt(strs[j]));
            }
            list.add(min);
        }
        System.out.println(list);
    }
}
