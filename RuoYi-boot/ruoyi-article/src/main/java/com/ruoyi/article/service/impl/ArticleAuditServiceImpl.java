package com.ruoyi.article.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.article.mapper.ArticleAuditMapper;
import com.ruoyi.article.domain.ArticleAudit;
import com.ruoyi.article.service.IArticleAuditService;

/**
 * 文章审核Service业务层处理
 * 
 * @author fuyh
 * @date 2024-03-30
 */
@Service
public class ArticleAuditServiceImpl implements IArticleAuditService 
{
    @Autowired
    private ArticleAuditMapper articleAuditMapper;

    /**
     * 查询文章审核
     * 
     * @param id 文章审核主键
     * @return 文章审核
     */
    @Override
    public ArticleAudit selectArticleAuditById(Long id)
    {
        return articleAuditMapper.selectArticleAuditById(id);
    }

    /**
     * 查询文章审核列表
     * 
     * @param articleAudit 文章审核
     * @return 文章审核
     */
    @Override
    public List<ArticleAudit> selectArticleAuditList(ArticleAudit articleAudit)
    {
        return articleAuditMapper.selectArticleAuditList(articleAudit);
    }

    /**
     * 新增文章审核
     * 
     * @param articleAudit 文章审核
     * @return 结果
     */
    @Override
    public int insertArticleAudit(ArticleAudit articleAudit)
    {
        return articleAuditMapper.insertArticleAudit(articleAudit);
    }

    /**
     * 修改文章审核
     * 
     * @param articleAudit 文章审核
     * @return 结果
     */
    @Override
    public int updateArticleAudit(ArticleAudit articleAudit)
    {
        articleAudit.setUpdateTime(DateUtils.getNowDate());
        return articleAuditMapper.updateArticleAudit(articleAudit);
    }

    /**
     * 批量删除文章审核
     * 
     * @param ids 需要删除的文章审核主键
     * @return 结果
     */
    @Override
    public int deleteArticleAuditByIds(Long[] ids)
    {
        return articleAuditMapper.deleteArticleAuditByIds(ids);
    }

    /**
     * 删除文章审核信息
     * 
     * @param id 文章审核主键
     * @return 结果
     */
    @Override
    public int deleteArticleAuditById(Long id)
    {
        return articleAuditMapper.deleteArticleAuditById(id);
    }
}
