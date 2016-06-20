/**
 * 
 */
package com.taotao.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hc-3020-i3
 *
 */
@Table(name="tb_item_param_item")
public class ItemParamItem extends BasePojo{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long itemId;
	
	private String paramData;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the itemCatId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * @param itemCatId the itemCatId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the paramData
	 */
	public String getParamData() {
		return paramData;
	}

	/**
	 * @param paramData the paramData to set
	 */
	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemParam [id=" + id + ", itemId=" + itemId + ", paramData=" + paramData + "]";
	}
	
	

}
