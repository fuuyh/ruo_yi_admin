package com.ruoyi.article.service;

import java.util.List;
import com.ruoyi.article.domain.ArticleAudit;

/**
 * 文章审核Service接口
 * 
 * @author fuyh
 * @date 2024-03-30
 */
public interface IArticleAuditService 
{
    /**
     * 查询文章审核
     * 
     * @param id 文章审核主键
     * @return 文章审核
     */
    public ArticleAudit selectArticleAuditById(Long id);

    /**
     * 查询文章审核列表
     * 
     * @param articleAudit 文章审核
     * @return 文章审核集合
     */
    public List<ArticleAudit> selectArticleAuditList(ArticleAudit articleAudit);

    /**
     * 新增文章审核
     * 
     * @param articleAudit 文章审核
     * @return 结果
     */
    public int insertArticleAudit(ArticleAudit articleAudit);

    /**
     * 修改文章审核
     * 
     * @param articleAudit 文章审核
     * @return 结果
     */
    public int updateArticleAudit(ArticleAudit articleAudit);

    /**
     * 批量删除文章审核
     * 
     * @param ids 需要删除的文章审核主键集合
     * @return 结果
     */
    public int deleteArticleAuditByIds(Long[] ids);

    /**
     * 删除文章审核信息
     * 
     * @param id 文章审核主键
     * @return 结果
     */
    public int deleteArticleAuditById(Long id);
}
