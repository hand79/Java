// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.BackUser;
import com.maxhanchen.dao.po.BackUserDataOnDemand;
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
import org.springframework.stereotype.Component;

privileged aspect BackUserDataOnDemand_Roo_DataOnDemand {
    
    declare @type: BackUserDataOnDemand: @Component;
    
    private Random BackUserDataOnDemand.rnd = new SecureRandom();
    
    private List<BackUser> BackUserDataOnDemand.data;
    
    public BackUser BackUserDataOnDemand.getNewTransientBackUser(int index) {
        BackUser obj = new BackUser();
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
    
    public void BackUserDataOnDemand.setAmount(BackUser obj, int index) {
        Integer amount = new Integer(index);
        obj.setAmount(amount);
    }
    
    public void BackUserDataOnDemand.setCreateBy(BackUser obj, int index) {
        String createBy = "createBy_" + index;
        obj.setCreateBy(createBy);
    }
    
    public void BackUserDataOnDemand.setCreateTime(BackUser obj, int index) {
        Date createTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setCreateTime(createTime);
    }
    
    public void BackUserDataOnDemand.setDisabled(BackUser obj, int index) {
        Boolean disabled = Boolean.TRUE;
        obj.setDisabled(disabled);
    }
    
    public void BackUserDataOnDemand.setEmail(BackUser obj, int index) {
        String email = "foo" + index + "@bar.com";
        obj.setEmail(email);
    }
    
    public void BackUserDataOnDemand.setMobile(BackUser obj, int index) {
        String mobile = "mobile_" + index;
        obj.setMobile(mobile);
    }
    
    public void BackUserDataOnDemand.setPassword(BackUser obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }
    
    public void BackUserDataOnDemand.setRoles(BackUser obj, int index) {
        String roles = "roles_" + index;
        obj.setRoles(roles);
    }
    
    public void BackUserDataOnDemand.setUpdateBy(BackUser obj, int index) {
        String updateBy = "updateBy_" + index;
        obj.setUpdateBy(updateBy);
    }
    
    public void BackUserDataOnDemand.setUpdateTime(BackUser obj, int index) {
        Date updateTime = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setUpdateTime(updateTime);
    }
    
    public void BackUserDataOnDemand.setUsername(BackUser obj, int index) {
        String username = "username_" + index;
        obj.setUsername(username);
    }
    
    public BackUser BackUserDataOnDemand.getSpecificBackUser(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        BackUser obj = data.get(index);
        Long id = obj.getId();
        return BackUser.findBackUser(id);
    }
    
    public BackUser BackUserDataOnDemand.getRandomBackUser() {
        init();
        BackUser obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return BackUser.findBackUser(id);
    }
    
    public boolean BackUserDataOnDemand.modifyBackUser(BackUser obj) {
        return false;
    }
    
    public void BackUserDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = BackUser.findBackUserEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'BackUser' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<BackUser>();
        for (int i = 0; i < 10; i++) {
            BackUser obj = getNewTransientBackUser(i);
            try {
                obj.persist();
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