package com.ruoyi.article.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.article.domain.ArticleAudit;
import com.ruoyi.article.service.IArticleAuditService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章审核Controller
 * 
 * @author fuyh
 * @date 2024-03-30
 */
@RestController
@RequestMapping("/article/audit")
public class ArticleAuditController extends BaseController
{
    @Autowired
    private IArticleAuditService articleAuditService;

    /**
     * 查询文章审核列表
     */
    @PreAuthorize("@ss.hasPermi('article:audit:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArticleAudit articleAudit)
    {
        startPage();
        List<ArticleAudit> list = articleAuditService.selectArticleAuditList(articleAudit);
        return getDataTable(list);
    }

    /**
     * 导出文章审核列表
     */
    @PreAuthorize("@ss.hasPermi('article:audit:export')")
    @Log(title = "文章审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ArticleAudit articleAudit)
    {
        List<ArticleAudit> list = articleAuditService.selectArticleAuditList(articleAudit);
        ExcelUtil<ArticleAudit> util = new ExcelUtil<ArticleAudit>(ArticleAudit.class);
        util.exportExcel(response, list, "文章审核数据");
    }

    /**
     * 获取文章审核详细信息
     */
    @PreAuthorize("@ss.hasPermi('article:audit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(articleAuditService.selectArticleAuditById(id));
    }

    /**
     * 新增文章审核
     */
    @PreAuthorize("@ss.hasPermi('article:audit:add')")
    @Log(title = "文章审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArticleAudit articleAudit)
    {
        return toAjax(articleAuditService.insertArticleAudit(articleAudit));
    }

    /**
     * 修改文章审核
     */
    @PreAuthorize("@ss.hasPermi('article:audit:edit')")
    @Log(title = "文章审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArticleAudit articleAudit)
    {
        return toAjax(articleAuditService.updateArticleAudit(articleAudit));
    }

    /**
     * 删除文章审核
     */
    @PreAuthorize("@ss.hasPermi('article:audit:remove')")
    @Log(title = "文章审核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(articleAuditService.deleteArticleAuditByIds(ids));
    }
}
