package com.hss.algorithm.august.base;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/8/1 22:32
 * @Version 1.0.0
 */
public class 单词接龙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        //接龙的第一个单词
        String startWord = "";
         // key：单词的首字母
         // value：首字母相同的单词
        Map<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            if (i == K) {
                //起始单词单拎出来
                startWord = word;
                continue;
            }
            //单词的首字母
            char c = word.charAt(0);
            if (map.containsKey(c)) {
                map.get(c).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(c, list);
            }
        }
        //根据题意对单词进行排序
        for (List<String> list : map.values()) {
            list.sort((a, b) -> {
                if (a.length() == b.length()) {
                    //长度相同，词典排序
                    return a.compareTo(b);
                }
                //长度长的在前
                return b.length() - a.length();
            });
        }

        StringBuilder res = new StringBuilder(startWord);
        //首单词的末尾字符
        char last = startWord.charAt(startWord.length() - 1);
        while (map.containsKey(last) && map.get(last).size() != 0) {
            //以上个单词末尾字符起始的字符串集合
            List<String> wordList = map.get(last);
            //因为排过序，直接获取第一个
            String str = wordList.get(0);
            //获取接龙的末尾字符
            last = str.charAt(str.length() - 1);
            //直接拼接
            res.append(str);
            //用过的需要移除
            wordList.remove(0);
        }
        System.out.println(res);
    }
}
