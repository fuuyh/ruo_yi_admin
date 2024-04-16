package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.CustomerUser;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 用户 业务层
 *
 * @author ruoyi
 */
public interface ICustomerDetailsService
{

    /**
     *  根据用户名查询用户信息
     *
     * */

    CustomerUser selectCustomerUserByName(String username);
}
