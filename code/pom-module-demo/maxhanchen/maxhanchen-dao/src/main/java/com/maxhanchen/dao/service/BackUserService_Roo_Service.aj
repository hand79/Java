// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.service;

import com.maxhanchen.dao.po.BackUser;
import com.maxhanchen.dao.service.BackUserService;
import java.util.List;

privileged aspect BackUserService_Roo_Service {
    
    public abstract long BackUserService.countAllBackUsers();    
    public abstract void BackUserService.deleteBackUser(BackUser backUser);    
    public abstract BackUser BackUserService.findBackUser(Long id);    
    public abstract List<BackUser> BackUserService.findAllBackUsers();    
    public abstract List<BackUser> BackUserService.findBackUserEntries(int firstResult, int maxResults);    
    public abstract void BackUserService.saveBackUser(BackUser backUser);    
    public abstract BackUser BackUserService.updateBackUser(BackUser backUser);    
}
