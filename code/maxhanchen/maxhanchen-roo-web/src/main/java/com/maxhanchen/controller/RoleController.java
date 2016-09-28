package com.maxhanchen.controller;
import com.maxhanchen.dao.po.Role;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/roles")
@Controller
@RooWebScaffold(path = "roles", formBackingObject = Role.class)
public class RoleController {
}
