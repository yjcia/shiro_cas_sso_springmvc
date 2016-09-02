package com.newgrading.shiro.web.controller;

import com.newgrading.shiro.report.datasource.WebappDataSource;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @RequiresPermissions("report:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {

        return "report/list";
    }
    @RequiresPermissions("report:pdf_preview")
    @RequestMapping(value="/pdf_preview",method = RequestMethod.GET)
    public ModelAndView pdfPreview(ModelAndView modelAndView) {
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        // must have the data source!!!
        parameterMap.put("ReportTitle", "Address Report");
        parameterMap.put("datasource", new WebappDataSource());
        // pdfReport is the View of our application
        // This is declared inside the /WEB-INF/jasper-views.xml
        modelAndView = new ModelAndView("pdfReport", parameterMap);
        // Return the View and the Model combined
        return modelAndView;
    }

    @RequiresPermissions("report:html_preview")
    @RequestMapping(value="/html_preview",method = RequestMethod.GET)
    public ModelAndView htmlPreview(ModelAndView modelAndView) {
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        // must have the data source!!!
        parameterMap.put("ReportTitle", "Address Report");
        parameterMap.put("datasource", new WebappDataSource());
        // pdfReport is the View of our application
        // This is declared inside the /WEB-INF/jasper-views.xml
        modelAndView = new ModelAndView("htmlReport", parameterMap);
        // Return the View and the Model combined
        return modelAndView;
    }

}
