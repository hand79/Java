// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.FrontUser;
import com.maxhanchen.dao.po.Order;
import java.util.Date;

privileged aspect Order_Roo_JavaBean {
    
    public Long Order.getOrderID() {
        return this.orderID;
    }
    
    public void Order.setOrderID(Long orderID) {
        this.orderID = orderID;
    }
    
    public String Order.getOrderName() {
        return this.orderName;
    }
    
    public void Order.setOrderName(String orderName) {
        this.orderName = orderName;
    }
    
    public String Order.getMessage() {
        return this.message;
    }
    
    public void Order.setMessage(String message) {
        this.message = message;
    }
    
    public FrontUser Order.getUsername() {
        return this.username;
    }
    
    public void Order.setUsername(FrontUser username) {
        this.username = username;
    }
    
    public Date Order.getCreateTime() {
        return this.createTime;
    }
    
    public void Order.setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String Order.getCreateBy() {
        return this.createBy;
    }
    
    public void Order.setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    public Date Order.getUpdateTime() {
        return this.updateTime;
    }
    
    public void Order.setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public String Order.getUpdateBy() {
        return this.updateBy;
    }
    
    public void Order.setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
}
