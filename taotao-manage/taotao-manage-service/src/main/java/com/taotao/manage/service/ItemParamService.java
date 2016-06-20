/**
 * 
 */
package com.taotao.manage.service;

import org.springframework.stereotype.Service;

import com.taotao.manage.pojo.ItemParam;

/**
 * @author hc-3020-i3
 *
 */
@Service
public class ItemParamService extends BaseService<ItemParam>{

	/**
	 * 根据类目ID查询类目的模板
	 * @param itemCatId
	 * @return
	 */
	public ItemParam queryItemParamByItemCatId(Long itemCatId) {
		ItemParam itemParam = new ItemParam();
		itemParam.setItemCatId(itemCatId);
		
		ItemParam result = super.queryOne(itemParam);
		return result;
	}

	/**
	 * 保存模板
	 * @param itemCatId
	 * @param paramData
	 */
	public void saveItemParam(Long itemCatId, String paramData) {
		ItemParam itemParam = new ItemParam();
		itemParam.setId(null);
		itemParam.setItemCatId(itemCatId);
		itemParam.setParamData(paramData);
		
		super.save(itemParam);
	}

}
