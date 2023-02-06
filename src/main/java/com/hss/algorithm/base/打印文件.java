package com.hss.algorithm.base;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/2/6 21:47
 * @Version 1.0.0
 */
public class 打印文件 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        /**
         * 将打印任务放在map对象中
         * key： String 打印机编号
         * value： List<int[]>数组集合
         *              int[0]： 优先级
         *              int[1]: 打印编号
         */
        Map<String, List<int[]>> map = new HashMap<>();
        int count = 0;  //打印编号
        for (int i = 0; i < n; i++) {
            String[] strs = sc.nextLine().split(" ");
            if (strs[0].equals("IN")) {   //打印任务
                int[] inInts = new int[2];
                inInts[0] = Integer.parseInt(strs[2]);  //优先级
                inInts[1] = ++count;   //打印编号递增
                List<int[]> inList = new ArrayList<>();
                if (map.containsKey(strs[1])) {
                    inList = map.get(strs[1]);
                    inList.add(inInts);
                } else {
                    inList.add(inInts);
                }
                map.put(strs[1], inList);
            } else if (strs[0].equals("OUT")) {    //进行打印
                if (!map.containsKey(strs[1])) {  //打印机不存在
                    System.out.println("NULL");
                    continue;
                }
                List<int[]> outList = map.get(strs[1]);     //获取strs[1]打印机的所有任务
                if (outList.size() == 0) {    //打印机没有任务
                    System.out.println("NULL");
                } else {
                    outList.sort((a, b) -> {     //根据打印优先级排序
                        return b[0] - a[0];
                    });
                    System.out.println(outList.get(0)[1]);
                    outList.remove(0);
                }
            }
        }
    }
}
