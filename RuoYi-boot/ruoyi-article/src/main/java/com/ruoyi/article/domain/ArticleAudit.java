package com.ruoyi.article.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章审核对象 article_audit
 * 
 * @author fuyh
 * @date 2024-03-30
 */
public class ArticleAudit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章审核id */
    private Long id;

    /** 文章id */
    @Excel(name = "文章id")
    private Long articleId;

    /** 审核状态 N 驳回 Y 通过 */
    @Excel(name = "审核状态 N 驳回 Y 通过")
    private String status;

    /** 驳回原因 */
    @Excel(name = "驳回原因")
    private String rejectCause;

    /** 操作人id */
    @Excel(name = "操作人id")
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setRejectCause(String rejectCause) 
    {
        this.rejectCause = rejectCause;
    }

    public String getRejectCause() 
    {
        return rejectCause;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("articleId", getArticleId())
            .append("status", getStatus())
            .append("rejectCause", getRejectCause())
            .append("userId", getUserId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
