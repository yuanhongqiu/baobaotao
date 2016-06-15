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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;


/**
 * 此类描述的是：商品类目service
 * @author: yuanhongqiu
 * @since : 2016年5月30日
 */
@Service
public class ItemCatService extends BaseService<ItemCat>{
    
    @Autowired
    private ItemCatMapper itemCatMapper;
    
    /**
     * 根据父节点ID查询所有节点
     * @return
     */
    public List<ItemCat> queryListItemCatByParentId(Long parentId){
    	ItemCat itemCat = new ItemCat();
    	itemCat.setParentId(parentId);
    	return this.queryByCondition(itemCat);
    }


}
