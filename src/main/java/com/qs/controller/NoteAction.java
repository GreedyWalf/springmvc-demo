package com.qs.controller;

import com.qs.entity.note.NoteInfo;
import com.qs.entity.user.UserInfo;
import com.qs.service.NoteService;
import com.qs.utils.JsonStatus;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
@Controller
@RequestMapping(value = "/note")
public class NoteAction {
    @Resource
    private NoteService noteService;


    @InitBinder
    public void initBinder(ServletRequestDataBinder dataBinder) {
        CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss"), true);
        dataBinder.registerCustomEditor(NoteInfo.class, dateEditor);
    }

    @RequestMapping(value = "/noteIndex")
    public String noteIndex(Model model) {
        return "/note/noteIndex";
    }

    @RequestMapping(value = "/loadNoteList", method = RequestMethod.POST)
    @ResponseBody
    public List<NoteInfo> loadNoteList() {
        List<NoteInfo> noteInfoList = noteService.getNoteList();
        if (CollectionUtils.isEmpty(noteInfoList)) {
            return null;
        }

        return noteInfoList;
    }

    @RequestMapping(value = "/saveNote")
    public
    @ResponseBody
    JsonStatus saveNote(NoteInfo noteInfo, Model model) {
        if (noteInfo == null) {
            return null;
        }

        JsonStatus jsonStatus = new JsonStatus();
        noteInfo.setCreateTime(new Date());
        noteInfo.setLastModifyTime(new Date());
        noteService.saveOrUpdate(noteInfo);
        jsonStatus.setStatus(true);
        return jsonStatus;
    }

    @RequestMapping(value = "/deleteNote")
    @ResponseBody
    public JsonStatus deleteNote(String noteId, Model model) {
        noteService.delete(noteId);
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setStatus(true);
        return jsonStatus;
    }
}
