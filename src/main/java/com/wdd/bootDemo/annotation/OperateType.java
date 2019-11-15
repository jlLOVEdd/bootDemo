package com.wdd.bootDemo.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description OperateType
 * @Author weidongdong
 * @Date 2019/11/14 15:59
 * @Version 1.0
 */

public enum OperateType {


    DEFAULT("默认操作",""),
    ADD("新增操作",""),
    DELETE("删除操作",""),
    UPDATE("更新",""),
    AUDIT("审核","");

    OperateType(String operateName, String desc) {
        this.operateName = operateName;
        this.desc = desc;
    }

    /**
     * 操作名称
     */
    private String operateName;
    /**
     * 操作描述
     */
    private String desc;

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
