package com.maxhanchen.dao.po;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "s_pk-products", table = "Products")
public class Product {

    /**
     */
    @NotNull
    @Column(name = "product_name")
    private String productName;

    /**
     */
    @NotNull
    @Column(name = "product_id")
    private Long prudctID;

    /**
     */
    @NotNull
    private Long price;

    /**
     */
    @NotNull
    private Long total;

    /**
     */
    @Size(max = 400)
    private String company;

    /**
     */
    @Column(name = "unified_business_no")
    @Size(max = 400)
    private String unifiedBusinessNo;

    /**
     */
    @Size(max = 400)
    private String description;

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
