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
        Map<Integer, Integer> cardMap = new HashMap<>();
        List<Integer> cardList = new ArrayList<>();
        // 初始化数据
        int[] colors = initCardColorList(sc, cardMap, cardList);
        // 获取具体结果
        int res = getResult(cardMap, cardList, Arrays.stream(colors).anyMatch(c -> c == 5));
        System.out.println(res);

        /*List<Integer> numList = new ArrayList<>();
        // k:牌面数字, v:数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化数据
        int[] cardColorList = initCardColors(sc, numList, map);
        //只要其中一个花色有5张为同花
        System.out.println(getRes(numList, map, Arrays.stream(cardColorList).anyMatch(c -> c == 5)));*/
    }

    private static int getResult(Map<Integer, Integer> cardMap, List<Integer> cardList, boolean sameColor) {
        // 同花顺、同花（非顺）、顺子、杂牌
        if (cardMap.size() == 5) {
            // 顺子
            if (checkCardSort(cardList)) {
                return sameColor ? 1 : 5;
            }
            return sameColor ? 4 : 7;
        }

        int res = 7;
        for (Map.Entry<Integer, Integer> entrySet : cardMap.entrySet()) {
            // 四条
            if (entrySet.getValue() == 4) {
                res = 2;
                break;
            }
            // 三条
            if (entrySet.getValue() == 3) {
                // size=2-葫芦，否则三带两单
                res = cardMap.size() == 2 ? 3 : 6;
                break;
            }
        }
        return res;
    }

    private static boolean checkCardSort(List<Integer> cardList) {
        // 自然排序
        Collections.sort(cardList);
        // 包含A
        if (cardList.get(0) == 1) {
            // 第二位不构成顺子条件
            if (cardList.get(1) != 2 && cardList.get(1) != 10) {
                return false;
            }
        }
        boolean res = true;
        for (int i = 1; i < cardList.size(); i++) {
            // 第二位构成顺子条件，则调到下次循环，10 J Q K A -> 1 10 11 12 13
            if (cardList.get(0) == 1 && cardList.get(1) == 10) {
                continue;
            }
            int current = cardList.get(i);
            if (current != cardList.get(i - 1) + 1) {
                res = false;
                break;
            }
        }
        return res;
    }

    private static int[] initCardColorList(Scanner sc, Map<Integer, Integer> cardMap, List<Integer> cardList) {
        // 花色
        int[] colors = new int[4];
        // 获取输入并按空格分割
        for (int i = 0; i < 5; i++) {
            // 第一位是牌面数字，第二位是花色
            String[] strArr = sc.nextLine().split(" ");
            int num = 0;
            switch (strArr[0]) {
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
                    num = Integer.parseInt(strArr[0]);
                    break;
            }
            // 将牌面数字添加到集合中
            cardList.add(num);
            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);

            String color = strArr[1];
            switch (color) {
                case "H":
                    colors[0]++;
                    break;
                case "S":
                    colors[1]++;
                    break;
                case "C":
                    colors[2]++;
                    break;
                case "D":
                    colors[3]++;
                    break;
            }
        }
        return colors;
    }

    private static int[] initCardColors(Scanner sc, List<Integer> numList, Map<Integer, Integer> map) {
        // 四花色
        int[] cardColorList = new int[4];
        for (int i = 0; i < 5; i++) {
            // 每行的输入: 1 H
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
            numList.add(num);
            // 保存牌面数字已经出现的次数
            map.put(num, map.getOrDefault(num, 0) + 1);
            String color = input[1];
            switch (color) {
                case "H":
                    cardColorList[0]++;
                    break;
                case "S":
                    cardColorList[1]++;
                    break;
                case "C":
                    cardColorList[2]++;
                    break;
                default:
                    cardColorList[3]++;
                    break;
            }
        }
        return cardColorList;
    }

    private static int getRes(List<Integer> numList, Map<Integer, Integer> map, boolean sameColor) {
        // 5张的只有同花顺、顺子、同花（每张都不一样）、其他杂牌
        if (map.size() == 5) {
            // 自然排序
            Collections.sort(numList);
            // 顺子
            if (checkSort(numList)) {
                // 同花顺 || 普通顺子
                return sameColor ? 1 : 5;
            }
            // 同花 || 杂牌
            return sameColor ? 4 : 7;
        }
        int res = 7;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            // 四条
            if (m.getValue() == 4) {
                res = 2;
                break;
            }

            // 三条
            if (m.getValue() == 3) {
                // 判断是葫芦还是普通三条
                res = map.size() == 2 ? 3 : 6;
                break;
            }
        }
        return res;
    }

    public static Boolean checkSort(List<Integer> list) {
        boolean forward = true;
        // 特殊场景先排除，首张为A
        if (list.get(0) == 1) {
            //第二张不为2，和10，不能组成顺子返回false
            // 12345||10JQKA->1 10 11 12 13
            if ((list.get(1) != 2 && list.get(1) != 10)) {
                return false;
            }
        }
        for (int i = 1; i < 5; i++) {
            // 第二张为10 继续下次循环
            if (i == 1 && list.get(i) == 10) {
                continue;
            }
            // 后一张牌不等于前一张牌+1返回false
            if (list.get(i) != list.get(i - 1) + 1) {
                forward = false;
                break;
            }
        }
        return forward;
    }
}
