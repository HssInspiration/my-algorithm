package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:41
 * @Version 1.0.0
 */
public class 欢乐的周末 {
    public static int endX;     //餐厅横坐标
    public static int endY;     //餐厅纵坐标

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lenX = sc.nextInt();
        int lenY = sc.nextInt();

        int[][] migong = new int[lenX][lenY];      //迷宫数组
        List<int[]> hw = new ArrayList<>();    //小华和小为的坐标
        List<int[]> canGuan = new ArrayList<>();        //餐厅的坐标

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                migong[i][j] = sc.nextInt();
                if (migong[i][j] == 2) {
                    int[] h = {i, j};
                    hw.add(h);
                } else if (migong[i][j] == 3) {
                    int[] c = {i, j};
                    canGuan.add(c);
                }
            }
        }

        int[] xh = hw.get(0);       //小华的位置坐标
        int[] xw = hw.get(1);       //小为的位置坐标
        int res = 0;
        for (int i = 0; i < canGuan.size(); i++) {
            int temp[][] = copy(migong);        //复制原数组（否则会导致数组改变）
            endX = canGuan.get(i)[0];       //餐馆横坐标
            endY = canGuan.get(i)[1];       //餐馆纵坐标
            if (forEnd(xh[0], xh[1], temp) == 1) {
                temp = copy(migong);
                if (forEnd(xw[0], xw[1], temp) == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    public static int[][] copy(int[][] nums) {
        int x = nums.length;
        int y = nums[0].length;
        int[][] res = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                res[i][j] = nums[i][j];
            }
        }
        return res;
    }

    public static int forEnd(int x, int y, int[][] ints) {

        int U = x - 1;     //向上
        int D = x + 1;     //向下
        int L = y - 1;     //向左
        int R = y + 1;      //向右

        if (x == endX && y == endY) {     //到达餐馆返回1
            return 1;
        }

        if (U >= 0) {     //边界处理
            if (ints[U][y] != 1) {      //只要非1都能通过
                ints[x][y] = 1;     //能通过则本格置为1，表示已经走过
                if (forEnd(U, y, ints) == 1) {      //递归处理，若值为1表示可以到达直接return 1
                    return 1;
                }
            }
        }

        if (D < ints.length) {
            if (ints[D][y] != 1) {
                ints[x][y] = 1;
                if (forEnd(D, y, ints) == 1) {
                    return 1;
                }
            }
        }

        if (L >= 0) {
            if (ints[x][L] != 1) {
                ints[x][y] = 1;
                if (forEnd(x, L, ints) == 1) {
                    return 1;
                }
            }
        }

        if (R < ints[0].length) {
            if (ints[x][R] != 1) {
                ints[x][y] = 1;
                if (forEnd(x, R, ints) == 1) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
