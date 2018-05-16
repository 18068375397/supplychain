package com.xinyonghang.supplychain.core;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.SqlServerMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 *
 * @param <T>
 * @author chengjiawei
 * @date 2018年3月30日
 */
public interface Mapper<T>
        extends
        SqlServerMapper<T>,
        BaseSelectMapper<T>,
        BaseUpdateMapper<T>,
        BaseDeleteMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
