// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.dao.service;

import com.maxhanchen.dao.po.Product;
import com.maxhanchen.dao.service.ProductService;
import java.util.List;

privileged aspect ProductService_Roo_Service {
    
    public abstract long ProductService.countAllProducts();    
    public abstract void ProductService.deleteProduct(Product product);    
    public abstract Product ProductService.findProduct(Long id);    
    public abstract List<Product> ProductService.findAllProducts();    
    public abstract List<Product> ProductService.findProductEntries(int firstResult, int maxResults);    
    public abstract void ProductService.saveProduct(Product product);    
    public abstract Product ProductService.updateProduct(Product product);    
}