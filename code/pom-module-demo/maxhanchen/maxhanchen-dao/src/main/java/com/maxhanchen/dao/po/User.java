package com.maxhanchen.dao.po;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "s_pk-users", table = "Users", finders = { "findUsersByUsernameEquals", "findUsersByRoleLike" })
public class User {

    /**
     */
    @NotNull
    @Column(name = "user_name", unique = true)
    private String username;

    /**
     */
    @NotNull
    private String password;

    /**
     */
    private String role;

    /**
     */
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")
    private String email;

    /**
     */
    private String mobile;

    /**
     */
    private Boolean disabled;

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

    /**
     */
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     */
    @Column(name = "update_by")
    private String updateBy;
}
