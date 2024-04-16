package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.CustomerUser;

/**
 * 用户信息Mapper接口
 * 
 * @author fuyh
 * @date 2024-04-11
 */
public interface CustomerUserMapper 
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息主键
     * @return 用户信息
     */
    public CustomerUser selectCustomerUserByUserId(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param customerUser 用户信息
     * @return 用户信息集合
     */
    public List<CustomerUser> selectCustomerUserList(CustomerUser customerUser);

    /**
     * 新增用户信息
     * 
     * @param customerUser 用户信息
     * @return 结果
     */
    public int insertCustomerUser(CustomerUser customerUser);

    /**
     * 修改用户信息
     * 
     * @param customerUser 用户信息
     * @return 结果
     */
    public int updateCustomerUser(CustomerUser customerUser);

    /**
     * 删除用户信息
     * 
     * @param userId 用户信息主键
     * @return 结果
     */
    public int deleteCustomerUserByUserId(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCustomerUserByUserIds(Long[] userIds);
}
