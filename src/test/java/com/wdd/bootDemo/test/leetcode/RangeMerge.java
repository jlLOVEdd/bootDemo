package com.wdd.bootDemo.test.leetcode;

import java.util.*;

/**
 * 区间合并
 */
public class RangeMerge {
    public static void main(String[] args) {
       int[][] testArray = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
       int[] newArr = new int[]{4,8};
//        List<int[]> list = merge(testArray);
       int[][] list = joinMerge(testArray,newArr);

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i][0]+"---"+list[i][1]);

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

    public  static int[][] joinMerge(int[][] arr,int[] newarr){
        LinkedList<int[]> output = new LinkedList<int[]>();
        int newStart = newarr[0]; int newEnd = newarr[1];
         int len = arr.length;
        int i=0;
        if(len<0){
           output.add(newarr);
           return output.toArray(new int[output.size()][2]);
        }
        while (arr[i][0]<=newStart){
            output.add(arr[i]);
                i++;
        }
        int[] insertArr = new int[]{};
        if(output.isEmpty()|| output.getLast()[1] < newStart){

            output.add(newarr);
        }else{
            insertArr = output.removeLast();
            insertArr[1] =Math.max(newEnd,insertArr[1]);
            output.add(insertArr);
        }
        while (i<len) {
            int end = insertArr[1];
            int istart = arr[i][0];
            int iend = arr[i][1];
            if(end>=istart){
                insertArr[1]=Math.max(end,iend);
            }else{
                output.add(arr[i]);
            }
            i++;
        }

        return output.toArray(new int[output.size()][2]);

    }
}
