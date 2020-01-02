package com.wdd.bootDemo.config;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description QuartzConfig
 * @Author weidongdong
 * @Date 2019/12/13 11:55
 * @Version 1.0
 */
@Configuration
public class QuartzConfig {

    private final  static String GROUP_NAME="jobGroup";



    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("executeJobTrigger") Trigger executeJobTrigger){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setStartupDelay(10);
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
        //注册触发器
        Trigger[] triggers = {executeJobTrigger};
        schedulerFactoryBean.setTriggers(triggers);
        return schedulerFactoryBean;
    }

    /**
     * 创建触发器工厂
     *
     * @param jobDetail
     * @param cronExpression
     * @return
     */
    private static CronTriggerFactoryBean cronTriggerFactoryBean(JobDetail jobDetail, String cronExpression) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setCronExpression(cronExpression);
        return factoryBean;
    }



    /**
     * 加载触发器
     *
     * 新建触发器进行job 的调度  例如 executeJobDetail
     * @param jobDetail
     * @return
     */
    @Bean(name = "executeJobTrigger")
    public CronTriggerFactoryBean executeJobTrigger(@Qualifier("executeJobDetail") JobDetail jobDetail) {
        //每天凌晨3点执行
        return cronTriggerFactoryBean(jobDetail, "*/5 * * * * ? ");
    }


    /**
     * 加载job
     *
     * 新建job 类用来代理
     *
     *
     * @return
     */
    @Bean
    public JobDetailFactoryBean executeJobDetail() {
        return createJobDetail(InvokingJobDetailFactory.class, GROUP_NAME, "executeJob");
    }


    /**
     * 执行规则job工厂
     *
     * 配置job 类中需要定时执行的 方法  execute
     * @param jobClass
     * @param groupName
     * @param targetObject
     * @return
     */
    private static JobDetailFactoryBean createJobDetail(Class<? extends Job> jobClass,
                                                        String groupName,
                                                        String targetObject) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setDurability(true);
        factoryBean.setRequestsRecovery(true);
        factoryBean.setGroup(groupName);
        Map<String, String> map = new HashMap<>();
        map.put("targetMethod", "execute");
        map.put("targetObject", targetObject);
        factoryBean.setJobDataAsMap(map);
        return factoryBean;
    }


}
