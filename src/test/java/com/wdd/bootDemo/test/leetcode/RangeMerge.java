package com.wdd.bootDemo.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 区间合并
 */
public class RangeMerge {
    public static void main(String[] args) {
       int[][] testArray = new int[][] {{5,9},{1,3},{2,4}};
        List<int[]> list = merge(testArray);
        for (int i = 0; i < list.size(); i++) {
            int[] item= list.get(i);
            System.out.println(item[0]+"---"+item[1]);

        }
    }
    public static List<int[]> merge(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int left =arr[i][0];
            int right =arr[i][1];
            while (i<arr.length-1&&right>=arr[i+1][0]){
                right =Math.max(right,arr[i+1][1]);
                i++;
            }
            result.add(new int[]{left,right});

        }
        return result;
    }
}
