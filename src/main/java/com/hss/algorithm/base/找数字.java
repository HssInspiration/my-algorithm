package com.hss.algorithm.base;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/2/6 22:05
 * @Version 1.0.0
 */
public class 找数字 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] nums = new int[n][m];

        /**
         * 将数字和坐标转化为map
         * key：nums数组中的各值
         * value：nums数组中的坐标的集合
         */
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int input = sc.nextInt();
                nums[i][j] = input;
                int[] ints1 = new int[]{i, j};   //将坐标转化为数组
                List<int[]> tempList;
                if (map.containsKey(input)) {
                    tempList = map.get(input);
                } else {
                    tempList = new ArrayList<>();
                }
                tempList.add(ints1);
                map.put(input, tempList);
            }
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int num = nums[i][j];
                List<int[]> listInts = map.get(num);
                if (listInts.size() == 1) {   //只有一个坐标，则不存在相等的值
                    list.add(-1);
                    continue;
                }

                int min = Integer.MAX_VALUE;    //最小距离
                for (int k = 0; k < listInts.size(); k++) {
                    int[] intnum = listInts.get(k);
                    int distance = Math.abs(intnum[0] - i) + Math.abs(intnum[1] - j);   //求出距离
                    if (distance == 0) {  //距离为0则跳过
                        continue;
                    }
                    min = Math.min(min, distance);
                }

                list.add(min);
            }
            resList.add(list);
        }

        System.out.println(resList);

    }
}
