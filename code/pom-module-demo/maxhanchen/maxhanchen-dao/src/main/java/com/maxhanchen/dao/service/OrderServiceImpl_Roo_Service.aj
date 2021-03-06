// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.service;

import com.maxhanchen.dao.po.Order;
import com.maxhanchen.dao.service.OrderServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect OrderServiceImpl_Roo_Service {
    
    declare @type: OrderServiceImpl: @Service;
    
    declare @type: OrderServiceImpl: @Transactional;
    
    public long OrderServiceImpl.countAllOrders() {
        return Order.countOrders();
    }
    
    public void OrderServiceImpl.deleteOrder(Order order) {
        order.remove();
    }
    
    public Order OrderServiceImpl.findOrder(Long id) {
        return Order.findOrder(id);
    }
    
    public List<Order> OrderServiceImpl.findAllOrders() {
        return Order.findAllOrders();
    }
    
    public List<Order> OrderServiceImpl.findOrderEntries(int firstResult, int maxResults) {
        return Order.findOrderEntries(firstResult, maxResults);
    }
    
    public void OrderServiceImpl.saveOrder(Order order) {
        order.persist();
    }
    
    public Order OrderServiceImpl.updateOrder(Order order) {
        return order.merge();
    }
    
}
