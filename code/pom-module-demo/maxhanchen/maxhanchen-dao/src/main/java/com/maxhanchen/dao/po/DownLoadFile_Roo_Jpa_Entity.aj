// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.DownLoadFile;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect DownLoadFile_Roo_Jpa_Entity {
    
    declare @type: DownLoadFile: @Entity;
    
    declare @type: DownLoadFile: @Table(name = "DownLoad_files");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long DownLoadFile.id;
    
    @Version
    @Column(name = "version")
    private Integer DownLoadFile.version;
    
    public Long DownLoadFile.getId() {
        return this.id;
    }
    
    public void DownLoadFile.setId(Long id) {
        this.id = id;
    }
    
    public Integer DownLoadFile.getVersion() {
        return this.version;
    }
    
    public void DownLoadFile.setVersion(Integer version) {
        this.version = version;
    }
    
}
