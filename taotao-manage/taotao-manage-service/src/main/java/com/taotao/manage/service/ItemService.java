/**
 * Copyright 2015-2016 
 * File Name：ItemService.java
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
import org.springframework.stereotype.Service;

import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;


/**
 * 此类描述的是：商品service
 * @author: yuanhongqiu
 * @since : 2016年5月30日
 */
@Service
public class ItemService extends BaseService<Item>{
    
    @Autowired
    private ItemMapper itemMapper;


}
