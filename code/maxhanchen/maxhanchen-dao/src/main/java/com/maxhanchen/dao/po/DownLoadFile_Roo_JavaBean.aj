// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.DownLoadFile;
import java.util.Date;

privileged aspect DownLoadFile_Roo_JavaBean {
    
    public String DownLoadFile.getFilename() {
        return this.filename;
    }
    
    public void DownLoadFile.setFilename(String filename) {
        this.filename = filename;
    }
    
    public String DownLoadFile.getContentType() {
        return this.contentType;
    }
    
    public void DownLoadFile.setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    public Byte DownLoadFile.getContent() {
        return this.content;
    }
    
    public void DownLoadFile.setContent(Byte content) {
        this.content = content;
    }
    
    public Date DownLoadFile.getCreateTime() {
        return this.createTime;
    }
    
    public void DownLoadFile.setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String DownLoadFile.getCreateBy() {
        return this.createBy;
    }
    
    public void DownLoadFile.setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
}
