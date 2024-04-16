package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.CustomerUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.HashMap;

public class CustomerLoginController {

    @Autowired
    private TokenService tokenService;

    @Resource
    @Qualifier("CustomerDetailsManagerBean")
    private AuthenticationManager authenticationManager;

    /**
     * 会员登录验证
     *
     * @param shopUser
     * @return {@link String}
     */
    @PostMapping("/customer/user/login")
    public AjaxResult login(@RequestBody CustomerUser shopUser) {
        // 用户验证
        Authentication authentication;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(shopUser.getUserId(), shopUser.getPassword()));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new UserPasswordNotMatchException();
            } else {
                throw new ServiceException(e.getMessage());
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String token = tokenService.createToken(loginUser);
        // 生成token
        HashMap<String, Object> map = new HashMap<>();
        map.put("token",token);
        map.put("user",loginUser.getCustomerUser());
        return AjaxResult.success("登录成功",map);
    }

}
