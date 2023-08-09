package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/9 22:29
 * @Version 1.0.0
 */
public class 最长广播响应 {

    // 信号联通集合
    public static List<int[]> linkList = new ArrayList<>();
    // 广播的节点到各个节点之间的最小传播时延
    public static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            linkList.add(new int[]{a, b});
        }
        int start = sc.nextInt();
        // 所有节点传播的最小时延
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (start == i + 1) {
                // start节点直接跳过
                continue;
            }
            min = Integer.MAX_VALUE;
            // 已经传播的节点
            List<Integer> list = new ArrayList<>();
            list.add(start);
            time(start, i + 1, 0, list);
            max = Math.max(max, min);
        }
        System.out.println(max * 2);
    }

    /**
     * @param start 开始节点
     * @param end   目标节点
     * @param count 传播次数
     * @param lined 已经传播的节点
     */
    public static void time(int start, int end, int count, List<Integer> lined) {
        for (int[] ints : linkList) {
            int u = ints[0];
            int v = ints[1];
            if (u == start) {
                // 传播节点存在
                if (checkExist(end, count, lined, v))
                    break;
            } else if (v == start) {
                // 传播节点存在
                if (checkExist(end, count, lined, u))
                    break;
            }
        }
    }

    private static boolean checkExist(int end, int count, List<Integer> lined, int v) {
        if (v == end) {
            // 传播关系完成
            min = Math.min(min, count + 1);
            return true;
        } else if (!lined.contains(v)) {
            // 传播未到达目标节点，且 v 节点未被传播
            List<Integer> temp = new ArrayList<>(lined);
            temp.add(v);
            time(v, end, count + 1, temp);
        }
        return false;
    }
}
