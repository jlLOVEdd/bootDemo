package com.wdd.bootDemo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TestMain
 * @Author weidongdong
 * @Date 2019/11/15 10:40
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {

        //dev1/dev1/dev1/dev1/dev1/dev11231231231
//        System.out.println(fun());


        //dev2222222222222222222222222222222221git

        //reset ---default
     /*   String test = "{\\\"brief\\\":\\\"\\\",\\\"templateType\\\":\\\"\\\",\\\"videoLength\\\":\\\"\\\",\\\"videoType\\\":\\\"\\\\\\\\u7c97\\\\\\\\u5207\\\",\\\"num\\\":\\\"\\\",\\\"videoID\\\":\\\"ArtiuCAYBKEwrnrT1Axl43yU161218\\\",\\\"videoTitle\\\":\\\"\\xe3\\x80\\x8a\\\\\\\\u9762\\\\\\\\u5bf9\\\\\\\\u9762\\xe3\\x80\\x8b 20161218\\\",\\\"pubDate\\\":\\\"1482072818000\\\",\\\"commentNum\\\":\\\"\\\",\\\"videoUrl\\\":\\\"\\\",\\\"videoImage\\\":\\\"http://p5.img.cctvpic.com/fmspic/2016/12/18/a9b1dd42996c40ed93f4bf8098882a15-1211.jpg\\\",\\\"videoPlayID\\\":\\\"a9b1dd42996c40ed93f4bf8098882a15\\\",\\\"videoPageId\\\":\\\"\\\",\\\"videoTag\\\":\\\"\\\"}";

        System.out.println(test);*/
     Date testDate = new Date(1482071363000L);
        System.out.println(testDate);
        System.out.println(getMemberScoreForVideo((short) 1, testDate).longValue());

    }

    public static Double getMemberScoreForVideo(short guType, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        if (date == null) {
            try {
                date = sdf.parse("19700801 00:00:00");
            } catch (ParseException e) {
                //log.error("日期转换错误");
            }
        }
        //将24小时转换为秒
        long hour24 = (long) 24 * 60 * 60;
        //计算hh:MM:ss的秒数
        SimpleDateFormat sdfFront = new SimpleDateFormat("yyyyMMdd");
        Long initalDate = (long) 0;
        Long frontDate = (long) 0;
        Long hourMinSec = (long) 0;
        Double score = (double) 19700801;
        try {
            initalDate = sdf.parse(sdf.format(date)).getTime() / 1000;
            frontDate = sdfFront.parse(sdfFront.format(date)).getTime() / 1000;
            hourMinSec = initalDate - frontDate;
            score = (double) (Long.parseLong(sdfFront.format(date)) * Math.pow(10, 6) + (5 - guType) * Math.pow(10, 5) + (hour24 - hourMinSec));
        } catch (ParseException e) {
            //log.error("日期转换错误");
        }

        return score;

    }


    public static StringBuffer fun() {
        int i = 0;
        StringBuffer s = new StringBuffer("world");

        try {
            System.out.println("-------------try");
            return s;
        } catch (Exception e) {
            System.out.println("------------exception");
            return null;
        } finally {
            System.out.println("---------finally");
            i += 1;
            s.append("finally");

        }

    }
}
