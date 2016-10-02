package com.maxhanchen.roo.web.controller;
import com.maxhanchen.dao.po.FrontUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/frontusers")
@Controller
@RooWebScaffold(path = "frontusers", formBackingObject = FrontUser.class)
public class FrontUserController {
}
