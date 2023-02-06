package com.hss.algorithm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 21:46
 * @Version 1.0.0
 */
public class 查找单入口空闲区域 {

    public static int m;
    public static int n;
    public static String[][] strings;
    public static int[] rukou = new int[2]; //入口坐标
    public static int count = 0;    //入口个数


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        strings = new String[m][n];
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String[] strInput = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                strings[i][j] = strInput[j];
            }
        }

        int max = 0;    //最大的区域大小
        List<int[]> quyu = new ArrayList<>();   //最大区域的入口坐标和其区域大小的集合
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (strings[i][j].equals("O")) {
                    strings[i][j] = "X";    //已经统计过的区域置为"X"
                    List<int[]> zuobiao = new ArrayList<>();    //区域中的坐标集合
                    zuobiao.add(new int[]{i, j});
                    qiuquyu(i, j, zuobiao);
                    if (count == 1) {  //只有一个入口的区域
                        if (max == zuobiao.size()) {  //有大小相同的单入口空闲区域，只需要大小，无需坐标
                            quyu.clear();
                        } else if (max < zuobiao.size()) {
                            quyu.clear();
                            quyu.add(new int[]{rukou[0], rukou[1], zuobiao.size()});
                            max = zuobiao.size();
                        }
                    }
                    count = 0;  //重置入口数量
                    rukou = new int[2];  //重置入口坐标
                }
            }
        }

        if (quyu.size() == 1) {
            int[] res = quyu.get(0);
            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        } else if (max != 0) {
            System.out.println(max);
        } else {
            System.out.println("NULL");
        }

    }

    /**
     * @param x    横坐标
     * @param y    纵坐标
     * @param list 区域内的坐标集合
     */
    public static void qiuquyu(int x, int y, List<int[]> list) {

        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {   //边界为入口坐标
            count++;  //入口的数量计数
            rukou[0] = x;
            rukou[1] = y;
        }

        if (x < m - 1) {
            if (strings[x + 1][y].equals("O")) {
                strings[x + 1][y] = "X";  //已经统计过的区域需要置为"X"，避免统计重复
                list.add(new int[]{x + 1, y});
                qiuquyu(x + 1, y, list);
            }
        }
        if (y < n - 1) {
            if (strings[x][y + 1].equals("O")) {
                strings[x][y + 1] = "X";  //已经统计过的区域需要置为"X"，避免统计重复
                list.add(new int[]{x, y + 1});
                qiuquyu(x, y + 1, list);
            }
        }
        if (y > 0) {
            if (strings[x][y - 1].equals("O")) {
                strings[x][y - 1] = "X";  //已经统计过的区域需要置为"X"，避免统计重复
                list.add(new int[]{x, y - 1});
                qiuquyu(x, y - 1, list);
            }
        }
    }

}
