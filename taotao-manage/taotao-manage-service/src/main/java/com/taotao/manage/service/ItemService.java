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

import com.github.pagehelper.PageInfo;
import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;
import com.taotao.manage.pojo.ItemParamItem;


/**
 * 此类描述的是：商品service
 * @author: yuanhongqiu
 * @since : 2016年5月30日
 */
@Service
public class ItemService extends BaseService<Item>{
    
    @Autowired
    private ItemDescService itemDescService;
    
    @Autowired
    private ItemParamItemService itemParamItemService;
    
    
    @Autowired
    private ItemMapper itemMapper;

    /**
     * 保存商品
     * @param item
     */
	public void saveItem(Item item,String desc,String paramData) {
		item.setId(null);
		item.setStatus(1);
		super.save(item);
		//保存商品描述
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		this.itemDescService.save(itemDesc);
		
		ItemParamItem itemParamItem = new ItemParamItem();
		itemParamItem.setId(null);
		itemParamItem.setItemId(item.getId());
		itemParamItem.setParamData(paramData);
		itemParamItemService.save(itemParamItem);
	}

	/**
	 * 根据条件分页查询商品
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Item> querByPage(Integer page, Integer rows) {
		/*PageHelper.startPage(page, rows);
		Example example = new Example(Item.class);
		example.setOrderByClause("updated DESC"); 
		example.createCriteria().andEqualTo("status", 1);
		List<Item> list = this.itemMapper.selectByExample(example);
		PageInfo<Item> pageInfo = new PageInfo<Item>(list);*/
		Item item = new Item();
		item.setStatus(1);
		PageInfo<Item> pageInfo = null;
		try {
			pageInfo = super.queryListByPage(item, page, rows, "updated DESC");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	/**
	 * 更新商品
	 * @param item
	 * @param desc
	 */
	public void updateItem(Item item, String desc) {
		super.updateSelective(item);
		
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		this.itemDescService.updateSelective(itemDesc);
		
	}


}
