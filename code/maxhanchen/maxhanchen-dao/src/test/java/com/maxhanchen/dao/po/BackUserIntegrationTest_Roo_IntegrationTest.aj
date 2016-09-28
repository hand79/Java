// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.BackUser;
import com.maxhanchen.dao.po.BackUserDataOnDemand;
import com.maxhanchen.dao.po.BackUserIntegrationTest;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BackUserIntegrationTest_Roo_IntegrationTest {
    
    declare @type: BackUserIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: BackUserIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: BackUserIntegrationTest: @Transactional;
    
    @Autowired
    BackUserDataOnDemand BackUserIntegrationTest.dod;
    
    @Test
    public void BackUserIntegrationTest.testCountBackUsers() {
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", dod.getRandomBackUser());
        long count = BackUser.countBackUsers();
        Assert.assertTrue("Counter for 'BackUser' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void BackUserIntegrationTest.testFindBackUser() {
        BackUser obj = dod.getRandomBackUser();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to provide an identifier", id);
        obj = BackUser.findBackUser(id);
        Assert.assertNotNull("Find method for 'BackUser' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'BackUser' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void BackUserIntegrationTest.testFindAllBackUsers() {
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", dod.getRandomBackUser());
        long count = BackUser.countBackUsers();
        Assert.assertTrue("Too expensive to perform a find all test for 'BackUser', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<BackUser> result = BackUser.findAllBackUsers();
        Assert.assertNotNull("Find all method for 'BackUser' illegally returned null", result);
        Assert.assertTrue("Find all method for 'BackUser' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void BackUserIntegrationTest.testFindBackUserEntries() {
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", dod.getRandomBackUser());
        long count = BackUser.countBackUsers();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<BackUser> result = BackUser.findBackUserEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'BackUser' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'BackUser' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void BackUserIntegrationTest.testFlush() {
        BackUser obj = dod.getRandomBackUser();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to provide an identifier", id);
        obj = BackUser.findBackUser(id);
        Assert.assertNotNull("Find method for 'BackUser' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyBackUser(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'BackUser' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void BackUserIntegrationTest.testMergeUpdate() {
        BackUser obj = dod.getRandomBackUser();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to provide an identifier", id);
        obj = BackUser.findBackUser(id);
        boolean modified =  dod.modifyBackUser(obj);
        Integer currentVersion = obj.getVersion();
        BackUser merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'BackUser' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void BackUserIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", dod.getRandomBackUser());
        BackUser obj = dod.getNewTransientBackUser(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'BackUser' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'BackUser' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'BackUser' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void BackUserIntegrationTest.testRemove() {
        BackUser obj = dod.getRandomBackUser();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'BackUser' failed to provide an identifier", id);
        obj = BackUser.findBackUser(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'BackUser' with identifier '" + id + "'", BackUser.findBackUser(id));
    }
    
}
