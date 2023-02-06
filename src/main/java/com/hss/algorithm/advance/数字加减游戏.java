package com.hss.algorithm.advance;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:12
 * @Version 1.0.0
 */
public class 数字加减游戏 {
    

//    public static int t,a,b;
//    public static int min = Integer.MAX_VALUE;

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int s = sc.nextInt();
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
//        int min = Integer.MAX_VALUE;
//
//        for(int i=0;i<100000/a; i++){
//            if((t - (s + a*i))%b == 0){
//                min = Math.min( min, i);
//                break;
//            }
//        }
//
//        for(int i=0;i<100000/a; i++){
//            if((t - (s - a*i))%b == 0){
//                min = Math.min( min, i);
//                break;
//            }
//        }

            int res = 0;
            int add = s;
            int sub = s;
            while (true) {
                if ((t - add) % b == 0) {
                    break;
                }
                if ((t - sub) % b == 0) {
                    break;
                }
                add += a;
                sub -= a;
                res++;
            }

            //handle( s, 0 , "");

            System.out.println(res);
        }

//    public static void handle(int s, int n, String operation){
//
//        if((t - s) % b == 0){
//            min = Math.min( min, n);
//        }else {
//            if(!operation.equals("add")){
//                handle(s - a , n+1, "sub");
//            }
//            if(!operation.equals("sub")){
//                handle(s + a , n+1, "add");
//            }
//        }
//    }

}
