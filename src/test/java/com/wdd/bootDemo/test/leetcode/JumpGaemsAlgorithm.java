package com.wdd.bootDemo.test.leetcode;

/**
 * 跳跃游戏 贪心算法
 */
public class JumpGaemsAlgorithm {

    public static void main(String[] args) {
        int[] jumpArrays = {2,3,1,2,4,2,3};

        System.out.println(jump2(jumpArrays));

    }

    public static int jump(int[] jumps) {
        int position = jumps.length-1;
        int step =0;
        while (position > 0) {
            for (int j = 0; j <=position; j++) {
                if (j + jumps[j] >= position) {
                    position=j;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public static int jump2(int[] jumps) {
        int length = jumps.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + jumps[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;


    }

}
