/**
 * Copyright 2015-2016 
 * File Name：BaseService.java
 *
 * ID: $Id$
 * Revision: $Rev$
 * Created: 2016年5月27日
 * Created By: yuanhongqiu
 * Last modified: $Date$
 * Last modified by: $Author$
 */
package com.taotao.manage.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manage.pojo.BasePojo;

/**
 * 此类描述的是：Service的基类
 * 
 * @author: yuanhongqiu
 * @since : 2016年5月27日
 */
public abstract class BaseService<T extends BasePojo> {

    public abstract Mapper<T> getMapper();

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseService() {
        super();

        Type type = this.getClass().getGenericSuperclass();

        ParameterizedType pType = (ParameterizedType) type;
        this.clazz = (Class<T>) pType.getActualTypeArguments()[0];
    }

    /**
     * 
     * @此方法的描述:根据ID查询对象
     * @category author: yuanhongqiu
     * @since: 2016年5月29日
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return this.getMapper().selectByPrimaryKey(id);
    }

    /**
     * 
     * @此方法的描述:查询所有
     * @category author: yuanhongqiu
     * @since: 2016年5月29日
     * @return
     */
    public List<T> queryAll() {
        return this.getMapper().select(null);
    }

    /**
     * 
     * @此方法的描述:查询总条数
     * @category author: yuanhongqiu
     * @since: 2016年5月29日
     * @return
     */
    public Integer queryCounts() {

        return this.getMapper().selectCount(null);

    }

    /**
     * 
     * @此方法的描述:根据条件查询
     * @category author: yuanhongqiu
     * @since: 2016年5月29日
     * @param t
     * @return
     */
    public List<T> queryByCondition(T t) {
        return this.getMapper().selectByExample(t);
    }

    /**
     * 
     * @此方法的描述:分页查询
     * @category author: yuanhongqiu
     * @since: 2016年5月29日
     * @param t
     * @param page
     * @param rows
     * @return
     */
    public PageInfo querByPage(T t, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<T> list = this.getMapper().select(t);
        return new PageInfo<T>(list);
    }

    /**
     * 
     * @此方法的描述:根据条件查询一条数据
     * @category author: yuanhongqiu
     * @since: 2016年5月29日
     * @param t
     * @return
     */
    public T queryOne(T t) {
        return this.getMapper().select(t).get(0);
    }

    /**
     * 
     * @此方法的描述:保存
     * @category author: yuanhongqiu
     * @since: 2016年5月29日
     * @param t
     * @return
     */
    public Integer save(T t) {
        t.setCreated(new Date());
        t.setUpdated(t.getCreated());
        return this.getMapper().insert(t);
    }
    
    /**
     * 
     * @此方法的描述:保存  忽略空字段
     * @category
     * @author: yuanhongqiu
     * @since: 2016年5月29日
     * @param t
     * @return
     */
    public Integer saveSelective(T t){
        t.setCreated(new Date());
        t.setUpdated(t.getCreated());
        return this.getMapper().insertSelective(t);
    }
    
    /**
     * 
     * @此方法的描述:更新
     * @category
     * @author: yuanhongqiu
     * @since: 2016年5月29日
     * @param t
     * @return
     */
    public Integer update(T t){
        t.setUpdated(new Date());
        return this.getMapper().updateByPrimaryKey(t);
    }
    
    /**
     * 
     * @此方法的描述:更新  忽略空字段
     * @category
     * @author: yuanhongqiu
     * @since: 2016年5月29日
     * @param t
     * @return
     */
    public Integer updateSelective(T  t){
        t.setUpdated(new Date());
        return this.getMapper().updateByPrimaryKeySelective(t);
    }
    
    /**
     * 
     * @此方法的描述:根据ID删除
     * @category
     * @author: yuanhongqiu
     * @since: 2016年5月29日
     * @param id
     * @return
     */
    public Integer deleteById(Long id){
        return this.getMapper().deleteByPrimaryKey(id);
    }
    
    /**
     * 
     * @此方法的描述:根据ID批量删除
     * @category
     * @author: yuanhongqiu
     * @since: 2016年5月29日
     * @return
     */
    public Integer deleteByIds(List<Object> ids){
        Example example = new Example(this.clazz);
        example.createCriteria().andIn("id", ids);
        return this.getMapper().deleteByExample(example);
    }
}
