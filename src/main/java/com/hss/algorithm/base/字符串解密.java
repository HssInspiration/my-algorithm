package com.hss.algorithm.base;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/2/6 21:59
 * @Version 1.0.0
 */
public class 字符串解密 {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String string1 = sc.nextLine();
            String string2 = sc.nextLine();

            String temp = "";
            List<String> list = new ArrayList<>();  //符合要求的字符串集合
            int max = 0;
            int diffLen = length(string2);  //string2不同字母的数量
            for(int i=0; i<string1.length(); i++){
                char c = string1.charAt(i);
                if(c >= 'g' && c <= 'z'){   //g到z属于有效字母
                    temp += c;
                    if(i != string1.length() - 1) continue;     //需要考虑最后一个字母
                }
                if(!temp.equals("")){
                    int len = length(temp);     //子串中不同字母的数量
                    if(len <= diffLen){     //数量必须要小于等于string2的不同字母数量
                        if(len > max){
                            list.clear();       //有更接近string2的不同字母数量，清除list
                            max = Math.max( max, len);  //更新max值
                        }
                        list.add(temp);
                    }
                    temp  = "";     //temp已处理，需要置空
                }
            }

            Collections.sort(list);

            System.out.println(list.size() == 0 ? "Not Found" : list.get(list.size()-1));
        }

        /**
         * 求字符串中不同字母的数量
         * @param s
         * @return
         */
        public static int length(String s){

            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()){
                set.add(c);
            }

            return set.size();
        }

}
