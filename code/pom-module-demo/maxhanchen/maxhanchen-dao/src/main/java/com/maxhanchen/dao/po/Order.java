package com.maxhanchen.dao.po;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "s_pk-orders", table = "Orders")
public class Order {

    /**
     */
    @NotNull
    @Column(name = "order_id")
    private Long orderID;

    /**
     */
    @Column(name = "order_name")
    @Size(max = 1000)
    private String orderName;

    /**
     */
    @Size(max = 1000)
    private String message;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private FrontUser username;

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
