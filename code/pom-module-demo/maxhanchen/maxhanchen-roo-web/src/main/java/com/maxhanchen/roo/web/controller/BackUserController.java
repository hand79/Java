package com.maxhanchen.roo.web.controller;
import com.maxhanchen.dao.po.BackUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/backusers")
@Controller
@RooWebScaffold(path = "backusers", formBackingObject = BackUser.class)
public class BackUserController {
}
