package com.ruoyi.music.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.music.domain.MusicInfo;

/**
 * 歌曲信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-29
 */
public interface MusicInfoMapper extends BaseMapper<MusicInfo>
{
    /**
     * 查询歌曲信息
     * 
     * @param id 歌曲信息主键
     * @return 歌曲信息
     */
    public MusicInfo selectMusicInfoById(Long id);

    /**
     * 查询歌曲信息列表
     * 
     * @param musicInfo 歌曲信息
     * @return 歌曲信息集合
     */
    public List<MusicInfo> selectMusicInfoList(MusicInfo musicInfo);

    /**
     * 新增歌曲信息
     * 
     * @param musicInfo 歌曲信息
     * @return 结果
     */
    public int insertMusicInfo(MusicInfo musicInfo);

    /**
     * 修改歌曲信息
     * 
     * @param musicInfo 歌曲信息
     * @return 结果
     */
    public int updateMusicInfo(MusicInfo musicInfo);

    /**
     * 删除歌曲信息
     * 
     * @param id 歌曲信息主键
     * @return 结果
     */
    public int deleteMusicInfoById(Long id);

    /**
     * 批量删除歌曲信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMusicInfoByIds(Long[] ids);
}
