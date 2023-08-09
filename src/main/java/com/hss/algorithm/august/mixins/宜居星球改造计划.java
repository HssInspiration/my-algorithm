package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/7/31 22:33
 * @Version 1.0.0
 */
public class 宜居星球改造计划 {
    //行
    public static int row;
    //列
    public static int col;
    //待改造区网格
    public static String[][] regionsCopy;
    //待改造的区域坐标
    public static List<int[]> coordinates = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            //这里用于输出，实际机试中不需要
            if (input.equals("1")) {
                break;
            }
            list.add(input);
        }
        row = list.size();
        col = list.get(0).split(" ").length;
        //待改造区域网格
        String[][] regions = new String[row][col];
        regionsCopy = new String[row][col];
        //no区域的总数
        int noTotal = 0;
        for (int i = 0; i < row; i++) {
            String[] strings = list.get(i).split(" ");
            for (int j = 0; j < col; j++) {
                regions[i][j] = strings[j];
                regionsCopy[i][j] = strings[j];
                if (strings[j].equals("NO")) {
                    noTotal++;
                }
            }
        }
        //是否需要改造
        boolean isFlag = true;
        //天数
        int day = 0;
        while (noTotal != 0 && isFlag) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (regions[i][j].equals("YES")) {
                        gaizao(i, j);
                    }
                }
            }
            if (coordinates.size() != 0) {
                //有需要改造的区域
                for (int[] ints : coordinates) {
                    //根据坐标进行改造
                    regions[ints[0]][ints[1]] = "YES";
                }
                //已改造区域剔除
                noTotal -= coordinates.size();
                coordinates.clear();
                //天数加1
                day++;
            } else {
                //没有需要改造的区域
                isFlag = false;
            }
        }
        if (noTotal == 0) {
            //都改造完了
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    /**
     * 进行改造区域
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public static void gaizao(int x, int y) {
        //上
        if (x > 0 && regionsCopy[x - 1][y].equals("NO")) {
            regionsCopy[x - 1][y] = "YES";
            coordinates.add(new int[]{x - 1, y});
        }
        //下
        if (x < row - 1 && regionsCopy[x + 1][y].equals("NO")) {
            regionsCopy[x + 1][y] = "YES";
            coordinates.add(new int[]{x + 1, y});
        }
        //左
        if (y > 0 && regionsCopy[x][y - 1].equals("NO")) {
            regionsCopy[x][y - 1] = "YES";
            coordinates.add(new int[]{x, y - 1});
        }
        //右
        if (y < col - 1 && regionsCopy[x][y + 1].equals("NO")) {
            regionsCopy[x][y + 1] = "YES";
            coordinates.add(new int[]{x, y + 1});
        }
    }
}
