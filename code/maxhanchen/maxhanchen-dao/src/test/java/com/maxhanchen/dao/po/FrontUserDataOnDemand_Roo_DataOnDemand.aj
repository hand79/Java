// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.FrontUser;
import com.maxhanchen.dao.po.FrontUserDataOnDemand;
import com.maxhanchen.dao.service.FrontUserService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect FrontUserDataOnDemand_Roo_DataOnDemand {
    
    declare @type: FrontUserDataOnDemand: @Component;
    
    private Random FrontUserDataOnDemand.rnd = new SecureRandom();
    
    private List<FrontUser> FrontUserDataOnDemand.data;
    
    @Autowired
    FrontUserService FrontUserDataOnDemand.frontUserService;
    
    public FrontUser FrontUserDataOnDemand.getNewTransientFrontUser(int index) {
        FrontUser obj = new FrontUser();
        setAddress(obj, index);
        setAmount(obj, index);
        setCreateBy(obj, index);
        setCreateTime(obj, index);
        setDisabled(obj, index);
        setEmail(obj, index);
        setMobile(obj, index);
        setPassword(obj, index);
        setRoles(obj, index);
        setUpdateBy(obj, index);
        setUpdateTime(obj, index);
        setUsername(obj, index);
        return obj;
    }
    
    public void FrontUserDataOnDemand.setAddress(FrontUser obj, int index) {
        String address = "address_" + index;
        if (address.length() > 200) {
            address = address.substring(0, 200);
        }
        obj.setAddress(address);
    }
    
    public void FrontUserDataOnDemand.setAmount(FrontUser obj, int index) {
        Integer amount = new Integer(index);
        obj.setAmount(amount);
    }
    
    public void FrontUserDataOnDemand.setCreateBy(FrontUser obj, int index) {
        String createBy = "createBy_" + index;
        obj.setCreateBy(createBy);
    }
    
    public void FrontUserDataOnDemand.setCreateTime(FrontUser obj, int index) {
        Date createTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setCreateTime(createTime);
    }
    
    public void FrontUserDataOnDemand.setDisabled(FrontUser obj, int index) {
        Boolean disabled = Boolean.TRUE;
        obj.setDisabled(disabled);
    }
    
    public void FrontUserDataOnDemand.setEmail(FrontUser obj, int index) {
        String email = "foo" + index + "@bar.com";
        obj.setEmail(email);
    }
    
    public void FrontUserDataOnDemand.setMobile(FrontUser obj, int index) {
        String mobile = "mobile_" + index;
        obj.setMobile(mobile);
    }
    
    public void FrontUserDataOnDemand.setPassword(FrontUser obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }
    
    public void FrontUserDataOnDemand.setRoles(FrontUser obj, int index) {
        String roles = "roles_" + index;
        obj.setRoles(roles);
    }
    
    public void FrontUserDataOnDemand.setUpdateBy(FrontUser obj, int index) {
        String updateBy = "updateBy_" + index;
        obj.setUpdateBy(updateBy);
    }
    
    public void FrontUserDataOnDemand.setUpdateTime(FrontUser obj, int index) {
        Date updateTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setUpdateTime(updateTime);
    }
    
    public void FrontUserDataOnDemand.setUsername(FrontUser obj, int index) {
        String username = "username_" + index;
        obj.setUsername(username);
    }
    
    public FrontUser FrontUserDataOnDemand.getSpecificFrontUser(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        FrontUser obj = data.get(index);
        Long id = obj.getId();
        return frontUserService.findFrontUser(id);
    }
    
    public FrontUser FrontUserDataOnDemand.getRandomFrontUser() {
        init();
        FrontUser obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return frontUserService.findFrontUser(id);
    }
    
    public boolean FrontUserDataOnDemand.modifyFrontUser(FrontUser obj) {
        return false;
    }
    
    public void FrontUserDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = frontUserService.findFrontUserEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'FrontUser' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<FrontUser>();
        for (int i = 0; i < 10; i++) {
            FrontUser obj = getNewTransientFrontUser(i);
            try {
                frontUserService.saveFrontUser(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}