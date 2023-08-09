package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/2 21:03
 * @Version 1.0.0
 */
public class 路灯照明 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] strArr = sc.nextLine().split(" ");
        List<Light> list = getLeftRightList(num, strArr);
        getResult(list);
    }

    private static void getResult(List<Light> list) {
        Collections.sort(list);
        int left = list.get(0).left;
        int right = list.get(0).right;
        List<Light> lights = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Light currentLight = list.get(i);
            // 不存在重叠
            if (currentLight.left - right > 0) {
                lights.add(new Light(left, right));
                left = currentLight.left;
                right = currentLight.right;
            } else {
                left = Math.min(left, currentLight.left);
                right = Math.max(right, currentLight.right);
            }
        }
        lights.add(new Light(left, right));
        int res = 0;
        for (int i = 1; i < lights.size(); i++) {
            res += lights.get(i).left - lights.get(i - 1).right;
        }
        System.out.println(res);
    }

    private static List<Light> getLeftRightList(int num, String[] strArr) {
        List<Light> lightList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(strArr[i]);
            Light light = new Light(Math.max(i * 100 - n, 0), Math.min((num - 1) * 100, i * 100 + n));
            lightList.add(light);
        }
        return lightList;
    }

    private static class Light implements Comparable<Light> {
        int left;
        int right;

        public Light(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Light obj) {
            if (this.left == obj.left) {
                return this.right - obj.right;
            }
            return this.left - obj.left;
        }
    }
}
