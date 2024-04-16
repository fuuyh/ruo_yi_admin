package com.ruoyi.framework.web.service;

import com.ruoyi.common.core.domain.entity.CustomerUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.CustomerDetailsMapper;
import com.ruoyi.system.service.ICustomerDetailsService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component("CustomerDetailsServiceImpl")
public class CustomerDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

//    @Autowired
//    private ICustomerDetailsService customerDetailsService;

    @Autowired
    CustomerDetailsMapper customerDetailsMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerUser member = customerDetailsMapper.selectCustomerUserByName(username);
        if (StringUtils.isNull(member)) {
    //        log.info("登录用户：{} 不存在.", username);
            throw new ServiceException("登录用户：" + username + " 不存在");
        }
        return createLoginUser(member);
    }


    public UserDetails createLoginUser(CustomerUser member) {
        return new LoginUser(member.getUserId(), member);
    }

}