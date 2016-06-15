package com.taotao.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 此类描述的是：商品描述
 * 
 * @author: yuanhongqiu
 * @since : 2016年5月30日
 */
@Table(name = "tb_item_desc")
public class ItemDesc extends BasePojo {

	@Id
	private Long itemId;

	private String itemDesc;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Override
	public String toString() {
		return "ItemDesc [itemId=" + itemId + ", itemDesc=" + itemDesc + "]";
	}

}