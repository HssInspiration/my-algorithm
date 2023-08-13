package com.hss.algorithm.august.mixins;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 观看文艺汇演问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 演出场数
        int times = in.nextInt();
        in.nextLine();
        // 初始化观看时长数组i-每场开始时间，j-每场结束时间
        int[][] timeArr = new int[times][2];
        for (int i = 0; i < times; i++) {
            timeArr[i][0] = in.nextInt();
            timeArr[i][1] = in.nextInt() + timeArr[i][0];
        }
        // 计算总共可以观看多少场次
        int totalTimes = getTotalTimes(times, timeArr);
        System.out.println(totalTimes);
    }
    private static int getTotalTimes(int times, int[][] timeArr) {
        int totalTimes = 0;
        // 排除例外场景-数组输入为空
        if (timeArr.length < 1 || timeArr[0].length < 1) {
            return totalTimes;
        } else {
            totalTimes = 1;
        }
        // 先排序，兼容倒序场次排列的场景
        Arrays.sort(timeArr, Comparator.comparingInt(time -> time[1]));
        // 首场结束时间
        int endTime = timeArr[0][1];
        for (int i = 1; i < times; i++) {
            // 前一场结束时间+15分钟后小于等于下一场开始时间，符合条件
            if (endTime + 15 <= timeArr[i][0]) {
                // 结束时间更新为下场结束时间
                endTime = timeArr[i][1];
                // 总次数+1
                totalTimes++;
            }
        }
        return totalTimes;
    }
}
