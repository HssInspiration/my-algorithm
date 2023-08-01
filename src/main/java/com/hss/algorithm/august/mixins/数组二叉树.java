package com.hss.algorithm.august.mixins;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:40
 * @Version 1.0.0
 */
public class 数组二叉树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int len = strings.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int idx = -1;   //最小叶子节点索引
        for (int i = 0; i < len; i++) {
            if (ints[i] == -1) {    //空节点直接返回
                continue;
            }
            if ((i + 1) * 2 + 1 > ints.length ||
                    (ints[(i + 1) * 2 - 1] == -1 && ints[(i + 1) * 2] == -1)) {  //判断是否为叶子节点
                if (idx == -1 || ints[idx] > ints[i]) {
                    idx = i;
                }
            }
        }
        Deque<Integer> stack = new ArrayDeque<>();  //使用栈先进先出
        stack.push(idx);
        //用叶子节点向上推到根节点
        while (idx > 0) {
            if ((idx + 1) % 2 == 0) {
                idx = (idx + 1) / 2 - 1;
                stack.push(idx);
            } else {
                idx = idx / 2 - 1;
                stack.push(idx);
            }
        }
        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            ret.append(" ").append(ints[stack.pop()]);
        }
        System.out.println(ret.substring(1));
    }
}
