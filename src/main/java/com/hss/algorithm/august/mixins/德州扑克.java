package com.hss.algorithm.august.mixins;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/8/1 21:47
 * @Version 1.0.0
 */
public class 德州扑克 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        // 数字，数字个数键值对
        Map<Integer, Integer> map = new HashMap<>();
        int[] color = getInts(sc, numList, map);
        //只要其中一个花色有5张为同花
        int res = getRes(numList, map, color[0] == 5 || color[1] == 5 || color[2] == 5 || color[3] == 5);
        System.out.println(res);
    }

    private static int[] getInts(Scanner sc, List<Integer> numList, Map<Integer, Integer> map) {
        int[] color = new int[4];   //H、S、C、D 红黑梅方
        for (int i = 0; i < 5; i++) {
            String[] input = sc.nextLine().split(" ");
            String firstInput = input[0];
            int num;
            switch (firstInput) {
                case "A":
                    num = 1;
                    break;
                case "J":
                    num = 11;
                    break;
                case "Q":
                    num = 12;
                    break;
                case "K":
                    num = 13;
                    break;
                default:
                    num = Integer.parseInt(input[0]);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            numList.add(num);
            String hs = input[1];
            switch (hs) {
                case "H":
                    color[0]++;
                    break;
                case "S":
                    color[1]++;
                    break;
                case "C":
                    color[2]++;
                    break;
                default:
                    color[3]++;
                    break;
            }
        }
        return color;
    }

    private static int getRes(List<Integer> numList, Map<Integer, Integer> map, boolean isTongHua) {
        int res = 7;
        if (map.size() == 5) {
            Collections.sort(numList);  //排序方便判断顺子
            boolean isShunZi = isShunzi(numList);
            if (isShunZi) {
                res = isTongHua ? 1 : 5;
            } else {
                res = isTongHua ? 4 : 7;
            }
        } else {
            for (Map.Entry<Integer, Integer> m : map.entrySet()
            ) {
                if (m.getValue() == 4) {  //有四条一样的
                    res = 2;
                    break;
                } else if (m.getValue() == 3) {    //有三条一样的
                    res = map.size() == 2 ? 3 : 6;    //如果只有牌面只有两个数字则是三带二，否则三带两单
                    break;
                }
            }
        }
        return res;
    }

    public static Boolean isShunzi(List<Integer> list) {
        boolean b = true;
        int index = 1;
        boolean isA = false;
        //如果第一张为A，且第二张不为2
        if (list.get(0) == 1 && list.get(1) != 2) {
            index = 2;
            isA = true;
        }
        for (int i = index; i < 5; i++) {
            if (list.get(i) != list.get(i - 1) + 1) {
                b = false;
                break;
            }
            if (i == 4 && isA && list.get(4) != 13) {
                b = false;
            }
        }
        return b;
    }
}
