package com.wdd.bootDemo.test.leetcode;

/**
 * @Description 给一个N数字 将N*N个数以逆时针方向放置在二维数组中
 * @Author weidongdong
 * @Date 2020/5/21 16:59
 * @Version 1.0
 */
public class SmII {

    public static void main(String[] args) {
        int s = 1;
        int[][] test = sm(s);
        for (int i=0;i<s;i++){
            String str ="";

            for (int j=0;j<s;j++) {
                str+=(test[i][j]+"---");
            }
            System.out.println(str);
        }
    }

    public static int[][] sm(int n) {
        int[][] ints = new int[n][n];
        int s = 1;
        int len = n * n;
        int t = 0;
        int r = n - 1;
        int b = n - 1;
        int l = 0;
        while (s <= len) {
            for (int i = l; i <=r; i++) {
                ints[t][i] = s++;

            }t++;
            for (int i = t; i <= b; i++) {
                ints[i][r] = s++;

            } r--;
            for (int i = r; i >= l; i--) {
                ints[b][i] = s++;

            }
            b--;
            for (int i = b; i >= t; i--) {
                ints[i][l] = s++;

            }l++;
        }


        return ints;

    }
}
