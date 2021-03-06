package com.maxhanchen.roo.web.controller;
import com.maxhanchen.dao.po.DownLoadFile;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/downloadfiles")
@Controller
@RooWebScaffold(path = "downloadfiles", formBackingObject = DownLoadFile.class)
public class DownLoadFileController {
}
