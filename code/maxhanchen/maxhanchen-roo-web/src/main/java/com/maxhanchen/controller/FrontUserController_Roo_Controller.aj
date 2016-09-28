// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.maxhanchen.controller;

import com.maxhanchen.controller.FrontUserController;
import com.maxhanchen.dao.po.FrontUser;
import com.maxhanchen.service.FrontUserService;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect FrontUserController_Roo_Controller {
    
    @Autowired
    FrontUserService FrontUserController.frontUserService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String FrontUserController.create(@Valid FrontUser frontUser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, frontUser);
            return "frontusers/create";
        }
        uiModel.asMap().clear();
        frontUserService.saveFrontUser(frontUser);
        return "redirect:/frontusers/" + encodeUrlPathSegment(frontUser.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String FrontUserController.createForm(Model uiModel) {
        populateEditForm(uiModel, new FrontUser());
        return "frontusers/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String FrontUserController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("frontuser", frontUserService.findFrontUser(id));
        uiModel.addAttribute("itemId", id);
        return "frontusers/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String FrontUserController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("frontusers", FrontUser.findFrontUserEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) frontUserService.countAllFrontUsers() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("frontusers", FrontUser.findAllFrontUsers(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "frontusers/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String FrontUserController.update(@Valid FrontUser frontUser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, frontUser);
            return "frontusers/update";
        }
        uiModel.asMap().clear();
        frontUserService.updateFrontUser(frontUser);
        return "redirect:/frontusers/" + encodeUrlPathSegment(frontUser.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String FrontUserController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, frontUserService.findFrontUser(id));
        return "frontusers/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String FrontUserController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        FrontUser frontUser = frontUserService.findFrontUser(id);
        frontUserService.deleteFrontUser(frontUser);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/frontusers";
    }
    
    void FrontUserController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("frontUser_createtime_date_format", "yyyy-MM-dd HH:mm:ss");
        uiModel.addAttribute("frontUser_updatetime_date_format", "yyyy-MM-dd HH:mm:ss");
    }
    
    void FrontUserController.populateEditForm(Model uiModel, FrontUser frontUser) {
        uiModel.addAttribute("frontUser", frontUser);
        addDateTimeFormatPatterns(uiModel);
    }
    
    String FrontUserController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}