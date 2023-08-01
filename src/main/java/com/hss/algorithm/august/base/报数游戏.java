package com.hss.algorithm.august.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:29
 * @Version 1.0.0
 */
public class 报数游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        //100个人的集合
        for (int i = 0; i < 100; i++) {
            list.add(i + 1);
        }
        //初始下标（集合下标从0开始，所有要-1）
        int i = n - 1;
        //如果人数大于等于n就需要继续
        while (list.size() >= n) {
            //移除报n的人
            list.remove(i);
            //因为少了一个人所以后面的所有下标都要向前移一位
            i--;
            //因为是围成的圆圈，所以下标越界后需要绕到最前面
            i = i + n < list.size() ? i + n : i + n - list.size();
        }
        System.out.println(list);
    }
}
