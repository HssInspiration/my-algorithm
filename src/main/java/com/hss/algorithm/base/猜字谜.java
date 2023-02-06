package com.hss.algorithm.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/qq_34465338/article/details/128331143
 *
 * @Author hss
 * @Date 2023/2/6 20:07
 * @Version 1.0.0
 */
public class 猜字谜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] contentArrays = sc.nextLine().split(",");
        String[] resultArrays = sc.nextLine().split(",");
        List<String> resList = new ArrayList<>();
        for (String content : contentArrays) {
            boolean isExist = false;
            for (String result : resultArrays) {
                if (sortAndDeduplicate(content, result)) {
                    resList.add(result);
                    isExist = true;
                }
            }
            if (!isExist) {
                resList.add("not found");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : resList) {
            stringBuilder.append(s).append(",");
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }

    private static boolean sortAndDeduplicate(String content, String result) {
        char[] contentChars = content.toCharArray();
        Arrays.sort(contentChars);
        char[] resultChars = result.toCharArray();
        Arrays.sort(resultChars);
        boolean deduplicatedFlag = getCharList(content).equals(getCharList(result));
        return Arrays.equals(contentChars, resultChars) || deduplicatedFlag;
    }

    private static List<Character> getCharList(String str) {
        List<Character> characterList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!characterList.contains(c)) {
                characterList.add(c);
            }
        }
        return characterList;
    }
}
