package com.qs.service;

import com.qs.entity.note.NoteInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public interface NoteService {

    /**
     * 新增笔记
     */
    void save(NoteInfo noteInfo);

    /**
     * 获取所有笔记信息
     */
    List<NoteInfo> getNoteList();
}
