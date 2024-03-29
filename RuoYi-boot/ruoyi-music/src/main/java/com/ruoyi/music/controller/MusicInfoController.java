package com.ruoyi.music.controller;

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
import com.ruoyi.music.domain.MusicInfo;
import com.ruoyi.music.service.IMusicInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 歌曲信息Controller
 * 
 * @author ruoyi
 * @date 2024-03-29
 */
@RestController
@RequestMapping("/music/info")
public class MusicInfoController extends BaseController
{
    @Autowired
    private IMusicInfoService musicInfoService;

    /**
     * 查询歌曲信息列表
     */
    @PreAuthorize("@ss.hasPermi('music:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(MusicInfo musicInfo)
    {
        startPage();
        List<MusicInfo> list = musicInfoService.selectMusicInfoList(musicInfo);
        return getDataTable(list);
    }

    /**
     * 导出歌曲信息列表
     */
    @PreAuthorize("@ss.hasPermi('music:info:export')")
    @Log(title = "歌曲信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MusicInfo musicInfo)
    {
        List<MusicInfo> list = musicInfoService.selectMusicInfoList(musicInfo);
        ExcelUtil<MusicInfo> util = new ExcelUtil<MusicInfo>(MusicInfo.class);
        util.exportExcel(response, list, "歌曲信息数据");
    }

    /**
     * 获取歌曲信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('music:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(musicInfoService.selectMusicInfoById(id));
    }

    /**
     * 新增歌曲信息
     */
    @PreAuthorize("@ss.hasPermi('music:info:add')")
    @Log(title = "歌曲信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MusicInfo musicInfo)
    {
        return toAjax(musicInfoService.insertMusicInfo(musicInfo));
    }

    /**
     * 修改歌曲信息
     */
    @PreAuthorize("@ss.hasPermi('music:info:edit')")
    @Log(title = "歌曲信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MusicInfo musicInfo)
    {
        return toAjax(musicInfoService.updateMusicInfo(musicInfo));
    }

    /**
     * 删除歌曲信息
     */
    @PreAuthorize("@ss.hasPermi('music:info:remove')")
    @Log(title = "歌曲信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(musicInfoService.deleteMusicInfoByIds(ids));
    }
}
