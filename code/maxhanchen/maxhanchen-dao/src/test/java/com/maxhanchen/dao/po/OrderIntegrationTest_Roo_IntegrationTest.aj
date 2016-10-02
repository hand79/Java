// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.po;

import com.maxhanchen.dao.po.OrderDataOnDemand;
import com.maxhanchen.dao.po.OrderIntegrationTest;
import com.maxhanchen.dao.service.OrderService;
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

privileged aspect OrderIntegrationTest_Roo_IntegrationTest {
    
    declare @type: OrderIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: OrderIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: OrderIntegrationTest: @Transactional;
    
    @Autowired
    OrderDataOnDemand OrderIntegrationTest.dod;
    
    @Autowired
    OrderService OrderIntegrationTest.orderService;
    
    @Test
    public void OrderIntegrationTest.testCountAllOrders() {
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", dod.getRandomOrder());
        long count = orderService.countAllOrders();
        Assert.assertTrue("Counter for 'Order' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void OrderIntegrationTest.testFindOrder() {
        Order obj = dod.getRandomOrder();
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Order' failed to provide an identifier", id);
        obj = orderService.findOrder(id);
        Assert.assertNotNull("Find method for 'Order' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Order' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void OrderIntegrationTest.testFindAllOrders() {
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", dod.getRandomOrder());
        long count = orderService.countAllOrders();
        Assert.assertTrue("Too expensive to perform a find all test for 'Order', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Order> result = orderService.findAllOrders();
        Assert.assertNotNull("Find all method for 'Order' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Order' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void OrderIntegrationTest.testFindOrderEntries() {
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", dod.getRandomOrder());
        long count = orderService.countAllOrders();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Order> result = orderService.findOrderEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Order' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Order' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void OrderIntegrationTest.testFlush() {
        Order obj = dod.getRandomOrder();
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Order' failed to provide an identifier", id);
        obj = orderService.findOrder(id);
        Assert.assertNotNull("Find method for 'Order' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyOrder(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Order' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void OrderIntegrationTest.testUpdateOrderUpdate() {
        Order obj = dod.getRandomOrder();
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Order' failed to provide an identifier", id);
        obj = orderService.findOrder(id);
        boolean modified =  dod.modifyOrder(obj);
        Integer currentVersion = obj.getVersion();
        Order merged = orderService.updateOrder(obj);
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Order' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void OrderIntegrationTest.testSaveOrder() {
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", dod.getRandomOrder());
        Order obj = dod.getNewTransientOrder(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Order' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Order' identifier to be null", obj.getId());
        try {
            orderService.saveOrder(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'Order' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void OrderIntegrationTest.testDeleteOrder() {
        Order obj = dod.getRandomOrder();
        Assert.assertNotNull("Data on demand for 'Order' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Order' failed to provide an identifier", id);
        obj = orderService.findOrder(id);
        orderService.deleteOrder(obj);
        obj.flush();
        Assert.assertNull("Failed to remove 'Order' with identifier '" + id + "'", orderService.findOrder(id));
    }
    
}
