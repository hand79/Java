// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.Order;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Order_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Order.entityManager;
    
    public static final List<String> Order.fieldNames4OrderClauseFilter = java.util.Arrays.asList("orderID", "orderName", "message", "username", "createTime", "createBy", "updateTime", "updateBy");
    
    public static final EntityManager Order.entityManager() {
        EntityManager em = new Order().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Order.countOrders() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Order o", Long.class).getSingleResult();
    }
    
    public static List<Order> Order.findAllOrders() {
        return entityManager().createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }
    
    public static List<Order> Order.findAllOrders(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Order o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Order.class).getResultList();
    }
    
    public static Order Order.findOrder(Long id) {
        if (id == null) return null;
        return entityManager().find(Order.class, id);
    }
    
    public static List<Order> Order.findOrderEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Order o", Order.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Order> Order.findOrderEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Order o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Order.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Order.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Order.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Order attached = Order.findOrder(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Order.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Order.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Order Order.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Order merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
