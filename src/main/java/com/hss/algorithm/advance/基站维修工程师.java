package com.hss.algorithm.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:11
 * @Version 1.0.0
 */
public class 基站维修工程师 {


    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] distance = new int[n][n];   //路程转化为二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < distance.length; i++) {
            List<Integer> stepList = new ArrayList<>();
            stepList.add(i);    //从基站2开始走
            handle(distance, i, stepList, distance[0][i]);
        }

        System.out.println(min);
    }

    /**
     * @param ints  各基站路程的二维数组
     * @param index 达到的基站
     * @param step  路过的基站
     * @param sum   走过的路程
     */
    public static void handle(int[][] ints, int index, List<Integer> step, int sum) {

        if (step.size() + 1 == ints.length) {     //走完所有的基站，准备返回基站1
            min = Math.min(min, sum + ints[index][0]);     //记得加上基站1的路程
        } else {
            for (int i = 1; i < ints.length; i++) {
                if (step.contains(i)) {   //已经走过的基站不需要再走
                    continue;
                }
                step.add(i);    //走过的基站
                handle(ints, i, step, sum + ints[index][i]);    //index到达的基站，i下次去的基站
                step.remove(step.size() - 1);     //刚走过的基站需要剔除以便进行下一个循环
            }
        }
    }
}
