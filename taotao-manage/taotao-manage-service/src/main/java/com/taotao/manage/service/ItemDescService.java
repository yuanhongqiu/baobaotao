/**
 * Copyright 2015-2016 
 * File Name：ItemDescService.java
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
import com.taotao.manage.mapper.ItemDescMapper;
import com.taotao.manage.pojo.ItemDesc;


/**
 * 此类描述的是：商品描述service
 * @author: yuanhongqiu
 * @since : 2016年5月30日
 */
public class ItemDescService extends BaseService<ItemDesc> {
    
    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    public Mapper<ItemDesc> getMapper() {
        return itemDescMapper;
    }

}
