package com.hss.algorithm.august.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:20
 * @Version 1.0.0
 */
public class 解压报文 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getAlphaDeque(sc.nextLine()));
    }

    private static Deque<StringBuffer> getAlphaDeque(String s) {
        Deque<StringBuffer> alphaBeta = new ArrayDeque<>();
        StringBuffer res = new StringBuffer();  //处理前的字母串
        StringBuilder numStr = new StringBuilder();  //处理多位数
        Deque<Integer> num = new ArrayDeque<>();    //数字队列
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (res.length() != 0) {    //数字前的字母暂不处理
                    alphaBeta.push(res);
                    res = new StringBuffer();
                }
                numStr.append(c);
            } else if (c == '[') {
                num.push(Integer.parseInt(numStr.toString()));  //数字放入数字队列
                numStr = new StringBuilder();
            } else if (c == ']') {
                int n = num.pop();  //碰到“]”，就需要取出最上面的数字进行解压
                if (res.length() != 0) {
                    alphaBeta.push(res);
                    res = new StringBuffer();
                }
                StringBuffer temp = alphaBeta.pop(); //取出最上面的字母
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    sb.append(temp);    //对字母进行解压
                }
                if (alphaBeta.isEmpty()) {
                    alphaBeta.push(sb);
                } else {
                    alphaBeta.push(alphaBeta.pop().append(sb));   //后面处理过的字符会跟最上面的字符一起被处理
                }
            } else {
                res.append(c);
            }
        }
        return alphaBeta;
    }
}
