package com.wdd.bootDemo.test.leetcode;

/**
 * @Description LastWord
 * @Author weidongdong
 * @Date 2020/5/21 16:14
 * @Version 1.0
 */
public class LastWord {
    public static void main(String[] args) {
        String s = "hello world   ";
        System.out.println(findLastWord(s));
    }
    public static int findLastWord(String  s){
       int end =  s.length()-1;
        if(s.length()>0){
            while (end>=0&&s.charAt(end)==' '){
                end--;
            }
            if(end<0) return 0;
            int start =end;
            while (start>=0&&s.charAt(start)!=' '){
                start--;
            }
            return end-start;
        }else{
            return 0;
        }
    }
}
