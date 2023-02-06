package com.hss.algorithm.advance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:10
 * @Version 1.0.0
 */
public class 寻找符合要求的最长子串 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char c = sc.nextLine().charAt(0);
        String s = sc.nextLine();

        int left = 0;   //子串的起始位置
        int max = 0;
        /**
         * key：字符
         * value：字符出现的次数
         */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == c) {
                map.clear();    //指定字符之前的数据需要清空
                left = i + 1; //指定字符本身不做计数，所以需要+1
                continue;
            }

            map.put(temp, map.getOrDefault(temp, 0) + 1);
            while (map.get(temp) == 3) {     //字符出现第二次之前的字符都需要删除
                char rmStr = s.charAt(left);
                left++;
                map.put(rmStr, map.get(rmStr) - 1);    //起始位置后移，字符个数也需要-1
            }

            max = Math.max(max, i - left + 1);
        }

        System.out.println(max);
    }
}
