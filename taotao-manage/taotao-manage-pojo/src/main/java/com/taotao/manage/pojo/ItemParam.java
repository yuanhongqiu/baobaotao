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
@Table(name="tb_item_param")
public class ItemParam extends BasePojo{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long itemCatId;
	
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
	public Long getItemCatId() {
		return itemCatId;
	}

	/**
	 * @param itemCatId the itemCatId to set
	 */
	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
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
		return "ItemParam [id=" + id + ", itemCatId=" + itemCatId + ", paramData=" + paramData + "]";
	}
	
	

}
