package com.wdd.bootDemo.test.jvm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

class AppMongo {
    private String appName;
    private String packageName;
    private int versionCode;
    private Date installTime;
    private String iconUrl;
    private String downloadUrl;
    private String remark;
    private Long size;
    private String developer;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public Date getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}

// 需要保存到MongoDB中的用户已安装app信息，这样保存的好处就是MongoDB中installed_apps这张表的user_id能设置唯一键约束，查询性能相比RDBMS中数据平铺要高不少
class UserAppMongo {
    private String id;
    private Long userId;
    private List<AppMongo> appMongoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<AppMongo> getAppMongoList() {
        return appMongoList;
    }

    public void setAppMongoList(List<AppMongo> appMongoList) {
        this.appMongoList = appMongoList;
    }
}

// 关系型数据库中用户已安装app
class AppFromMySQL {

    public AppFromMySQL(int id, Long userId, String packageName, int versionCode, Date installTime, String appName) {
        this.id = id;
        this.userId = userId;
        this.packageName = packageName;
        this.versionCode = versionCode;
        this.installTime = installTime;
        this.appName = appName;
    }

    private int id;
    private Long userId;
    private String packageName;
    private int versionCode;
    private Date installTime;
    private String appName;
    private String iconUrl;
    private String downloadUrl;
    private String remark;
    private Long size;
    private String developer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public Date getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}

public class FullGCSample {

    public static void main(String[] args) throws Exception {
        for (int pageNo = 0; pageNo < 10000; pageNo++) {
            List<Long> userList = getUserIdByPage(pageNo);
            List<UserAppMongo> userAppMongoList = new ArrayList<>(userList.size());
            for (Long userId : userList) {
                List<AppFromMySQL> appFromMySQLList = getUserInstalledAppList(userId);
                UserAppMongo userAppMongo = new UserAppMongo();
                userAppMongo.setId(System.nanoTime() + "");//测试代码任意模拟一个伪唯一ID
                userAppMongo.setUserId(userId);
                userAppMongo.setAppMongoList(appFromMySQL2AppMongo(appFromMySQLList));
                userAppMongoList.add(userAppMongo);
            }
            // save List<UserAppMongo> to mongodb
            save2MongoDB(userAppMongoList);
        }
    }

    private static void save2MongoDB(List<UserAppMongo> userAppMongoList) throws Exception {
        // 模拟保存一次数据到mongodb中要5ms
        Thread.sleep(5);
    }

    private static List<AppMongo> appFromMySQL2AppMongo(List<AppFromMySQL> list) {
        List<AppMongo> appMongoList = new ArrayList<>();
        for (AppFromMySQL app : list) {
            AppMongo appMongo = new AppMongo();
            //TODO bean copy
            appMongoList.add(appMongo);
        }
        return appMongoList;
    }

    private static List<AppFromMySQL> getUserInstalledAppList(Long useId) {
        List<AppFromMySQL> appFromMySQLList = new ArrayList<>();
        // 假设用户手机上安装的app数量在50~200之间
        int size = 50 + new Random().nextInt(150);
        for (int i = 0; i < size; i++) {
            AppFromMySQL appFromMySQL = new AppFromMySQL(i, (long) i, "com.afei.android" + i, i, new Date(), "appName" + i);
            appFromMySQL.setIconUrl(String.valueOf(i));
            appFromMySQL.setDownloadUrl(String.valueOf(i));
            appFromMySQL.setRemark(String.valueOf(i));
            appFromMySQL.setSize((long) i);
            appFromMySQL.setDeveloper(String.valueOf(i));
            appFromMySQLList.add(appFromMySQL);
        }
        return appFromMySQLList;
    }

    private static List<Long> getUserIdByPage(int pageNo) {
        List<Long> userList = new ArrayList<>();
        // 取数据时每一页1000个用户
        for (int i = 0; i < 2000; i++) {
            userList.add((long) i);
        }
        return userList;
    }
}

