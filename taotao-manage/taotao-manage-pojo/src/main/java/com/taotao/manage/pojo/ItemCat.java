package com.taotao.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 此类描述的是：商品类目
 * @author: yuanhongqiu
 * @since : 2016年5月30日
 */
@Table(name="tb_item_cat")
public class ItemCat extends BasePojo{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Boolean isParent;
    
    // 扩展easyui的text属性
    public String getText() {
        return this.name;
    }

    public String getState() {
        return this.isParent ? "closed" : "open";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

	@Override
	public String toString() {
		return "ItemCat [id=" + id + ", parentId=" + parentId + ", name="
				+ name + ", status=" + status + ", sortOrder=" + sortOrder
				+ ", isParent=" + isParent + "]";
	}
    
}