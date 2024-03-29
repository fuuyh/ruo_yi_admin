package com.ruoyi.music.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.music.mapper.MusicInfoMapper;
import com.ruoyi.music.domain.MusicInfo;
import com.ruoyi.music.service.IMusicInfoService;

/**
 * 歌曲信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-29
 */
@Service
public class MusicInfoServiceImpl implements IMusicInfoService 
{
    @Autowired
    private MusicInfoMapper musicInfoMapper;

    /**
     * 查询歌曲信息
     * 
     * @param id 歌曲信息主键
     * @return 歌曲信息
     */
    @Override
    public MusicInfo selectMusicInfoById(Long id)
    {
        return musicInfoMapper.selectMusicInfoById(id);
    }

    /**
     * 查询歌曲信息列表
     * 
     * @param musicInfo 歌曲信息
     * @return 歌曲信息
     */
    @Override
    public List<MusicInfo> selectMusicInfoList(MusicInfo musicInfo)
    {
        return musicInfoMapper.selectMusicInfoList(musicInfo);
    }

    /**
     * 新增歌曲信息
     * 
     * @param musicInfo 歌曲信息
     * @return 结果
     */
    @Override
    public int insertMusicInfo(MusicInfo musicInfo)
    {
        return musicInfoMapper.insertMusicInfo(musicInfo);
    }

    /**
     * 修改歌曲信息
     * 
     * @param musicInfo 歌曲信息
     * @return 结果
     */
    @Override
    public int updateMusicInfo(MusicInfo musicInfo)
    {
        return musicInfoMapper.updateMusicInfo(musicInfo);
    }

    /**
     * 批量删除歌曲信息
     * 
     * @param ids 需要删除的歌曲信息主键
     * @return 结果
     */
    @Override
    public int deleteMusicInfoByIds(Long[] ids)
    {
        return musicInfoMapper.deleteMusicInfoByIds(ids);
    }

    /**
     * 删除歌曲信息信息
     * 
     * @param id 歌曲信息主键
     * @return 结果
     */
    @Override
    public int deleteMusicInfoById(Long id)
    {
        return musicInfoMapper.deleteMusicInfoById(id);
    }
}
