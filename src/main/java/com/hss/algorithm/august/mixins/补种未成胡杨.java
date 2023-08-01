package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:34
 * @Version 1.0.0
 */
public class 补种未成胡杨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //总共棵树
        int m = sc.nextInt();   //未成活的棵树
        List<Integer> dead = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            //未成活的数
            dead.add(sc.nextInt());
        }
        //补种的棵树
        int k = sc.nextInt();
        int max = 0;
        //i为补种的最后一棵胡杨下标
        for (int i = k - 1; i < m; i++) {
            if (i == k - 1) {
                //种最前面的k棵树
                max = Math.max(max, k == m ? n : dead.get(k) - 1);
            } else if (i == m - 1) {
                //种最后面的k棵树
                max = Math.max(max, n - dead.get(i - k));
            } else {
                //种中间的k棵树
                max = Math.max(max, dead.get(i + 1) - dead.get(i - k) - 1);
            }
        }
        System.out.println(max);
    }
}
