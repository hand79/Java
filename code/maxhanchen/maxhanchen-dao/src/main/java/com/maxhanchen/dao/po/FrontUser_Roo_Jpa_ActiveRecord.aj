// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.FrontUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect FrontUser_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager FrontUser.entityManager;
    
    public static final List<String> FrontUser.fieldNames4OrderClauseFilter = java.util.Arrays.asList("username", "password", "amount", "address", "roles", "email", "mobile", "disabled", "createTime", "createBy", "updateTime", "updateBy");
    
    public static final EntityManager FrontUser.entityManager() {
        EntityManager em = new FrontUser().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long FrontUser.countFrontUsers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM FrontUser o", Long.class).getSingleResult();
    }
    
    public static List<FrontUser> FrontUser.findAllFrontUsers() {
        return entityManager().createQuery("SELECT o FROM FrontUser o", FrontUser.class).getResultList();
    }
    
    public static List<FrontUser> FrontUser.findAllFrontUsers(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM FrontUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, FrontUser.class).getResultList();
    }
    
    public static FrontUser FrontUser.findFrontUser(Long id) {
        if (id == null) return null;
        return entityManager().find(FrontUser.class, id);
    }
    
    public static List<FrontUser> FrontUser.findFrontUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM FrontUser o", FrontUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<FrontUser> FrontUser.findFrontUserEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM FrontUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, FrontUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void FrontUser.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void FrontUser.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            FrontUser attached = FrontUser.findFrontUser(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void FrontUser.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void FrontUser.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public FrontUser FrontUser.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        FrontUser merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}