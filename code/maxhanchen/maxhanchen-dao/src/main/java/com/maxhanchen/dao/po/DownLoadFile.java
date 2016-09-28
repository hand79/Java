package com.maxhanchen.dao.po;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "DownLoad_files")
public class DownLoadFile {

    /**
     */
    @NotNull
    @Column(name = "file_name")
    private String filename;

    /**
     */
    @NotNull
    @Column(name = "content_type")
    private String contentType;

    /**
     */
    @NotNull
    private Byte content;

    /**
     */
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     */
    @Column(name = "create_by")
    private String createBy;
}
