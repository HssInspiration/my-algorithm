package com.hss.algorithm.base;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/2/6 22:06
 * @Version 1.0.0
 */
public class 整理扑克牌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        /**
         * 使用map来放置牌
         * key：car的点数
         * value：同一点数的张数
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (String string : strings) {
            int i = Integer.valueOf(string);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        /**
         * map转化为list进行排序
         * 1、张数多的排在前面
         * 2、张数一样的，点数多的排在前面
         */
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (b.getValue() == a.getValue()) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        });

        StringBuffer sb = new StringBuffer();
        List<Integer> chaiFen = new ArrayList<>();  //需要拆分的点数（有可能是2个所以需要用到集合）
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> temp = list.get(i);
            int carNum = temp.getKey();
            int carCount = temp.getValue();
            /**
             * 当碰到前面是三张，此牌也是三张的时候，需要进行拆分了
             * （因为葫芦仅次于炸弹，所以要紧葫芦后面的对子凑最大）
             */
            if (i > 0 && list.get(i - 1).getValue() == 3 && carCount == 3) {
                chaiFen.add(carNum);
                carCount = 2;
                temp.setValue(2);
            } else if (carCount == 1 && chaiFen.size() != 0) { //到了单张的时候，需要注意拆分的牌了
                for (int k = 0; k < chaiFen.size(); k++) {
                    if (chaiFen.get(k) > carNum) {    //当拆分中的牌大于此牌时，先安排拆分的牌
                        sb.append(chaiFen.get(k) + " ");
                        chaiFen.remove(k);  //用过的牌需要移除
                        k--;    //移除后索引往前移一位
                    }
                }
            }
            for (int j = 0; j < carCount; j++) {
                sb.append(carNum + " ");
            }
        }

        if (chaiFen.size() != 0) {    //拆分的牌还有时需要继续用完
            for (int i : chaiFen) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
