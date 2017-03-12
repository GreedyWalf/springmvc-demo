package com.qs.service.impl;

import com.qs.entity.note.NoteInfo;
import com.qs.service.NoteService;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
@Service(value = "noteService")
public class NoteServiceImpl implements NoteService {
    @Resource
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(NoteInfo noteInfo){
        Session session = sessionFactory.getCurrentSession();
        Serializable s = session.save(noteInfo);
        System.out.println("===========>  s=" + s.toString());
    }

    public List<NoteInfo> getNoteList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from NoteInfo order by createTime desc");
        return query.list();
    }

    public void delete(String noteId) {
        Session session = getSession();
        NoteInfo noteInfo = (NoteInfo) session.load(NoteInfo.class, noteId);
        if(noteInfo != null){
            session.delete(noteInfo);
        }
    }
}
