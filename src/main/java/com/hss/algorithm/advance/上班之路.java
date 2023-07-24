package com.hss.algorithm.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:19
 * @Version 1.0.0
 */
public class 上班之路 {

    public static char[][] map;     //地图
    //public static int t;    //转弯次数
    //public static int c;    //路障个数
    //public static int n;    //地图行数
    //public static int m;    //地图列数

    private static char[][] runMap;
    /**
     * 地图行数
     */
    private static int n;

    /**
     * 地图列数
     */
    private static int m;
    /**
     * 转弯次数
     */
    private static int t;
    /**
     * 清除路障次数
     */
    private static int c;

    public static void mainss(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        map = new char[n][m];
        // 复制一个数组
        char[][] mapCopy = new char[n][m];
        int x = 0;
        int y = 0;
        // 初始化二维数组
        // 遍历行
        for (int i = 0; i < n; i++) {
            // 每一行的数据
            String string = sc.nextLine();
            // 遍历列
            for (int j = 0; j < m; j++) {
                // 填充数组元素
                map[i][j] = string.charAt(j);
                // 往复制的数组里添加指定元素
                mapCopy[i][j] = map[i][j];
                // 如果是家将i与j的值赋给x和y
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        if (toCompany(mapCopy, x, y, new ArrayList<>(), 0, 0) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    /**
     * @param newMap    地图，用来记录走过的行程
     * @param x         横坐标
     * @param y         纵坐标
     * @param list      走过的坐标集合
     * @param turn      转弯的次数
     * @param barricade 路过路障的次数
     * @return
     */
    public static int toCompany(char[][] newMap, int x, int y, List<int[]> list, int turn, int barricade) {
        if (list.size() > 1) {    //至少走过两个格子才能判断是否转弯
            int[] ints = list.get(list.size() - 2);   //获取路过的倒数第二个格子
            if (ints[0] != x && ints[1] != y) {   //如果横纵坐标没有相同的，则表示转过弯
                turn++;
            }
        }

        list.add(new int[]{x, y});      //走过的格子

        if (turn > t) {       //转弯次数大于t，则不符合，返回
            return 0;
        }

        if (newMap[x][y] == '*') {    //记录路障的个数
            barricade++;
        }

        if (barricade > c) {      //路障的个数大于c，则不符合，返回
            return 0;
        }

        if (newMap[x][y] == 'T') {    //到达公司完成路程
            return 1;
        }

        newMap[x][y] = 'X';     //走过的地方记录为X

        if (x > 0) {    //向上
            if (newMap[x - 1][y] != 'X') {      //走过的格子不再走
                if (toCompany(newMap, x - 1, y, list, turn, barricade) == 1) {
                    return 1;
                } else {
                    newMap[x - 1][y] = map[x - 1][y];   //不符合要求的路程需要恢复
                    list.remove(list.size() - 1);     //走过的格子需要剔除
                }
            }
        }

        if (x < n - 1) {      //向下
            if (newMap[x + 1][y] != 'X') {      //走过的格子不再走
                if (toCompany(newMap, x + 1, y, list, turn, barricade) == 1) {
                    return 1;
                } else {
                    newMap[x + 1][y] = map[x + 1][y];   //不符合要求的路程需要恢复
                    list.remove(list.size() - 1);     //走过的格子需要剔除
                }
            }
        }

        if (y > 0) {        //向左
            if (newMap[x][y - 1] != 'X') {      //走过的格子不再走
                if (toCompany(newMap, x, y - 1, list, turn, barricade) == 1) {
                    return 1;
                } else {
                    newMap[x][y - 1] = map[x][y - 1];   //不符合要求的路程需要恢复
                    list.remove(list.size() - 1);     //走过的格子需要剔除
                }
            }
        }

        if (y < m - 1) {      //向右
            if (newMap[x][y + 1] != 'X') {      //走过的格子不再走
                if (toCompany(newMap, x, y + 1, list, turn, barricade) == 1) {
                    return 1;
                } else {
                    newMap[x][y + 1] = map[x][y + 1];   //不符合要求的路程需要恢复
                    list.remove(list.size() - 1);     //走过的格子需要剔除
                }
            }
        }

        return 0;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        runMap = new char[n][m];
        char[][] newMap = new char[n][m];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                runMap[i][j] = c;
                newMap[i][j] = runMap[i][j];
                if (runMap[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        if (toCompanySuccess(newMap, x, y, new ArrayList<>(), 0, 0) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int toCompanySuccess(char[][] newMap, int x, int y, List<int[]> list, int turn, int barrier) {
        if (list.size() > 1) {// 至少走过两个格子
            int[] arrays = list.get(list.size() - 2);// 获取倒数第二个格子
            if (arrays[0] != x && arrays[1] != y) { //如果横纵坐标没有相同的，则表示转过弯
                turn++;
            }
        }
        list.add(new int[]{x, y});
        if (turn > t) {// 超过转弯次数
            return 0;
        }
        if (newMap[x][y] == '*') {
            barrier++;
        }
        if (barrier > c) {// 超过清除障碍的次数
            return 0;
        }
        if (newMap[x][y] == 'T') {
            return 1;
        }
        newMap[x][y] = 'X';// 走过的地方记录起来
        // 向上
        if (x > 0) {
            if (newMap[x - 1][y] != 'X') {// 走过的格子不再走
                if (toCompanySuccess(newMap, x - 1, y, list, turn, barrier) == 1) {
                    return 1;
                } else {
                    // 不符合要求的路程要恢复
                    newMap[x - 1][y] = runMap[x][y];
                    // 走过的格子要移除
                    list.remove(list.size() - 1);
                }
            }
        }
        // 向下
        if (x < n - 1) {
            if (newMap[x + 1][y] != 'X') {// 走过的格子不再走
                if (toCompanySuccess(newMap, x + 1, y, list, turn, barrier) == 1) {
                    return 1;
                } else {
                    // 不符合要求的路程要恢复
                    newMap[x + 1][y] = runMap[x][y];
                    // 走过的格子要移除
                    list.remove(list.size() - 1);
                }
            }
        }
        // 向左
        if (y > 0) {
            if (newMap[x][y - 1] != 'X') {// 走过的格子不再走
                if (toCompanySuccess(newMap, x, y - 1, list, turn, barrier) == 1) {
                    return 1;
                } else {
                    // 不符合要求的路程要恢复
                    newMap[x][y] = runMap[x][y - 1];
                    // 走过的格子要移除
                    list.remove(list.size() - 1);
                }
            }
        }

        // 向右
        if (y < m - 1) {
            if (newMap[x][y + 1] != 'X') {// 走过的格子不再走
                if (toCompanySuccess(newMap, x, y + 1, list, turn, barrier) == 1) {
                    return 1;
                } else {
                    // 不符合要求的路程要恢复
                    newMap[x][y] = runMap[x][y + 1];
                    // 走过的格子要移除
                    list.remove(list.size() - 1);
                }
            }
        }
        return 0;
    }
}
