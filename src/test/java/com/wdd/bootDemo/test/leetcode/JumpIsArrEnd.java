package com.wdd.bootDemo.test.leetcode;

/**
 * 跳跃游戏  给一个数组检测这个数组是否可以到达最后一个元素
 */
public class JumpIsArrEnd {

    public static void main(String[] args) {
        int[] test = {3,2,1,1,0,1};
        System.out.println(jumpEnd(test));

    }
    private static boolean jumpEnd(int[] arr){
        int length = arr.length;
        int rightMost =0;
        for(int i=0;i<length;i++){
            if(i>rightMost){
                return false;
            }
            rightMost =Math.max(rightMost,i+arr[i]);
        }
        return true;

    }

}
