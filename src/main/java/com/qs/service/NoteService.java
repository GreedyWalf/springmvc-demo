package com.qs.service;

import com.qs.entity.note.NoteInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public interface NoteService {

    /**
     * 保存笔记信息
     */
    void saveOrUpdate(NoteInfo noteInfo);

    /**
     *  获取全部的笔记列表
     */
    List<NoteInfo> getNoteList();

    void delete(String noteId);
}
