package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.entity.CustomerUser;

/**
 * 用户与角色关联表 数据层
 *
 * @author ruoyi
 */
public interface CustomerDetailsMapper
{
    CustomerUser selectCustomerUserByName(String username);
}
