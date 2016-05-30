/**
 * Copyright 2015-2016 
 * File Name：BasePojo.java
 *
 * ID: $Id$
 * Revision: $Rev$
 * Created: 2016年5月29日
 * Created By: yuanhongqiu
 * Last modified: $Date$
 * Last modified by: $Author$
 */
package com.taotao.manage.pojo;

import java.util.Date;


/**
 * 此类描述的是：Pojo父类
 * @author: yuanhongqiu
 * @since : 2016年5月29日
 */
public class BasePojo {
    
    private Date created;
    
    private Date updated;

    /**
     * created
     *
     * @return  the created
     * @since   2016年5月29日
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * updated
     *
     * @return  the updated
     * @since   2016年5月29日
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated the updated to set
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    
    
    
    

}
