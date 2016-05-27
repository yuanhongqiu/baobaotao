/**
 * Copyright 2015-2016 
 * File Name：PageController.java
 *
 * ID: $Id$
 * Revision: $Rev$
 * Created: 2016年5月26日
 * Created By: yuanhongqiu
 * Last modified: $Date$
 * Last modified by: $Author$
 */
package com.taotao.manage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 此类描述的是：TODO:
 * @author: yuanhongqiu
 * @since : 2016年5月26日
 */
@RequestMapping("page")
@Controller
public class PageController {
    
    /**
     * 
     * @此方法的描述:通用跳转controller
     * @category
     * @author: yuanhongqiu
     * @since: 2016年5月26日
     * @param pageName
     * @return
     */
    @RequestMapping(value="{pageName}",method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }

}
