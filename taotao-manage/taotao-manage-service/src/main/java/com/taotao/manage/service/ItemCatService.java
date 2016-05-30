/**
 * Copyright 2015-2016 
 * File Name：ItemCatService.java
 *
 * ID: $Id$
 * Revision: $Rev$
 * Created: 2016年5月30日
 * Created By: yuanhongqiu
 * Last modified: $Date$
 * Last modified by: $Author$
 */
package com.taotao.manage.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.mapper.Mapper;
import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;


/**
 * 此类描述的是：
 * @author: yuanhongqiu
 * @since : 2016年5月30日
 */
public class ItemCatService extends BaseService<ItemCat>{
    
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public Mapper<ItemCat> getMapper() {
        return itemCatMapper;
    }

}
