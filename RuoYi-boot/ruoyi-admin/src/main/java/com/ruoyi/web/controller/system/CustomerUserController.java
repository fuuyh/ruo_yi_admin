package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.CustomerUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ICustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户信息Controller
 * 
 * @author fuyh
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/system/customerUser")
public class CustomerUserController extends BaseController
{
    @Autowired
    private ICustomerUserService customerUserService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:customerUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(CustomerUser customerUser)
    {
        startPage();
        List<CustomerUser> list = customerUserService.selectCustomerUserList(customerUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:customerUser:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CustomerUser customerUser)
    {
        List<CustomerUser> list = customerUserService.selectCustomerUserList(customerUser);
        ExcelUtil<CustomerUser> util = new ExcelUtil<CustomerUser>(CustomerUser.class);
        util.exportExcel(response, list, "用户信息数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:customerUser:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(customerUserService.selectCustomerUserByUserId(userId));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:customerUser:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CustomerUser customerUser)
    {
        return toAjax(customerUserService.insertCustomerUser(customerUser));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:customerUser:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CustomerUser customerUser)
    {
        return toAjax(customerUserService.updateCustomerUser(customerUser));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:customerUser:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(customerUserService.deleteCustomerUserByUserIds(userIds));
    }
}
