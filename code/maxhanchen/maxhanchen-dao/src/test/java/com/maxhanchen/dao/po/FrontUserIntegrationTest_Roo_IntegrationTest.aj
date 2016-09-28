// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.FrontUserDataOnDemand;
import com.maxhanchen.dao.po.FrontUserIntegrationTest;
import com.maxhanchen.dao.service.FrontUserService;
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

privileged aspect FrontUserIntegrationTest_Roo_IntegrationTest {
    
    declare @type: FrontUserIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: FrontUserIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: FrontUserIntegrationTest: @Transactional;
    
    @Autowired
    FrontUserDataOnDemand FrontUserIntegrationTest.dod;
    
    @Autowired
    FrontUserService FrontUserIntegrationTest.frontUserService;
    
    @Test
    public void FrontUserIntegrationTest.testCountAllFrontUsers() {
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", dod.getRandomFrontUser());
        long count = frontUserService.countAllFrontUsers();
        Assert.assertTrue("Counter for 'FrontUser' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void FrontUserIntegrationTest.testFindFrontUser() {
        FrontUser obj = dod.getRandomFrontUser();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to provide an identifier", id);
        obj = frontUserService.findFrontUser(id);
        Assert.assertNotNull("Find method for 'FrontUser' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'FrontUser' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void FrontUserIntegrationTest.testFindAllFrontUsers() {
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", dod.getRandomFrontUser());
        long count = frontUserService.countAllFrontUsers();
        Assert.assertTrue("Too expensive to perform a find all test for 'FrontUser', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<FrontUser> result = frontUserService.findAllFrontUsers();
        Assert.assertNotNull("Find all method for 'FrontUser' illegally returned null", result);
        Assert.assertTrue("Find all method for 'FrontUser' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void FrontUserIntegrationTest.testFindFrontUserEntries() {
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", dod.getRandomFrontUser());
        long count = frontUserService.countAllFrontUsers();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<FrontUser> result = frontUserService.findFrontUserEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'FrontUser' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'FrontUser' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void FrontUserIntegrationTest.testFlush() {
        FrontUser obj = dod.getRandomFrontUser();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to provide an identifier", id);
        obj = frontUserService.findFrontUser(id);
        Assert.assertNotNull("Find method for 'FrontUser' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyFrontUser(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'FrontUser' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void FrontUserIntegrationTest.testUpdateFrontUserUpdate() {
        FrontUser obj = dod.getRandomFrontUser();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to provide an identifier", id);
        obj = frontUserService.findFrontUser(id);
        boolean modified =  dod.modifyFrontUser(obj);
        Integer currentVersion = obj.getVersion();
        FrontUser merged = frontUserService.updateFrontUser(obj);
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'FrontUser' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void FrontUserIntegrationTest.testSaveFrontUser() {
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", dod.getRandomFrontUser());
        FrontUser obj = dod.getNewTransientFrontUser(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'FrontUser' identifier to be null", obj.getId());
        try {
            frontUserService.saveFrontUser(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'FrontUser' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void FrontUserIntegrationTest.testDeleteFrontUser() {
        FrontUser obj = dod.getRandomFrontUser();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FrontUser' failed to provide an identifier", id);
        obj = frontUserService.findFrontUser(id);
        frontUserService.deleteFrontUser(obj);
        obj.flush();
        Assert.assertNull("Failed to remove 'FrontUser' with identifier '" + id + "'", frontUserService.findFrontUser(id));
    }
    
}