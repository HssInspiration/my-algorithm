package com.hss.algorithm.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 21:56
 * @Version 1.0.0
 */
public class 网上商城优惠活动一 {

    public static int manjian;
    public static int dazhe;
    public static int wumenkan;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        manjian = sc.nextInt();
        dazhe = sc.nextInt();
        wumenkan = sc.nextInt();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            double money = sc.nextInt();

            int quanMJ = money / 100 > manjian ? manjian : (int) (money / 100);   //首先使用满减的张数

            /**
             * key：活动后的价格
             * value：使用优惠券的张数
             */
            Map<Double, Integer> map = new HashMap<>();
            double afterDZ = Double.MAX_VALUE;
            double afterMJ = Double.MAX_VALUE;
            double dazheWMK = Double.MAX_VALUE;

            if (dazhe > 0) {  //有打折券的情况
                afterDZ = Manjian(money) * 0.92;     //先满减后打折
                map.put(afterDZ, quanMJ + 1);

                afterMJ = Manjian(money * 0.92);   //先打折后满减
                int quanMJAfterDZ = (int) (money * 0.92 / 100 > manjian ? manjian : money * 0.92 / 100); //先打折后满减的满减券
                if (map.containsKey(afterMJ)) {
                    map.put(afterMJ, map.get(afterMJ) > quanMJAfterDZ + 1 ? quanMJAfterDZ + 1 : map.get(afterMJ));
                } else {
                    map.put(afterMJ, 1 + quanMJAfterDZ);
                }

                dazheWMK = money * 0.92 - wumenkan * 5;  //先打折后无门槛
                if (map.containsKey(dazheWMK)) {
                    map.put(dazheWMK, map.get(dazheWMK) > wumenkan + 1 ? wumenkan + 1 : map.get(dazheWMK));
                } else {
                    map.put(dazheWMK, 1 + wumenkan);
                }
            }

            double manjianWMK = Manjian(money) - wumenkan * 5;  //先满减后无门槛
            if (map.containsKey(manjianWMK)) {
                map.put(manjianWMK, map.get(manjianWMK) > quanMJ + wumenkan ? quanMJ + wumenkan : map.get(manjianWMK));
            } else {
                map.put(manjianWMK, quanMJ + wumenkan);
            }

            double min = Math.min(Math.min(afterDZ, afterMJ), Math.min(manjianWMK, dazheWMK)); //求出最小价格

            System.out.println((int) Math.floor(min) + " " + map.get(min));

        }

    }

    /**
     * 满减后的价格
     *
     * @param money
     * @return
     */
    public static double Manjian(double money) {

        if (money / 100 >= manjian) {
            return money - manjian * 10;
        } else {
            return money - (money / 100) * 10;
        }
    }

}
