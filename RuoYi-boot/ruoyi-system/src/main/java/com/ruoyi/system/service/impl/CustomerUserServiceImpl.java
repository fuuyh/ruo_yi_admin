package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.CustomerUser;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CustomerUserMapper;
import com.ruoyi.system.service.ICustomerUserService;

/**
 * 用户信息Service业务层处理
 * 
 * @author fuyh
 * @date 2024-04-11
 */
@Service
public class CustomerUserServiceImpl implements ICustomerUserService 
{
    @Autowired
    private CustomerUserMapper customerUserMapper;

    /**
     * 查询用户信息
     * 
     * @param userId 用户信息主键
     * @return 用户信息
     */
    @Override
    public CustomerUser selectCustomerUserByUserId(Long userId)
    {
        return customerUserMapper.selectCustomerUserByUserId(userId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param customerUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<CustomerUser> selectCustomerUserList(CustomerUser customerUser)
    {
        return customerUserMapper.selectCustomerUserList(customerUser);
    }

    /**
     * 新增用户信息
     * 
     * @param customerUser 用户信息
     * @return 结果
     */
    @Override
    public int insertCustomerUser(CustomerUser customerUser)
    {
        customerUser.setCreateTime(DateUtils.getNowDate());
        return customerUserMapper.insertCustomerUser(customerUser);
    }

    /**
     * 修改用户信息
     * 
     * @param customerUser 用户信息
     * @return 结果
     */
    @Override
    public int updateCustomerUser(CustomerUser customerUser)
    {
        customerUser.setUpdateTime(DateUtils.getNowDate());
        return customerUserMapper.updateCustomerUser(customerUser);
    }

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteCustomerUserByUserIds(Long[] userIds)
    {
        return customerUserMapper.deleteCustomerUserByUserIds(userIds);
    }

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteCustomerUserByUserId(Long userId)
    {
        return customerUserMapper.deleteCustomerUserByUserId(userId);
    }
}
