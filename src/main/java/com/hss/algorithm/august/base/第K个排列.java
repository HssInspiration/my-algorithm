package com.hss.algorithm.august.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:25
 * @Version 1.0.0
 */
public class 第K个排列 {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i + 1;
        }

        // cursor:从第一个数开始
        fullArray(ints, 0, n - 1);
        // 对list进行升序排序
        list.sort((a, b) -> b > a ? -1 : 1);
        System.out.println(list.get(k - 1));
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 这是经典的全排列递归算法
     *
     * @param array  需要排列的数组
     * @param cursor 初始位置
     * @param end    结束位置
     */
    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {    //此次排列完成
            StringBuilder s = new StringBuilder();
            for (int a : array) {
                s.append(a);
            }
            list.add(Integer.parseInt(s.toString()));
        } else {
            for (int i = cursor; i <= end; i++) {
                swap(array, cursor, i); //将数组下标为cursor和下标为i的数据进行交换
                fullArray(array, cursor + 1, end);
                swap(array, cursor, i); // 用于对之前交换过的数据进行还原
            }
        }
    }
}
