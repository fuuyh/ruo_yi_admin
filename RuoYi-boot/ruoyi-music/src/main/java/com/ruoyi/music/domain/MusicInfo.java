package com.ruoyi.music.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 歌曲信息对象 music_info
 * 
 * @author ruoyi
 * @date 2024-03-29
 */
public class MusicInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 音频地址 */
    @Excel(name = "音频地址")
    private String musicAddress;

    /** 歌词地址 */
    @Excel(name = "歌词地址")
    private String lyricAddress;

    /** 音频封面图片 */
    @Excel(name = "音频封面图片")
    private String musicCover;

    /** 作者 */
    @Excel(name = "作者")
    private String musicAuthor;

    /** 标题 */
    @Excel(name = "标题")
    private String musicTitle;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMusicAddress(String musicAddress) 
    {
        this.musicAddress = musicAddress;
    }

    public String getMusicAddress() 
    {
        return musicAddress;
    }
    public void setLyricAddress(String lyricAddress) 
    {
        this.lyricAddress = lyricAddress;
    }

    public String getLyricAddress() 
    {
        return lyricAddress;
    }
    public void setMusicCover(String musicCover) 
    {
        this.musicCover = musicCover;
    }

    public String getMusicCover() 
    {
        return musicCover;
    }
    public void setMusicAuthor(String musicAuthor) 
    {
        this.musicAuthor = musicAuthor;
    }

    public String getMusicAuthor() 
    {
        return musicAuthor;
    }
    public void setMusicTitle(String musicTitle) 
    {
        this.musicTitle = musicTitle;
    }

    public String getMusicTitle() 
    {
        return musicTitle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("musicAddress", getMusicAddress())
            .append("lyricAddress", getLyricAddress())
            .append("musicCover", getMusicCover())
            .append("musicAuthor", getMusicAuthor())
            .append("musicTitle", getMusicTitle())
            .toString();
    }
}
