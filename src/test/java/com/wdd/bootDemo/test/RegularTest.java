package com.wdd.bootDemo.test;

import java.util.regex.Pattern;

/**
 * @Description 正则表达式测试
 * @Author weidongdong
 * @Date 2019/12/13 17:15
 * @Version 1.0
 */
public class RegularTest {
   /* public static void main(String[] args) {
        String test = "\\a";
        String pattern = "\\\\a*";
        System.out.println( Pattern.matches(pattern, test));
    }*/

    public static void main(String[] args) {
        String test1 ="http://oss-cn-beijing-mtrh-d01-a.ops.data.cctv.com/cnews-yz/images/2019/12/10/1575959934613_211.jpg";
        String test2 ="http://p1.img.cctvpic.com/cportal/cnews-yz/images/2019/12/10/1575959934613_211.jpg";
        String s ="http://oss-cn-beijing-mtrh-d01-a.ops.data.cctv.com";
//        String path1 = test1.replace(s, "");
//        String path2 = test2.replace(s, "");
        String path1 =test1.replaceAll("http://[^/]*/", "/");
        String path2 =test2.replaceAll("http://[^/]*/", "/");
        System.out.println("path1----"+path1);
        System.out.println("path2----"+path2);
        String localPath1 = path1.substring(0, path1.lastIndexOf("/"));
        String localPath2 = path2.substring(0, path2.lastIndexOf("/"));
        System.out.println(localPath1);
        System.out.println(localPath2);
    }
}
